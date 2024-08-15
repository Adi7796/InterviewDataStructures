package Companies.Google;

/*
Imagine you have a special keyboard with the following four keys:

Key 1: (A): Print one ‘A’ on screen.
Key 2: (Ctrl-A): Select the whole screen.
Key 3: (Ctrl-C): Copy selection to buffer.
Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.
Given a positive integer ‘N’,
find out the maximum numbers of ‘A’s you can print on the screen if you are allowed to press the keys of this special keyboard ‘N’ times.
 */
public class FourKeysKeyboard {
    public static void main(String[] args) {
        int N = 10;
        System.out.println(findMaxAs(N));
    }

    static long findMaxAs(int n) {

        int[] dp = new int[n+1];

        // for n=1 to 6, the maximum times A could print would always be N
        if(n<7) return n;

        // we store the values from 1 to 6 in a dp as these will be used to compute other sub-problems
        for(int i=1; i<7; i++)
        {
            dp[i] = i;
        }

        // Eg - for N = 10 --> we can print A using N=7 and then ctrl a, ctrl c, ctrl v
        /*
        For N = 10 --> A A A A A A A CA CC CV --> 7x2 = 14 times
                       A A A A A A CA CC CV CV --> 6x3 = 18 times
                       A A A A A CA CC Cv CV CV --> 5x4 = 20 times
                       A A A A CA CC CV CV CV CV --> 4x4 = 16 times
                       ..                        --> 3x5 = 15 times
                       ..                        --> 2x6 = 12 times
                       ..                        --> 1x7 = 7 times
                  there is also one more way of using d[7] = 7 and then CA, CC, CV --> 7x2 = 14
                  out of all the above ways 5x4 = 20 will give the max A's
                  hence we iterate from i=7 to N
                  and j = i-3 ( to account for CA, CC, CV )
                  since the first multiplier reduces and second increases --> we use dp[j] as prev stored values
                  and i-j-1 which increases from 2 to j
         */
        for(int i=7; i<=n ;i++)
        {
            for(int j=i-3; j>=1; j--)
            {
                int currentValue = dp[j] * (i-j-1);
                dp[i] = Math.max(currentValue, dp[i]);
            }
        }

        return dp[n];
    }
}
