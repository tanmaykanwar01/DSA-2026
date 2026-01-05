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
    public static ArrayList<ArrayList<Integer>> BFSIterative(Node root){
        if(root == null)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int currLevel=0;
        while(!queue.isEmpty()){
            int len = queue.size();
            res.add(new ArrayList<Integer>());
            for(int i=0;i<len;i++){
                Node node = queue.poll();
                res.get(currLevel).add(node.data);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            currLevel++;
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

        ArrayList<ArrayList<Integer>> res =  BFSIterative(firstNode);
        for(int i=0;i<res.size();i++)
            System.out.println(res.get(i));
    }
}