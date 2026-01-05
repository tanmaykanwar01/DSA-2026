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
    public static ArrayList<Integer> preorderIterative(Node root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        while(curr!=null || !stack.isEmpty()){
            while(curr != null){
                result.add(curr.data);
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return result;
    }

    public static void main(String arg[]){
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        
        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourthNode;

        ArrayList<Integer> arr;
        arr = preorderIterative(firstNode);
        System.out.println(arr);
    }
}