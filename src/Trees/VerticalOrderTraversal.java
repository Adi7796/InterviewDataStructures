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
        //ArrayList<Integer> ans = levelOrderTraversal(root, 0);
        Map<Integer, ArrayList<Integer>> map = levelOrderTraversal(root);

        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    /*
    We are using level order traversal to put elements into the map
    This is because at the same horizontal level and at the same vertical level, if we have more than one element we will insert them
    in the order of level order
    We are using TreeMap to sort the horizontal distance in ascending order
     */
    public static Map<Integer, ArrayList<Integer>> levelOrderTraversal(Node root)
    {
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        queue.add(new Pair(root,0));

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

        return map;
    }


}
