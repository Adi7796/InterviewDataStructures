package Companies.Google;

/*
You are given a matrix having ‘N’ rows and ‘M’ columns. Each cell of the matrix is either ‘X’ or ‘O’.
You need to flip all those regions of ‘O’ which are surrounded by ‘X’ i.e.
you need to change all ‘O’s which are present in the region to ‘X’.

Note
1. Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the matrix is not flipped to 'X'.
2. Any ‘O’ or group of connected ‘O’ are said to be surrounded by ‘X’ when all cells touching the boundary of the group of ‘O’ must contain ‘X’.
 */
public class CaptureRegion {
    static class Cell{
        int x;
        int y;

        Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        char[][] mat = {{'X', 'O', 'X', 'O', 'X', 'X'},
                        {'X', 'O', 'X', 'X', 'O', 'X'},
                        {'X', 'X', 'X', 'O', 'O', 'X'},
                        {'O', 'X', 'X', 'X', 'X', 'X'},
                        {'X', 'X', 'X', 'O', 'X', 'O'},
                        {'O', 'O', 'X', 'O', 'O', 'O'}};

        char prevColor = 'O';
        char newColor = 'X';
        int row = mat.length;
        int col = mat[0].length;

        for(int i=0;i<mat.length; i++)
        {
            for (int j=0; j<mat[0].length; j++)
            {
                if(mat[i][j] == 'O')
                    mat[i][j] = '-';
            }
        }

        for(int i=0;i<row; i++){
            if(mat[i][0] == '-'){
                floodFillBFS(mat, i, 0, '-', '0');
            }
        }


        for(int i=0;i<col; i++){
            if(mat[0][i] == '-'){
                floodFillBFS(mat, 0, i, '-', '0');
            }
        }

        for(int i=0;i<col; i++){
            if(mat[row-1][i] == '-'){
                floodFillBFS(mat, row-1, i, '-', '0');
            }
        }

        for(int i=0;i<row; i++){
            if(mat[i][col-1] == '-'){
                floodFillBFS(mat, i, col-1, '-', '0');
            }
        }

        for(int i=0;i<mat.length; i++)
        {
            for (int j=0; j<mat[0].length; j++)
            {
                if(mat[i][j] == '-')
                    mat[i][j] = 'X';
            }
        }

        for(int i=0; i< mat.length; i++)
        {
            for(int j=0;j<mat[0].length; j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void floodFillBFS(char[][] mat, int row, int col , char prevColor, char newColor){
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length)
            return;
        if (mat[row][col] != prevColor)
            return;

        mat[row][col] = newColor;

        floodFillBFS(mat, row + 1, col, prevColor, newColor);

        floodFillBFS(mat, row, col + 1, prevColor, newColor);

        floodFillBFS(mat, row - 1, col, prevColor, newColor);

        floodFillBFS(mat, row, col - 1, prevColor, newColor);

    }
}

/*
Time Complexity: O(MN). Note that every element of matrix is processed at most three times.
Auxiliary Space: O(M x N), as implicit stack is used due to recursive call
 */
