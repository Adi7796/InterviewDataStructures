package Matrices;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int N = 4; // no. of rows
        int M = 5; // no. of columns

        int arr[][] = { { 0, 6, 8, 9, 11 },
                { 20, 22, 28, 29, 31 },
                { 36, 38, 50, 61, 63 },
                { 64, 66, 100, 122, 128 } };

        int k = 31; // element to search
        findRow(arr, N, M, k);
    }

    public static void findRow(int[][] arr, int N, int M, int k)
    {
        int topBound = 0;
        int bottomBound = N-1;
        int mid = (topBound + bottomBound)/2;

        while(topBound <= bottomBound)
        {
            if(arr[mid][0] == k){
                System.out.println("Found the element at row : "+ (mid+1) + " col : "+ 1);
                return;
            }

            if(arr[mid][M-1] == k){
                System.out.println("Found the element at row : "+ (mid+1) + " col : " + (M));
                return;
            }

            if(k > arr[mid][0] && k < arr[mid][M-1])
                binarySearch(arr, N, M, k, mid);

            if(k < arr[mid][0])
                bottomBound = mid -1;
            if(k > arr[mid][M-1])
                topBound = mid + 1;

        }
    }

    public static void binarySearch(int[][] arr, int N, int M, int k, int row)
    {
        int leftBound = 0, rightBound = M-1;
        int mid = (leftBound + rightBound)/2;

        while(leftBound<=rightBound)
        {
            if(k == arr[row][mid]){
                System.out.println("Found the element at row : "+ (row+1) + " col : " + (mid + 1));
                return;
            }

            if(k > arr[row][mid])
                leftBound = mid + 1;
            if(k < arr[row][mid])
                rightBound = mid -1 ;
        }
    }

}
