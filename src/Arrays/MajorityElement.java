package Arrays;

/*
 A majority element in an array A[] of size n is an element that appears
 more than n/2 times (and hence there is at most one such element)
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 2, 3, 2, 1, 2};
        MajorityElement majorityElement = new MajorityElement();
        majorityElement.printMajorityElement(arr);
    }

    void printMajorityElement(int[] arr){
        int candidate = findCandidate(arr);

        if(isMajority(arr, candidate))
            System.out.println("Majority element : " + candidate);
        else
            System.out.println("No Majority element found");
    }

    int findCandidate(int[] arr){
        int length = arr.length;
        int ansIndex = 0;
        int count = 1;

        for(int i=1; i<length; i++){
            // if we keep seeing the same number we increase the count
            if(arr[i] == arr[ansIndex])
            {
                count++;
            }
            // else we decrease the count
            else{
                count--;
            }

            // if the count becomes 0, that means this might not be the majority element
            // hence we change the ans index
            // we need the count to be atleast greater than 1 to have a legit candidate
            if(count == 0){
                ansIndex = i;
                count = 1;
            }
        }
        return arr[ansIndex];
    }

    boolean isMajority(int[] arr, int candidate){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == candidate)
                count++;
        }

        if(count > Math.floorDiv(arr.length, 2))
            return true;
        else
            return false;
    }
}
