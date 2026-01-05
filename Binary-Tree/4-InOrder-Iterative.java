import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class MainClass{
    public static ArrayList<Integer> inorderIterative(Node root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        while(curr!=null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.data);
            curr = curr.right;
        }
        return res;
    }

    public static void main(String arg[]){
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        
        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourthNode;

        ArrayList<Integer> res = inorderIterative(firstNode);
        System.out.println(res);
    }
}