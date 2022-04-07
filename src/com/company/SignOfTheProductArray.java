package com.company;

public class SignOfTheProductArray {
    public static void solution(int [] num)
    {
        System.out.println("The Sign of the product Array is : "+ signOfProductArray(num));
    }

    private static int signOfProductArray(int[] num) {
        double multiple = 1;
        for (int i = 0; i < num.length; i++){
            if (num[i] == 0) return 0;
            multiple*=num[i];
        }
        if (multiple < 0){
            return -1;
        }
        if (multiple > 0){
            return 1;
        }
        return 0;
    }
}
