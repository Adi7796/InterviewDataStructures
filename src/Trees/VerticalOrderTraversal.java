package Trees;
import Trees.CreateBinarySearchTree.*;

import java.util.*;

public class VerticalOrderTraversal {

    static class Pair{
        Node node;
        int hd;

        Pair(Node node, int hd)
        {
            this.node = node;
            this.hd = hd;
        }
    }
    public static void main(String[] args) {
        Node root = HeightOfBinaryTree.createBinaryTree();
        ArrayList<Integer> ans = levelOrderTraversal(root, 0);
        ans.forEach(System.out::println);
    }

    /*
    We are using level order traversal to put elements into the map
    This is because at the same horizontal level and at the same vertical level, if we have more than one element we will insert them
    in the order of level order
    We are using TreeMap to sort the horizontal distance in ascending order
     */
    public static ArrayList<Integer> levelOrderTraversal(Node root, int hd)
    {
        Queue<Pair> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        queue.add(new Pair(root,hd));

        while(!queue.isEmpty())
        {
            Pair current = queue.remove();
            if(!map.containsKey(current.hd)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(current.node.data);
                map.put(current.hd, list);
            }
            else {
                map.get(current.hd).add(current.node.data);
            }

            if(current.node.left != null)
                queue.add(new Pair(current.node.left, current.hd-1));
            if(current.node.right != null)
                queue.add(new Pair(current.node.right, current.hd+ 1));
        }

        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet())
        {
            ans.addAll(entry.getValue());
        }
        return ans;
    }


}
