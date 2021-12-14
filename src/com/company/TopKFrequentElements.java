package com.company;

import java.util.*;

public class TopKFrequentElements {
    public static void solution(int[] nums, int k)
    {
        Map<Integer, Integer> count  = new HashMap<>();
        ArrayList<ArrayList<Integer>> freq = new ArrayList<>(k+1);
        for (int i = 0; i < nums.length; i++){
            count.put(nums[i], 1 + count.getOrDefault(nums[i],0));
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()){
            ArrayList holder = freq.get(entry.getValue()) != null ? freq.get(entry.getValue()) : new ArrayList();
            holder.add(entry.getKey());
            freq.add(entry.getValue(),holder);
        }
//        int [] result = new int [k];

        System.out.println(freq);
    }
}
