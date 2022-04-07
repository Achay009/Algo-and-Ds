package com.company;

public class TrappingRainWater {
    public static void solution(int [] heights)
    {
        if (heights.length <= 0) System.out.println("The Max amount of water stored/contained is 0");

        int left = 0;
        int right = heights.length - 1;
        int leftMax = heights[0];
        int rightMax = heights[right];
        int result = 0;
        while (left < right){
            if (leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, heights[left]);
                result += leftMax - heights[left];
                continue;
            }

            right--;
            rightMax = Math.max(rightMax, heights[right]);
            result += rightMax - heights[right];

        }

        System.out.println("The Max amount of water stored/contained is " + result);
    }
}
