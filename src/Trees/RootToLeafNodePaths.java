package Trees;

import Companies.Google.SumRootToLeaf;

import java.util.ArrayList;

public class RootToLeafNodePaths {

    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.left.left = new Node(4);

        ArrayList<ArrayList<Integer>> paths = Paths(root);
        for(ArrayList<Integer> subpath : paths)
        {
            int i;
            for(i = 0; i<subpath.size()-1; i++)
            {
                System.out.print(subpath.get(i) + " --> ");
            }
            System.out.print(subpath.get(i));
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if(root == null) return result;

        findPaths(root, temp, result);
        return result;
    }

    static void findPaths(Node root, ArrayList<Integer> tempList, ArrayList<ArrayList<Integer>> result)
    {
        if(root == null) return;

        tempList.add(root.data);
        if(root.left == null && root.right == null)
        {
            result.add(new ArrayList<>(tempList));
        }

        else {
            findPaths(root.left, tempList, result);
            findPaths(root.right, tempList, result);
        }

        tempList.remove(tempList.size()-1);
    }
}
