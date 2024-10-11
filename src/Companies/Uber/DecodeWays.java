package Companies.Uber;

import java.util.ArrayList;
import java.util.List;

/*
You have intercepted a secret message encoded as a string of numbers.
The message is decoded via the following mapping:

"1" -> 'A'

"2" -> 'B'

...

"25" -> 'Y'

"26" -> 'Z'

However, while decoding the message, you realize that there are many different
ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").

For example, "11106" can be decoded into:

"AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
Note: there may be strings that are impossible to decode.

Given a string s containing only digits, return the number of ways to decode it.
If the entire string cannot be decoded in any valid way, return 0.

The test cases are generated so that the answer fits in a 32-bit integer.
 */
public class DecodeWays {

    public static void main(String[] args) {
        String st = "11106";

        List<String> res = new ArrayList<>();
        String ansString = "";
        printCombinations(0, res, st, ansString);

        for(String s : res)
        {
            System.out.println(s);
        }

        System.out.println(findCombinationsDp(st));
    }

    public static void printCombinations(int index, List<String> res, String st, String ansString)
    {
        if(index == st.length())
        {
            res.add(ansString);
            return;
        }

        for(int i = index; i<st.length(); i++)
        {
            String s = st.substring(index, i+1);
            int number = Integer.parseInt(s);
            if(number == 0) break;
            if(number <= 26)
            {
                char ch = (char)(65 + number - 1);
                ansString += String.valueOf(ch);
                printCombinations(i+1, res, st, ansString);
                ansString = ansString.substring(0, ansString.length()-1);
            }
        }
    }

    public static int findCombinationsDp(String st)
    {
        int[] dp = new int[st.length()];
        dp[0] = st.charAt(0) == '0' ? 0 : 1;  // to handle cases like "06" and "0" --> o/p should be 0 and not 1

        for(int i = 1; i<st.length(); i++)
        {
            // last 2 characters are 0 -- 21300
            // can be broken as 2113-0 and 2113-00 (both cannot be encoded)
            if(st.charAt(i) == '0' && st.charAt(i-1) == '0')
            {
                dp[i] = 0;
            }

            // last 2 characters are non-zero and 0 --> 211420
            // can be broken as 21142-0 and 2114-20
            else if(st.charAt(i-1) != '0' && st.charAt(i) == '0')
            {
                // last 2 characters are 30/40/50
                // 211430
                if(Integer.parseInt(st.substring(i-1, i+1)) > 26)
                {
                    dp[i] = 0;
                }
                // else the last 2 numbers are less than 26 : eg 20
                // since i is at 0 --> dp[i] can be calculated by only using 2114-20
                // which is the same value as dp[i-2] till 2114 since we can only append 20 to 2114 combinations
                else{
                    dp[i] = i>=2 ? dp[i-2] : 1;
                }
            }

            // last 2 characters are 0 and non zero --> 211403
            // can be broken down as
            // 2114-03 : cant be decoded as there nothing like 03
            // 21140-3 : 3 can be decoded and is equal to dp[i-1] as we just append the encoded value of 3 to 21140
            else if(st.charAt(i-1) == '0' && st.charAt(i) != '0')
            {
                dp[i] = dp[i-1];
            }

            // last 2 characters are non zeros ---> 211423
            // can be broken down as
            // 2114-23 : equal to dp[i-1]
            // 21132-3 : equal to dp[i-2] if 23<= 26 else 0
            else
            {
                // if the last 2 characters are greater than 26
                // like 2114-46, we can only individually encode 4 and 6 and then append it to 2114
                // hence the number of ways = dp[i-1]
                if(Integer.parseInt(st.substring(i-1, i+1)) > 26)
                {
                    dp[i] = dp[i-1];
                }
                else {
                    // suppose we have just st = "23"
                    // i = 1 --> 3
                    // hence dp[i] = dp[i-1] ( no. of ways to encode till 2 ) + number of wats to encode 3
                    // dp[i] = 1 + 1 = 2 ( BC and W )
                    dp[i] = dp[i-1] + (i >=2 ? dp[i-2] : 1);
                }
            }
        }

        return dp[dp.length-1];
    }
}
