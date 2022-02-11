package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanSum {
    public static void solution (int targetSum, int [] array)
    {
        Map<Integer, Boolean> memo = new HashMap<>();
        System.out.println("The result of the can sum algo " + " with targetSum "+ targetSum + " and array "+ Arrays.toString(array) + " : " + canSum(targetSum,array, memo));
    }

    public static boolean canSum(int targetSum, int [] array, Map<Integer, Boolean> memo)
    {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int num : array){
            int remainder = targetSum - num;
            if (canSum(remainder, array, memo) == true){
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

}
