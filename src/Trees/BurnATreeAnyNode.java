package Trees;

import java.util.*;

public class BurnATreeAnyNode {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            left=right=null;
        }
    }

    public static Node findChildToParentMap(Node root, int target, HashMap<Node, Node> childToParentMap)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node res = new Node(-1);
        while(!queue.isEmpty())
        {
            Node currentNode = queue.poll();
            if(currentNode.data == target) res = currentNode;
            if(currentNode.left !=null && !childToParentMap.containsKey(currentNode.left)){
                childToParentMap.put(currentNode.left, currentNode);
                queue.add(currentNode.left);
            }
            if(currentNode.right != null && !childToParentMap.containsKey(currentNode.right)){
                childToParentMap.put(currentNode.right, currentNode);
                queue.add(currentNode.right);
            }
        }

        return res;
    }

    public static int findMaxTime(Node root, HashMap<Node, Node> childToParentMap, Node targetNode)
    {
        Set<Node> visitedSet = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(targetNode);
        visitedSet.add(targetNode);
        int maxTime = 0;

        while(!queue.isEmpty()){
            int flag = 0;
            int size = queue.size();

            for(int i=0;i<size;i++)
            {
                Node currentNode = queue.poll();
                // check left child
                if(currentNode.left !=null && !visitedSet.contains(currentNode.left)){
                   queue.add(currentNode.left);
                   visitedSet.add(currentNode.left);
                   flag = 1;
                }
                // check right child
                if(currentNode.right!=null && !visitedSet.contains(currentNode.right)) {
                    queue.add(currentNode.right);
                    visitedSet.add(currentNode.right);
                    flag = 1;
                }
                // check parent
                Node parentNode = childToParentMap.get(currentNode);
                if(parentNode!=null && !visitedSet.contains(parentNode)){
                    queue.add(parentNode);
                    visitedSet.add(parentNode);
                    flag = 1;
                }
            }

            if(flag == 1)
                maxTime++;
        }

        return maxTime;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left= new Node(4);
        root.right = new Node(1);
        root.left.left = new Node(45);
        root.left.right = new Node(10);
        root.left.left.left = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(8);

        int target = 10;
        HashMap<Node,Node> childToParentMap = new HashMap<>();
        Node targetNode = findChildToParentMap(root,target, childToParentMap);
        int maxTime = findMaxTime(root, childToParentMap, targetNode);

        System.out.println("Max time : " + maxTime);
    }
// Time Complexity : O(N)
    // Space Complexity : O(N)

}
