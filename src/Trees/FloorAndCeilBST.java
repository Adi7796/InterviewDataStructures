package Trees;
import Trees.CreateBinarySearchTree.Node;
public class FloorAndCeilBST {

    /*
    Floor Value --> For a given "key" value, Floor value is the largest value which is smaller than the given key value
    Ceil Value --> For a given "key" value, Ceil value is the smallest value which is larger than the given key value

    Approach 1 : Using inorder traversal, enter the elements in an array and then find the position of key value. The value before the position of the key value would be
    floor value and then one after would be ceil value. Time : O(N), Space : O(N)

    Approach 2: Iteratively without using extra space.
     */
    public static void main(String[] args) {
        Node root = new Node(40);
        root.left = new Node(20);
        root.right = new Node(60);
        root.left.left = new Node(10);
        root.left.right = new Node(30);

        System.out.println("Floor value :" + floorValue(root, 22) );
        System.out.println("Ceil Value :" + ceilValue(root, 22));
    }

    public static Integer floorValue(Node root, int key)
    {
        int ans = Integer.MAX_VALUE;
        if(root == null) return ans;

        while(root != null)
        {
            if(root.data == key) return root.data;

            else if(root.data > key){
                root = root.left;
            }
            else if(root.data < key){
                ans = root.data;   // this might be the greatest value but there might be another greater value than the root value
                root = root.right; // which is smaller than the key value
            }
        }
        return ans;
    }

    public static Integer ceilValue(Node root, int key)
    {
        int ans = Integer.MIN_VALUE;
        if(root == null) return ans;

        while(root != null)
        {
            if(root.data == key) return root.data;

            else if(root.data < key) {
                root = root.right;
            }

            else if(root.data > key){
                ans = root.data;   // this might be the smaller ans but there might be another smaller value than the root value
                root= root.left;   // which can be found on the left side
            }
        }
        return ans;
    }
}
