package com.company;

import java.util.Arrays;

public class SumZero {
    public static  void solution (int n)
    {
        int [] res = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++){
            res[i] = i;
            total+=i;
        }

        res[0] = -total;
        System.out.println("Solution to Sum Zero  : "+ Arrays.toString(res));
    }
}
