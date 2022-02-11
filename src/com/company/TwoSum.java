package com.company;

import java.util.Arrays;

public class TwoSum {
    public static void solution (int[] nums, int target)
    {
        int p1 = 0;
        int p2 = p1 + 1;
        int [] result = new int [2];
        while (p2 < nums.length && p1 < p2){
            if (nums[p1] + nums[p2] == target){
                result[0] = p1;
                result[1] = p2;
                break;
            }
            if (p2 == nums.length-1){
                p1++;
                p2 = p1 + 1;
                continue;
            }

            p2++;

        }
        System.out.println("The two sum is : "+ Arrays.toString(result));
    }
}
