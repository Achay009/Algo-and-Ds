package com.company;

import java.util.*;

public class HowSum {
    public static void solution(int targetSum, int [] array)
    {
        Map<Integer, ArrayList<Integer>> memo = new HashMap<>();
       ArrayList<Integer> result = howSum(targetSum, array, memo);
        System.out.println("The result of the HowSum algo " + " with targetSum "+ targetSum + " and array "+ Arrays.toString(array) + " : " + result);
    }

    public static ArrayList<Integer> howSum (int targetSum, int [] array, Map<Integer, ArrayList<Integer>> memo)
    {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new ArrayList<>(0);
        if (targetSum < 0) return null;

        for ( int num : array){
            int remainder = targetSum - num;
            ArrayList <Integer> remainderArray = howSum(remainder, array, memo);
            if (! Objects.isNull(remainderArray)){
                remainderArray.add(num);
                memo.put(targetSum, remainderArray);
                return memo.get(targetSum);
            }
        }
        memo.put(targetSum, null);
        return null;
    }

}
