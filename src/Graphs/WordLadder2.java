package Graphs;

import java.util.*;

/*
A transformation sequence from word beginWord to word endWord using a
dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList.
Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the
shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists.
Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
 */
public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set< String > st = new HashSet<>();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            st.add(wordList.get(i));
        }

        // Creating a queue ds which stores the words in a sequence which is
        // required to reach the targetWord after successive transformations.
        Queue <ArrayList< String >> q = new LinkedList<>();
        ArrayList < String > ls = new ArrayList < > ();
        ls.add(beginWord);
        q.add(ls);
        ArrayList < String > usedOnLevel = new ArrayList < > ();
        usedOnLevel.add(beginWord);
        int level = 0;

        // A vector to store the resultant transformation sequence.
        List<List<String >> ans = new ArrayList < > ();
        int cnt = 0;

        // BFS traversal with pushing the new formed sequence in queue
        // when after a transformation, a word is found in wordList.
        while (!q.isEmpty()) {
            cnt++;
            ArrayList < String > vec = q.peek();
            q.remove();

            // Now, erase all words that have been
            // used in the previous levels to transform
            if (vec.size() > level) {
                level++;
                for (String it: usedOnLevel) {
                    st.remove(it);
                }
            }

            String word = vec.get(vec.size() - 1);

            // store the answers if the end word matches with targetWord.
            if (word.equals(endWord)) {
                // the first sequence where we reached the end.
                if (ans.size() == 0) {
                    ans.add(vec);
                } else if (ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
            }
            for (int i = 0; i < word.length(); i++) {

                // Now, replace each character of ‘word’ with char
                // from a-z then check if ‘word’ exists in wordList.
                for (char c = 'a'; c <= 'z'; c++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);
                    if (st.contains(replacedWord) == true) {
                        vec.add(replacedWord);
                        // Java works by reference, so enter the copy of vec
                        // otherwise if you remove word from vec in next lines, it will
                        // remove from everywhere
                        ArrayList < String > temp = new ArrayList < > (vec);
                        q.add(temp);
                        // mark as visited on the level
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }

            }
        }
        return ans;
    }
}

/*
Time complexity: O(NK2+α).

Here N is the Number of words in wordList, K is the maximum length of a word, α is the Number of possible paths from beginWord to endWord in the directed graph we have.

Copying the wordList into the set will take O(N).

In the worst-case scenario, the number of operations in the bidirectional BFS will be equal to the BFS approach discussed before. However, in some cases, this approach will perform better because the search space is reduced by selecting the shorter queue at each iteration. In bidirectional BFS, at most, every word will be traversed once, and for each word, we will find the neighbors using the function findNeighbors which has a time complexity of O(K
2
 ). Therefore the total complexity for all the N words will be O(NK
2
 ). Also, each word will be enqueued and will be removed from the set which will take O(N). Thus, the total time complexity of bidirectional BFS will be O(NK
2
 ).

In the backtracking process, we will essentially find all of the paths from beginWord to endWord. Thus, the time complexity is equal to O(α).

Space complexity: O(NK).

Here N is the Number of words in wordList, K is the Maximum length of a word.
 */