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
    public static void postorderRecursive(Node root,ArrayList<Integer> res){
        if(root == null)
            return;
        postorderRecursive(root.left,res);
        postorderRecursive(root.right,res);
        res.add(root.data);
    }

    public static void main(String arg[]){
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        
        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourthNode;

        ArrayList<Integer> res = new ArrayList<Integer>();
        postorderRecursive(firstNode,res);
        System.out.println(res);
    }
}