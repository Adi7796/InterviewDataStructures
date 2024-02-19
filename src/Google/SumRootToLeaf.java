package Google;

public class SumRootToLeaf {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(5);
        root.right.right = new Node(4);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        int ans = sumToLeaf(root, 0);

        System.out.println("Sum tp leaf : " + ans);
    }

    public static int sumToLeaf(Node root, int sum)
    {
        if(root == null)
            return 0;

        sum = (sum*10) + root.data;

        if(root.left == null && root.right == null)
            return sum;

        return sumToLeaf(root.left, sum) + sumToLeaf(root.right, sum);
    }
}
