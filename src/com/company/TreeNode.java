package com.company;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    TreeNode () {}

    TreeNode (int data) {
        this.data = data;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
   }

    public TreeNode insertNode(TreeNode head, int data)
    {
        if (head == null){
            head = new TreeNode();
            head.data = data;
            return head;
        }

        if (head.data < data){
            head.right = insertNode(head.right, data);
        }else{
            head.left = insertNode(head.left, data);
        }

        return head;
    }

    public static void printTreeNode(TreeNode root)
    {
        if (root == null) return;

        //pre-order breadth-first-search
        if (root.left == null && root.right == null){
            System.out.println(root.data + " ");
            return;
        }

        if (root.left != null){
            printTreeNode(root.left);
        }

        if (root.right != null){
            printTreeNode(root.right);
        }
    }

}
