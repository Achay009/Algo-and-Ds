package com.company;

import com.sun.source.tree.Tree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        System.out.println(" Computing the Max sub Array problem  = " + findMaxSumSubArray(new int[]{4, 2, 1, 7, 1, 2, 8, 1, 0}, 3));
//        System.out.println("Computing Max Sub Array problem using sliding window format = " + findMaxSubArraySliding(new int[]{4, 2, 1, 7, 1, 2, 8, 1, 0}, 3));
//        System.out.println("Computing reverse string recursively " + reverseString("Hello World"));
//        System.out.println("Computing decimal to binary recursively " + decimalToBinary(3, ""));
//        System.out.println("Computing binary search recursively " + binarySearch(new int[]{1,2,3,4,5,6,7,8,9}, 0, 8, 7));
//        int[] input = new int[]{4, 2, 2, 7, 8, 1, 2, 8, 10};
//        int targetSum = 8;
//        System.out.println(" Computing the smallest sub Array problem  = " + smallestSubArray(targetSum, input));


        System.out.println("converting string to number  ==  " + findDigits(""));
    }

    public static int findMaxSumSubArray(int[] arr, int k) {
        int maxValue = Integer.MIN_VALUE;
        int currentRunningSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentRunningSum += arr[i];

            if (i >= k - 1) {
                maxValue = Math.max(maxValue, currentRunningSum);
                currentRunningSum -= arr[i - (k - 1)];
            }
        }
        return maxValue;
    }

    public static int findMaxSubArraySliding(int[] arr, int k) {
        int maxValue = Integer.MIN_VALUE;
        int currentWindowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentWindowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                maxValue = Math.max(maxValue, currentWindowSum);
                currentWindowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxValue;
    }


    public static int smallestSubArray(int targetSum, int[] arr) {
        int minWindowSize = Integer.MAX_VALUE;
        int currentWindowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentWindowSum += arr[windowEnd];

            while (currentWindowSum >= targetSum) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentWindowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minWindowSize;
    }


    public static int LongestSubstringKDistinct(String str, int k) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    //Node Class for multilevel linked list
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

    }

    ;

    public Node flatten(Node head) {

        flatList(head);
        return head;
    }

    private Node flatList(Node head) {
        if (head == null || (head.next == null && head.child == null)) {
            return head;
        }
        Node cur = head;
        Node prev = null;
        Node child = null;
        Node next = null;

        while (cur != null) {
            prev = cur.prev;
            next = cur.next;
            child = cur.child;

            if (child != null) {
                Node last = flatList(cur.child);

                last.next = next;
                if (next != null) {
                    next.prev = last;
                }

                cur.next = child;
                child.prev = cur;

                cur.child = null;
                cur = last;
            } else {
                prev = cur;
                next = cur.next;
                cur = next;
            }
        }
        return prev;
    }

    public static String reverseString(String s)
    {
        if (s.equals("")) {
            return s;
        }
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static boolean isPalindrome(String s)
    {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }

        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 1));
        }

        return false;
    }

    public static String decimalToBinary(int decimal, String result)
    {
        if (decimal == 0){
            return result;
        }

        result = decimal % 2 + result;

        return decimalToBinary(decimal/2, result);
    }

    public static int binarySearch(int [] a, int left, int right, int item)
    {
        Arrays.sort(a);
        if (left > right)
            return -1;

        int mid = (left + right) / 2;

        if (item == a[mid]){
            return mid;
        }

        if (item > a[mid])
            return binarySearch(a,mid +1,right, item);

        return binarySearch(a, left, mid-1, item);
    }

    public static Node reverseListNode(Node head)
    {
        if (head == null || head.next == null) return head;

        Node last = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static Node mergeSortedLinkedList(Node A, Node B)
    {
        if (A == null) return B;
        if (B == null) return A;

        if (A.val < B.val){
            A.next = mergeSortedLinkedList(A.next, B);
            return A;
        }else{
            B.next = mergeSortedLinkedList(A, B.next);
            return B;
        }
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int runningSum = maxSum;

        for(int i = 1; i < nums.length; i++){
            runningSum = Math.max(runningSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }

    public int maxSubArray2(int [] nums){
        int currentSum = 0;
        int maxSum = nums[0];

        for (var i = 0; i < nums.length; i++ ){
            if (currentSum < 0)
                currentSum = 0;
            currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }


    public static int bestBuySellStock(int [] prices)
    {
        int max = 0;
        int buy = 0;
        int sell = 1;
        while(sell < prices.length){
            if (prices[buy] > prices[sell]){
                buy = sell;
            }else{
                int profit = prices[sell] - prices[buy];
                max = Math.max(profit, max);
            }

            sell++;
        }

        return max;
    }

    class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        

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

    public static int treeSum(TreeNode root)
    {
        if (root == null) return 0;

        return root.data + treeSum(root.left) + treeSum(root.right);
    }

    public static ArrayList<Integer> depthFirstSearch(TreeNode root)
    {
        if (root == null) return new ArrayList<Integer>();

        ArrayList<Integer> leftValues = depthFirstSearch(root.left);
        ArrayList<Integer> rightValues = depthFirstSearch(root.left);
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(root.data);
        result.addAll(leftValues);
        result.addAll(rightValues);

       return result;
    }

    public static void markIsland(int [][] grid, int i, int j, int row, int column)
    {
        if (i < 0 || i >= row || j < 0 || j >= column || grid[i][j] != 1) return;

        grid[i][j] = 2;
        markIsland(grid, i+1, j, row, column); //DOWN
        markIsland(grid, i, j+1, row, column); //RIGHT
        markIsland(grid, i-1, j, row, column); //UP
        markIsland(grid, i, j-1, row, column); //LEFT
    }

    public static int numberOfIsland(int[][]grid)
    {

        int row = grid.length;
        int column = grid[0].length;
        int numberOfIsland = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if (grid[i][j] == 1){
                    markIsland(grid, i, j, row, column);
                    numberOfIsland++;
                }
            }
        }
        return numberOfIsland;
    }

    public Node getIntersectionNode(Node headA, Node headB)
    {
        if(headA==null || headB==null) return null;

        Node a=headA;
        Node b=headB;

        while(a != b){
            a=a.next;
            b=b.next;
            if(a == b) return a;
            if(a == null) a = headB;
            if(b == null) b = headA;
        }
        return a;
    }

    public String breakPalindrome(String palindrome)
    {
        if (palindrome.length() <= 1){
            return "";
        }

        char [] charArray = palindrome.toCharArray();

        for (int i = 0; i < palindrome.length()/2; i++)
        {
            if (charArray[i] != 'a'){
                charArray[i] = 'a';
                String result = new String(charArray);
                return result;
            }
        }

        charArray[palindrome.length() -1] = 'b';
        String result = new String(charArray);
        return result;
    }

    public int findKthLargest(int[] nums, int k)
    {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    public static String findDigits(String s)
    {

        // Strings of digits 0-9
        String[] num
                = { "zero", "one", "two",   "three", "four",
                "five", "six", "seven", "eight", "nine" };

        // Initialize vector
        int[] arr = new int[10];

        // Initialize answer
        String ans = "";

        // Size of the string
        int n = s.length();

        // Traverse the string
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'z')
                arr[0]++;
            if (s.charAt(i) == 'w')
                arr[2]++;
            if (s.charAt(i) == 'g')
                arr[8]++;
            if (s.charAt(i) == 'x')
                arr[6]++;
            if (s.charAt(i) == 'v')
                arr[5]++;
            if (s.charAt(i) == 'o')
                arr[1]++;
            if (s.charAt(i) == 's')
                arr[7]++;
            if (s.charAt(i) == 'f')
                arr[4]++;
            if (s.charAt(i) == 'h')
                arr[3]++;
            if (s.charAt(i) == 'i')
                arr[9]++;
        }

        // Update the elements of the vector
        arr[7] -= arr[6];
        arr[5] -= arr[7];
        arr[4] -= arr[5];
        arr[1] -= (arr[2] + arr[4] + arr[0]);
        arr[3] -= arr[8];
        arr[9] -= (arr[5] + arr[6] + arr[8]);

        // Print the digits into their
        // original format
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < arr[i]; j++) {
                ans += (char)(i + '0');
            }
        }

        // Return answer
        return ans;
    }

    public static int minimumSubArraySum(int [] nums)
    {
        int currentSum = 0;
        int minSum = nums[0];

        for (var i = 0; i < nums.length; i++ ){
            if (currentSum < 0)
                currentSum = 0;
            currentSum += nums[i];
            minSum = Math.min(currentSum, minSum);
        }

        return minSum;
    }

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







