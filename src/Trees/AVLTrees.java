package Trees;

public class AVLTrees {

    Node root;
    class Node{
        int height, data;
        Node left, right;

        Node(int data)
        {
            this.data = data;
            this.height = 1;
        }
    }

    int height(Node node) {
        if(node == null)
            return 0;

        return node.height;
    }

    int getBalance(Node node){
        if(node == null)
            return 0;

        return height(node.left) - height(node.right);
    }

    Node leftRotate(Node x){
        Node y = x.right;
        Node yleft = y.left;

        //perform rotation
        y.left = x;
        x.right = yleft;

        //update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    Node rightRotate(Node y){
        Node x = y.left;
        Node xRight = x.right;

        //perform rotation
        x.right = y;
        y.left = xRight;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node insert(Node node, int key) {

        /* 1.  Perform the normal BST insertion */
        if(node  == null)
            return new Node(key);

        if(key < node.data)
            node.left = insert(node.left, key);
        else if(key > node.data)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = Math.max(height(node.left), height(node.right)) +1;

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases
        // Left Left Case
        if(balance > 1 && key < node.left.data)
            return rightRotate(node);
        //right right case
        else if(balance < -1 && key > node.right.data)
            return leftRotate(node);
        // left right case
        else if(balance > 1 && key > node.left.data){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //right left case
        else if(balance < -1 && key < node.right.data){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public static void main(String[] args) {
        AVLTrees tree = new AVLTrees();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder(tree.root);
    }

    //Time Complexity: O(n*log(n)), For Insertion
    //Auxiliary Space: O(1)

}
