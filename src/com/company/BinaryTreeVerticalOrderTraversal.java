package com.company;

import java.util.*;

class Pair
{
    // Return a map entry (key-value pair) from the specified values
    public static <T, U> Map.Entry<T, U> of(T first, U second) {
        return new AbstractMap.SimpleEntry<>(first, second);
    }
}

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
