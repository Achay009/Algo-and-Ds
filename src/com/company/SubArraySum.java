package com.company;

public class SubArraySum {
    public static void solution(int [] nums, int k)
    {
        int windowStart = 0;
        int sum = 0;
        int totalNumber = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++){
                sum += nums[windowEnd];

                if (sum >= k){
                    totalNumber++;
                    sum-= nums[windowStart];
                    windowStart++;
                }
        }

        System.out.println("Sub Array Sum of  K="+k+" : "+ totalNumber);
    }
}
