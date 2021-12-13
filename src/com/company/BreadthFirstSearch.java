package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void solution(TreeNode root)
    {
        List<Integer> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode currentNode = null;
        while(!queue.isEmpty()){
            currentNode = queue.poll();
            output.add(currentNode.data);

            if (currentNode.left != null){
                queue.add(currentNode.left);
            }

            if (currentNode.right != null){
                queue.add(currentNode.right);
            }
        }

        System.out.println("Breadth first search : " + output);
    }

}
