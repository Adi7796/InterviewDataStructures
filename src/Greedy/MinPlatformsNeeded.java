package Greedy;

import java.util.Arrays;

public class MinPlatformsNeeded {
    public static void main(String[] args) {
        int [] arrival = {900,  940, 950,  1100, 1500, 1800};
        int [] departure = {910, 1200, 1120, 1130, 1900, 2000};

        Arrays.sort(arrival);
        Arrays.sort(departure);
        System.out.println("Minimum platforms needed : "+ findMinimum(arrival, departure));

    }

    public static int findMinimum(int[] arrival, int[] departure)
    {
        int n = arrival.length;
        int i=1, j=0;
        int platforms_needed = 1, result =1;

        while(i <n && j<n)
        {
            if(arrival[i] <= departure[j])
            {
                platforms_needed ++;
                i++;
            }
            else if(arrival[i] > departure[j]){
                j++;
                platforms_needed--;
            }

            result = Math.max(result, platforms_needed);
        }

        return result;
    }
}
