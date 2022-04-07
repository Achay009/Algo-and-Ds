package com.company;

public class DistributeCoinsInABinaryTree {
    public static void solution (TreeNode root){
        System.out.println("The minimum moves to distribute coins is : "+ distributeCoins(root));
    }
    public static int ans;
    public static int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public static int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans += Math.abs(L) + Math.abs(R);
        return node.data + L + R - 1;
    }
}
