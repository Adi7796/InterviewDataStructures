package Backtracking;

/*
Given an m x n grid of characters board and a string word, return true if the word exists in the grid.
 */
public class WordSearch {
    public static void main(String[] args) {
        String str = "ABCCED";
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        System.out.println(exist(str,board));
    }

    public static boolean exist(String word, char[][] board)
    {
        int index = 0;
        // First search the first character
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(board[i][j] == word.charAt(index)){
                    if(searchNext(word, board, index, i, j))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean searchNext(String word, char[][] board, int index, int row, int col)
    {
        // if index reaches at the end that means we have found the word
        if(index == word.length())
            return true;

        // Checking the boundaries if the character at which we are placed is not
        //the required character
        if(row < 0 || col < 0 || row == board.length || col == board[0].length
        || board[row][col] != word.charAt(index) || board[row][col] == '!')
            return false;

        char ch = board[row][col];
        // this is to prevent reusing of the same character
        board[row][col] = '!';

        boolean top = searchNext(word, board, index +1, row-1, col);

        boolean right = searchNext(word, board,index +1, row, col+1);

        boolean bottom = searchNext(word,board, index +1, row+1, col );

        boolean left = searchNext(word, board, index +1, row, col -1);

        board[row][col] = ch;  // undo change - backtrack

        return top || right || left || bottom;
    }

}

/*
Time Complexity:  O(m*n*4^k), where “K” is the length of the word. And we are searching for the letter m*n times in the worst case.
Here 4 in 4^k is because at each level of our decision tree we are making 4 recursive calls which equal 4^k in the worst case.

Space Complexity: O(K), Where k is the length of the given words.
 */
