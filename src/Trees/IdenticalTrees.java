package Trees;

public class IdenticalTrees {

    static class Node{
        Node left, right;
        int data;

        Node(int data){
            this.data = data;
        }
    }

    public static boolean isIdentical(Node r1, Node r2)
    {
        if((r1 == null && r2 != null) || r1 != null && r2 == null) return false;
        if(r1 == null && r2 == null)  return true;

        boolean checkLeft = isIdentical(r1.left, r2.left);
        boolean checkRight = isIdentical(r1.right, r2.right);

        return r1.data == r2.data && checkLeft && checkRight;
    }

    public static boolean isIdenticalAlternative(Node p, Node q)
    {
        if((p == null && q != null) || (q==null && p!=null))
            return false;

        if(p != null && q != null && p.data != q.data)
            return false;

        if(p != null && q != null && p.data == q.data)
            return isIdenticalAlternative(p.left, q.left) && isIdenticalAlternative(p.right, q.right);

        return true;
    }
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        System.out.println(isIdentical(root1, root2));
    }
}
