package com.company;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    public static void solution(int [] nums, int k)
    {
        int currentSum = 0;
        int diff = 0;
        int result = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        for (int i = 0; i < nums.length; i++){
            currentSum += nums[i];
            diff = currentSum - k;
            result += prefixSum.getOrDefault(diff, 0);
            prefixSum.put(currentSum, 1 + prefixSum.getOrDefault(currentSum, 0));
        }

        System.out.println("Sub Array Sum of  K="+k+" : "+ result);
    }
}
