package Strings;

public class RunLengthEncoding {
    public static void main(String[] args) {
        String str = "wwwwaaadexxxxxx";
        StringBuffer resultString = new StringBuffer("");
        int n = str.length();
        for(int i=0; i<n; i++)
        {
            int count = 1;
            while(i<n-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            resultString.append(str.charAt(i)).append(count);
        }

        System.out.println("Encoded length : "+ resultString.toString());
    }
}

// Time Complexity : O(N)
