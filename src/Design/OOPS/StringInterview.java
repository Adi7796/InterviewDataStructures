package Design.OOPS;

public class StringInterview {
    public static void main(String[] args) {

        String str1 = "Aditya";
        String str2 = "Aditya";

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        String str3 = new String("Aditya");
        String str4 = new String("Aditya");

        System.out.println(str3 == str4);
        System.out.println(str3.equals(str4));

        String str5 = new String("Aditya").intern();
        String str6 = new String("Aditya").intern();

        System.out.println(str5 == str6);
        System.out.println(str5.equals(str6));
    }
}
