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

    public void printTreeNode(TreeNode root)
    {
        if (root == null) return;

        //pre-order depth-first-search
        System.out.print(root.data + " ");

        if (root.left != null){
            printTreeNode(root.left);
        }

        if (root.right != null){
            printTreeNode(root.right);
        }
    }

    public void breadthFirstSearch()
    {
        BreadthFirstSearch.solution(this);
    }

    public void depthFirstSearch()
    {
        System.out.print("Depth First Search : ");
        printTreeNode(this);
        System.out.println();
    }

}
