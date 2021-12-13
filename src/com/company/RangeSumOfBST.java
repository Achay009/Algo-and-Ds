package com.company;

public class RangeSumOfBST {
    public static int solution(TreeNode root, int low, int high)
    {
        return sumAllWithinRange(root, low, high);
    }

    public static int sumAllWithinRange(TreeNode root, int low, int high)
    {
        if (root == null)return 0;

        int sum = root.data >= low && root.data <= high ?  root.data : 0;

        return sum + sumAllWithinRange(root.left, low, high) + sumAllWithinRange(root.right, low, high);
    }
}
