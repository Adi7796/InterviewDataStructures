package Strings;

public class ReverseAString {
    public static void main(String[] args) {
        String str = "aditya";
        char[] ch = str.toCharArray();
        int len = str.length();
        char temp ;
        for(int i=0, j=len -1; i<j; i++,j--)
        {
            temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
        System.out.println(ch);
    }
}
