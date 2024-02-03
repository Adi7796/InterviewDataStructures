package Arrays;

public class MissingNumberArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        int N = arr[arr.length-1];
        int sumOfFirstNNumbers = (N*(N+1))/2;
        int sum = 0;
        for(int i=0;i< arr.length; i++)
        {
            sum+=arr[i];
        }

        System.out.println("Missing element from the array : " + (sumOfFirstNNumbers - sum));
    }
}
