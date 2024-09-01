package Companies.Amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganiseString {

    static class Node implements Comparable<Node>{
        char ch;
        int freq;

        public Node(char ch, int freq)
        {
            this.ch = ch;
            this.freq = freq;
        }

        @Override
        public int compareTo(Node node)
        {
            if(node.freq != this.freq) return node.freq - this.freq;
            return this.ch - node.ch;
        }

    }
    public static void main(String[] args) {
        String s = "zhmyo";
        System.out.println("Reorganised String : " + reorganiseString(s));
    }

    public static String reorganiseString(String s)
    {
        HashMap<Character, Integer> characterFreqMap = new HashMap<>();
        for(char ch : s.toCharArray())
        {
            characterFreqMap.put(ch, characterFreqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> entry : characterFreqMap.entrySet())
        {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        Node firstNode = pq.peek();
        sb.append(firstNode.ch);

        if(--firstNode.freq == 0) {
            pq.poll();
            if(pq.size() == 1){
                return sb.toString();
            }
        }

        while(!pq.isEmpty())
        {
            Node topNode = pq.poll();
            if(sb.charAt(sb.length()-1) == topNode.ch)
            {
                if(!pq.isEmpty())
                {
                    Node secondTopNode = pq.peek();
                    sb.append(secondTopNode.ch);
                    secondTopNode.freq--;
                    if(secondTopNode.freq == 0)
                    {
                        pq.poll();
                    }
                    pq.add(topNode);
                }
                else{
                    return "";
                }

            }
            else
            {
                sb.append(topNode.ch);
                topNode.freq--;
                if(topNode.freq>0) {
                    pq.add(topNode);
                }
            }

        }

        return sb.toString();
    }
}
