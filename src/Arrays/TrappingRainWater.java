package Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
         int[] arr = {3, 1, 2, 4, 0, 1, 3, 2};

         int[] prevMax = new int[arr.length];

        int maxSoFar = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
           maxSoFar = Math.max(maxSoFar, arr[i]);
           prevMax[i] = maxSoFar;
        }

        maxSoFar = Integer.MIN_VALUE;

        int[] nextMax = new int[arr.length];

        for(int i=arr.length -1; i>=0; i--){
            maxSoFar = Math.max(maxSoFar, arr[i]);
            nextMax[i] = maxSoFar;
        }

        int waterTrapped = 0;
        for(int i=0; i<arr.length; i++){
            waterTrapped = waterTrapped + Math.min(prevMax[i], nextMax[i]) - arr[i];
        }

        System.out.println("Total water trapped : " + waterTrapped);
    }
}
