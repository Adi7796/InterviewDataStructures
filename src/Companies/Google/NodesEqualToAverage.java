package Companies.Google;

public class NodesEqualToAverage {
    static NodesEqualToAverage obj = new NodesEqualToAverage();
    int totalCount = 0;
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int data)
        {
            this.val = data;
        }
    }

    static class Node
    {
        int count;
        int sum;
        Node(){}
    }

    public int averageOfSubtree(TreeNode root)
    {
        if(root == null)
            return 0;
        Node finalObj = obj.findCount(root, new Node());

        return totalCount;
    }

    public Node findCount(TreeNode root, Node node)
    {

        if(root == null)
        {
           return null;
        }

        if(root.left==null && root.right == null)
        {
            totalCount++;
            node.count = 1;
            node.sum = root.val;
            return node;
        }


        Node leftNode = findCount(root.left, new Node());
        Node rightNode = findCount(root.right, new Node());
        int sum = 0;
        int total = 0;
        if(leftNode != null)
        {
            sum += leftNode.sum;
            total += leftNode.count;
        }
        if(rightNode != null)
        {
            sum += rightNode.sum;
            total += rightNode.count;
        }
        total+=1;
        sum += root.val;
        node.count = total;
        node.sum = sum;
        if((sum)/(total) == root.val)
            totalCount++;
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(6);


        System.out.println(obj.averageOfSubtree(root));
    }

}
