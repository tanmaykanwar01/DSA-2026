/*Question: Same Tree
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false
*/

import java.util.*;

class Node{
    int data;
    Node right;
    Node left;
    Node(int data){
        this.data = data;
        this.right = right;
    }
}

class MainClass{
    public static boolean sameTree(Node root1,Node root2){
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        while((root1!=null && root2!=null) || (!s1.isEmpty() && !s2.isEmpty())){
            if(root1!=null && root2!=null){
                if(root1.data != root2.data)
                    return false;
            }
            while(root1 != null){
                s1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null){
                s2.push(root2);
                root2 = root2.left;
            }
            root1 = s1.pop();
            root2 = s2.pop();
            if(root1.data != root2.data)
                return false;
            root1 = root1.right;
            root2 = root2.right;
        }
        if((root1!=null&&root2==null)||(root1==null&&root2!=null)||(!s1.isEmpty()&&s2.isEmpty())||(s1.isEmpty()&&!s2.isEmpty()))
            return false;
        return true;
    }

    public static void main(String arg[]){
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(2);

        System.out.println("Same tree: " + sameTree(root1,root2));
    }
}