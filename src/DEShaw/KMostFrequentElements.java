package DEShaw;

import java.util.*;

public class KMostFrequentElements {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 4,4, 5, 2, 6, 1, 5, 5, 5, 5, 5 };
        int N = arr.length;
        int K = 4;

        findKMostFrequent(arr, K, N);
    }

    public static void findKMostFrequent(int[] arr, int k, int n)
    {
        Map<Integer, Integer> numberToFreqMap = new HashMap<>();

        for(int i=0;i<n;i++) {
            if(numberToFreqMap.containsKey(arr[i])){
                numberToFreqMap.put(arr[i], numberToFreqMap.get(arr[i]) + 1);
            } else {
                numberToFreqMap.put(arr[i], 1);
            }
        }

        List<Pair> pairList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : numberToFreqMap.entrySet())
        {
            pairList.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Collections.sort(pairList);

        System.out.println("K most frequent elements : ");
        for(int i=0; i<k; i++)
        {
            System.out.println(pairList.get(i).number + " --> " + pairList.get(i).frequency);
        }
    }

    static class Pair implements Comparable<Pair>{
        int number;
        int frequency;

        Pair(int number, int frequency) {
            this.number = number;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Pair p)
        {
            return p.frequency - this.frequency;
        }
    }
}
