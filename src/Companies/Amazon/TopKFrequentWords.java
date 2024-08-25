package Companies.Amazon;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        String[] words1 = {"i","love","leetcode","i","love","coding"};
        int k = 4;
        int k1 = 2;

        TopKFrequentWords obj = new TopKFrequentWords();
        List<String> ansList = obj.topKFrequent(words, k);
        for(String s : ansList)
        {
            System.out.println(s);
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Node> maxheap = new PriorityQueue<Node>();
        Map<String, Integer> wordToFreqMap = new HashMap<>();
        for(int i = 0; i < words.length; i++)
        {
            String currentWord = words[i];
            wordToFreqMap.put(currentWord, wordToFreqMap.getOrDefault(currentWord, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry : wordToFreqMap.entrySet())
        {
            maxheap.add(new Node(entry.getKey(), entry.getValue()));
        }

        ArrayList<String> ansList = new ArrayList<>();
        for(int i =0; i<k;i++)
        {
            ansList.add(maxheap.poll().word);
        }

        return ansList;

    }

    static class Node implements Comparable<Node>{
        String word;
        int freq;

        public Node(String word, int freq)
        {
            this.word = word;
            this.freq = freq;
        }

        @Override
        public int compareTo(Node node)
        {
            if(node.freq != this.freq)
                return node.freq - this.freq;
            return this.word.compareTo(node.word);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "word='" + word + '\'' +
                    ", freq=" + freq +
                    '}';
        }
    }
}

/*
Time Complexity: O(Nlogk),
where N is the length of words. We count the frequency of each word in O(N) time,
then we add N words to the heap, each in O(logk) time.
Finally, we pop from the heap up to k times or just sort all elements in the heap as the returned result,
which takes O(klogk). As k≤N, O(N)+O(Nlogk)+O(klogk)=O(Nlogk)
 */
