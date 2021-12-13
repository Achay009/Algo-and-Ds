package com.company;

import java.util.ArrayList;

public class BalanceBST {

    public static TreeNode balanceBST(TreeNode root)
    {
        if (root == null) return null;

        ArrayList<Integer> list = new ArrayList<>();
        convertTreeToList(root, list);
        return convertListToTree(list, 0, list.size()-1);
    }

    public static void convertTreeToList(TreeNode root, ArrayList<Integer> list)
    {
        if (root == null) return;

        convertTreeToList(root.left, list);
        list.add(root.data);
        convertTreeToList(root.right, list);
    }

    public static TreeNode convertListToTree(ArrayList<Integer> list, int start, int finish)
    {
        TreeNode root = null;
        if (start > finish) return null;
        if (start == finish) {
            root.data = list.get(start);
        }
        int mid = start + (finish - start) / 2;

        root.data = list.get(mid);
        root.left = convertListToTree(list, start, mid - 1);
        root.right = convertListToTree(list, mid + 1, finish);
        return root;
    }
}
