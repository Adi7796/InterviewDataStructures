package BinarySearch;

/*
Given that there are N books and M students. Also given are the number of pages in each book in ascending order.
The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum,
with the condition that every student is assigned to read some consecutive books.
Print that minimum number of pages.

Logic explanation - https://takeuforward.org/arrays/painters-partition-problem/
 */
public class BooksAllocation {
    public static void main(String[] args) {
        int[] arr = {25, 46, 28, 49, 24};
        int k = 4;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length; i++)
        {
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        System.out.println("Maximum pages : " + findPages(max, sum, arr, k));
    }

    static int countStudents(int[] arr, int pages)
    {
        int students = 1;
        int pagesPerStudent = 0;
        for(int i=0;i<arr.length; i++)
        {
            if(pagesPerStudent + arr[i] <= pages)
                pagesPerStudent += arr[i];
            else{
                students++;
                pagesPerStudent = arr[i];
            }
        }
        return students;
    }

    static int findPages(int low, int high, int[] arr, int k)
    {
        if(arr.length<k) return -1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            int students = countStudents(arr, mid);
            if(students > k) low = mid +1;
            else high = mid - 1;
        }
        return low;
    }
}

/*
Time Complexity: O(N * log(sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
Space Complexity:  O(1)
 */
