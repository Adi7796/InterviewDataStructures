package Trees;

public class CreateBinarySearchTree {

    Node root;
    CreateBinarySearchTree() {
        root =null;
    }
    public static void main(String[] args) {
        CreateBinarySearchTree tree = new CreateBinarySearchTree();
        tree.insert(12);
        tree.insert(6);
        tree.insert(20);
        tree.insert(15);
        tree.insert(3);
        tree.insert(8);

        tree.inorder();
    }

    public void insert(int nodeValue){
        root = insertNode(root,nodeValue);
    }

    public Node insertNode(Node node, int nodeValue){
        if(node == null){
            node = new Node(nodeValue);
            return node;
        }
        else if(nodeValue<node.data){
            node.left = insertNode(node.left,nodeValue);
        }
        else if(nodeValue> node.data){
            node.right = insertNode(node.right, nodeValue);
        }
        return node;
    }

    public void inorderTraversal(Node node){
        if(node != null){
            inorderTraversal(node.left);
            System.out.println(node.data);
            inorderTraversal(node.right);
        }
    }

    public void inorder(){
        inorderTraversal(root);
    }

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            left=right=null;
        }
    }

}
