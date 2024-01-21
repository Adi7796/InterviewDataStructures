package Strings;

import java.util.ArrayList;

public class SubequencesOfString {

    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        String str = "abc";
        findSubsequences(str,"");
        System.out.println(list);
    }

    public static void findSubsequences(String str, String ans)
    {
        if(str.length() == 0){
            list.add(ans);
            return;
        }

        // we pick the first character and run recursion on the remaining string
        findSubsequences(str.substring(1), ans + str.charAt(0));

        // we dont pick the first character and run recursion on the remaining string
        findSubsequences(str.substring(1), ans);
    }
}

//  Time complexity - 2^n