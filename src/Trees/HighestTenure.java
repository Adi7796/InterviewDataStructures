package Trees;

import java.util.ArrayList;
import java.util.List;

public class HighestTenure {
    public static class Node<T> {
        public T val;
        public List<Node<T>> children;

        public Node(T val) {
            this(val, new ArrayList<>());
        }

        public Node(T val, List<Node<T>> children) {
            this.val = val;
            this.children = children;
        }
    }

    static class Pair{
        int sum;
        int count;

        public Pair(int sum, int count)
        {
            this.sum = sum;
            this.count = count;
        }
    }

    static double maxAverage = Integer.MIN_VALUE;
    static int maxNode = Integer.MIN_VALUE;

    public static int highestTenure(Node<Integer> president) {
        Pair ans = calculateSum(president);
        return maxNode;
    }

    public static Pair calculateSum(Node<Integer> node)
    {
        if(node.children.size() == 0){
            return new Pair(node.val,1);
        }



        int sum = 0;
        int count = 0;
        for(int i = 0; i<node.children.size(); i++)
        {
            Pair p = calculateSum(node.children.get(i));
            sum += p.sum;
            count += p.count;
        }
        if(node.children.size() != 0)
        {
            double avg = (double)(sum + node.val)/(count+1);
            System.out.println("Average : " + avg);
            if(avg > maxAverage){
                maxAverage = avg;
                maxNode = node.val;

            }
        }
        return new Pair(node.val + sum, count + 1);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(20, new ArrayList<>());
        root.children.add(new Node<>(12, new ArrayList<>()));
        root.children.add(new Node<>(18, new ArrayList<>()));
        root.children.get(0).children.add(new Node<>(11));
        root.children.get(0).children.add(new Node<>(2));
        root.children.get(0).children.add(new Node<>(3));

        root.children.get(1).children.add(new Node<>(15));
        root.children.get(1).children.add(new Node<>(8));

        System.out.println(highestTenure(root));

    }
}
