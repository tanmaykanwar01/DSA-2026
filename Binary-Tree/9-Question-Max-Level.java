/*Question: Maximum Level Sum of a Binary Tree
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

Example 1:
Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.

Example 2:
Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2
*/

import java.util.*;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class MainClass{
    public static int maxLevel(Node root){
        if(root == null)
            return 0;
        Queue<Node> queue = new LinkedList<Node>();
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        int currLevel = 0;
        Node curr = root;
        queue.offer(curr);
        while(!queue.isEmpty()){
            int len = queue.size();
            int sum = 0;
            for(int i=0;i<len;i++){
                Node node = queue.poll();
                sum += node.data;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            if(sum>maxSum){
                maxSum = sum;
                maxLevel = currLevel+1;
            }
            currLevel++;
        }
        return maxLevel;
    }

    public static void main(String arg[]){
        Node root = new Node(1);
        root.left = new Node(7);
        root.right = new Node(0);
        root.left.left = new Node(7);
        root.left.right = new Node(-8);
        System.out.println("Maximum level: " + maxLevel(root));
    }
}