package com.company;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int cacheCapacity ;
    private Map<Integer, Node> nodeMap;
    private Node headNode = new Node(0,0);
    private Node tailNode = new Node(0,0);

    public LRUCache( int capacity){
        nodeMap = new HashMap<>(capacity);
        headNode.nextNode = tailNode;
        tailNode.previousNode = headNode;
        cacheCapacity = capacity;
    }

    public int get(int key){
        Node node = nodeMap.get(key);
        if (node  != null){
            this.remove(node);
            this.add(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value){
        Node node = nodeMap.get(key);
        if (node != null){
            this.remove(node);
            node.value = value;
            this.add(node);
            return;
        }

        if (nodeMap.size() == this.cacheCapacity){
            Node leastFrequentNode = nodeMap.get(this.tailNode.previousNode.key);
            nodeMap.remove(leastFrequentNode.key);
            this.remove(leastFrequentNode);
        }

        Node newNode = new Node(key,value);
        nodeMap.put(key, newNode);
        this.add(newNode);
    }

    public void add (Node node){
        Node headNext = headNode.nextNode;
        headNode.nextNode = node;
        node.previousNode = headNode;
        node.nextNode = headNext;
        headNext.previousNode = node;
    }

    public void remove(Node node){
        Node nextNode = node.nextNode;
        Node prevNode = node.previousNode;

        nextNode.previousNode = prevNode;
        prevNode.nextNode = nextNode;
    }

    public class Node {
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        int key;
        int value;
        Node previousNode;
        Node nextNode;
    }
}
