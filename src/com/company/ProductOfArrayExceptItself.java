package com.company;

import java.util.Arrays;

public class ProductOfArrayExceptItself {
    public static void solution (int [] nums)
    {
        int length = nums.length;

        int ans[] = new int[length];

        //multiplying and storing the prefix
        ans[0] = 1;
        for(int i = 1; i < length; i++) {
            ans[i] = nums[i-1] * ans[i-1];
        }

        //multiplying and storing the postfix
        int R = 1;
        for(int i=length-1; i>=0; i--) {
            ans[i] *= R;
            R *= nums[i];
        }

        System.out.println("This is the Product of Array except itself "+ Arrays.toString(ans));
    }
}
