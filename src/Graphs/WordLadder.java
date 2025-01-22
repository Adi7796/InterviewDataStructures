package Graphs;

import java.util.*;

/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList
is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList,
return the number of words in the shortest transformation sequence from beginWord to endWord,
or 0 if no such sequence exists.

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog",
which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

 */
public class WordLadder {

    class Pair{
        String word;
        int steps;

        Pair(String word, int steps)
        {
            this.word = word;
            this.steps = steps;
        }
    }
    public static void main(String[] args)
    {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        Set<String> wordsSet = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();

        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity.
        for(int i = 0; i<wordList.size(); i++)
        {
            wordsSet.add(wordList.get(i));
        }

        // BFS traversal with pushing values in queue
        // when after a transformation, a word is found in wordList.
        queue.offer(new Pair(beginWord, 1));

        while(!queue.isEmpty())
        {
            Pair pair = queue.poll();
            String currentWord = pair.word;
            int steps = pair.steps;

            // we return the steps as soon as
            // the first occurence of targetWord is found.
            if(currentWord.equals(endWord)) return steps;

            // Now, replace each character of ‘word’ with char
            // from a-z then check if ‘word’ exists in wordList.
            for(int i = 0; i< currentWord.length(); i++)
            {
                for(char ch = 'a'; ch <= 'z'; ch++)
                {
                    char[] replacedCharArray = currentWord.toCharArray();
                    replacedCharArray[i] = ch;

                    String replacedWord = new String(replacedCharArray);

                    // check if it exists in the set and push it in the queue.
                    if(wordsSet.contains(replacedWord))
                    {
                        wordsSet.remove(replacedWord);
                        queue.offer(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        // If there is no transformation sequence possible
        return 0;
    }
}

/*
Time Complexity: O(N * M * 26)

Where N = size of wordList Array and M = word length of words present in the wordList.

Note that, hashing operations in an unordered set takes O(1) time,
but if you want to use set here, then the time complexity would increase by a factor of log(N) as
hashing operations in a set take O(log(N)) time.

Space Complexity:  O( N ) { for creating an unordered set and copying all values from wordList into it }
 */
