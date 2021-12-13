package com.company;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList();
        if (root == null) {
            return output;
        }

        Map<Integer, ArrayList> columnTable = new HashMap();
        Queue<Map.Entry<TreeNode, Integer>> queue = new ArrayDeque();
        int column = 0;
        queue.offer(Pair.of(root, column));

        //Ran Breadth First Search
        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            column = p.getValue();

            if (root != null) {
                if (!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<Integer>());
                }
                columnTable.get(column).add(root.data);

                queue.offer(Pair.of(root.left, column - 1));
                queue.offer(Pair.of(root.right, column + 1));
            }
        }

        List<Integer> sortedKeys = new ArrayList<Integer>(columnTable.keySet());
        Collections.sort(sortedKeys);
        for(int k : sortedKeys) {
            output.add(columnTable.get(k));
        }

        return output;

    }
}
