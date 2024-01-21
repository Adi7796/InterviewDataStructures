package Strings;

public class PermutationsOfString {
    public static void main(String[] args) {
        String str = "abcc";
        permute(str, 0, str.length()-1);
    }

    public static void permute(String str, int l, int r)
    {
        if(l==r){
            System.out.println(str);
            return;
        }

        for(int i=l; i<=r; i++)
        {
            str = swap(str, l, i);
            permute(str, l+1, r);
            str = swap(str, l, i);
        }
    }

    public static String swap(String str, int index1, int index2){
        char[] ch = str.toCharArray();
        char temp;

        temp = ch[index1];
        ch[index1] = ch[index2];
        ch[index2] = temp;

        return String.valueOf(ch);
    }
}

/*Time Complexity: O(N * N!) Note that there are N! permutations and it requires O(N) time to print a permutation.
Auxiliary Space: O(R – L)

Note: The above solution prints duplicate permutations if there are repeating characters in the input string.
Please see the below link for a solution that prints only distinct permutations even if there are duplicates in input.*/