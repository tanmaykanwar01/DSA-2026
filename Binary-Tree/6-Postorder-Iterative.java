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
    public static ArrayList<Integer> postorderIterative(Node root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        while(curr!=null || !stack.isEmpty()){
            while(curr != null){
                if(curr.right != null)
                    stack.push(curr.right);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(!stack.isEmpty() && curr.right!=null && curr.right==stack.peek()){
                stack.pop();
                stack.push(curr);
                curr = curr.right;
            }
            else{
                res.add(curr.data);
                curr = null;
            }
        }
        return res;
    }

    public static void main(String arg[]){
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);
        
        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourthNode;
        secondNode.right = fifthNode;
        ArrayList<Integer> res = postorderIterative(firstNode);
        System.out.println(res);
    }
}