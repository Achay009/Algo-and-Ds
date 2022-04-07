package com.company;

public class HappyStrings {
    public static void solution(int a, int b, int c)
    {
        //
        StringBuilder output = new StringBuilder("");
        int total = a + b + c;
        int currA = 0;
        int currB = 0;
        int currC = 0;
        int aCount = a;
        int bCount = b;
        int cCount = c;
        if (total == 0) System.out.println("Ths Longest Happy String is " + output.toString());
        for (int i = 0; i < total; i++){
            if((aCount >= bCount && aCount >= cCount && currA != 2) || (aCount > 0 && (currB == 2 || currC == 2))){
                output.append("a");
                aCount--;
                currA++;
                currB = 0;
                currC = 0;
            }else if ((bCount >= aCount && bCount >= cCount && currB != 2) || (bCount > 0 && (currA == 2 || currC == 2))){
                output.append("b");
                bCount--;
                currB++;
                currA = 0;
                currC = 0;
            }else if ((cCount >= bCount && cCount >= aCount && currC != 2) || (cCount > 0 && (currB == 2 || currA == 2))){
                output.append("c");
                cCount--;
                currC++;
                currA = 0;
                currB = 0;
            }
        }

        System.out.println("Ths Longest Happy String is " + output.toString());
    }

}
