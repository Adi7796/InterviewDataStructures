package Companies.Google;

public class IntersectionOf2SortedArrays {
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3,3,3,3,3,3,3,3,3,4, 5, 6,6,6,6,6,6 };
        int arr2[] = { 1,1,1,1,1,1,1,2, 3,3,3,3,3,3,4,4, 5, 7,7,7,8,8,8,8 };
        int m = arr1.length;
        int n = arr2.length;
        printIntersection(arr1, arr2, m, n);
    }

    public static void printIntersection(int[] arr1, int[] arr2, int m, int n)
    {
        int first = 0 , second = 0;
        while(first < m && second < n)
        {
            while(first < m-1 && arr1[first] == arr1[first+1])
            {
                first++;
            }
            while(second < n-1 && arr2[second] == arr2[second+1])
            {
                second++;
            }
            if(arr1[first] == arr2[second])
            {
                System.out.print(arr1[first] + " ");
                first++;
                second++;
            }
            else if(arr2[second] > arr1[first])
            {
                first++;
            }
            else
                second++;
        }
    }
}
