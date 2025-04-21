package Trees;

import java.util.*;

public class NodesAtDistKBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    Map<Integer, TreeNode> npMap = new HashMap<>();
    TreeNode targetNode = null;
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        nodeToParentMap(root, target);
        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        int mapSize = npMap.size();
        if(mapSize + 1 < k) return ans;
        boolean[] visited = new boolean[mapSize+1];
        queue.add(targetNode);
        int dist = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();

            if(dist == k)
            {
                while(!queue.isEmpty())
                {
                    ans.add(queue.remove().val);
                }
                return ans;
            }
            boolean flag = false;

            for(int i = 0; i<size; i++)
            {
                TreeNode currNode = queue.remove();
                visited[currNode.val] = true;
                if(currNode.left != null &&!visited[currNode.left.val])
                {
                    if(!flag)
                    {
                        dist++;
                        flag = true;
                    }
                    queue.add(currNode.left);
                }
                if(currNode.right != null && !visited[currNode.right.val])
                {
                    if(!flag)
                    {
                        dist++;
                        flag = true;
                    }
                    queue.add(currNode.right);
                }
                if(npMap.containsKey(currNode.val) && !visited[npMap.get(currNode.val).val])
                {
                    if(!flag)
                    {
                        dist++;
                        flag = true;
                    }
                    queue.add(npMap.get(currNode.val));
                }
            }

        }

        return ans;
    }

    public void nodeToParentMap(TreeNode root, TreeNode target)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode currNode = queue.remove();
            if(currNode.val == target.val){
                targetNode = currNode;
            }
            if(currNode.left != null)
            {
                queue.add(currNode.left);
                if(!npMap.containsKey(currNode.left.val))
                {
                    npMap.put(currNode.left.val, currNode);
                }
            }
            if(currNode.right != null)
            {
                queue.add(currNode.right);
                if(!npMap.containsKey(currNode.right.val))
                {
                    npMap.put(currNode.right.val, currNode);
                }
            }
        }
    }
}