package BinarySearch;

/*
Problem Statement: Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book.
There are a ‘m’ number of students, and the task is to allocate all the books to the students.
Allocate books in such a way that:

Each student gets at least one book.
Each book should be allocated to only one student.
Book allocation should be in a contiguous manner.
You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum.
If the allocation of books is not possible. return -1

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
Time Complexity: O(N * log(sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array
elements, max(arr[]) = maximum of all array elements.
Space Complexity:  O(1)
 */
