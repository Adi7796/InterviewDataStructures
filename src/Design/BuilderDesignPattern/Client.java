package Design.BuilderDesignPattern;

public class Client {
    public static void main(String[] args) {

        User user = new User.UserBuilder()
                .setUserId(1234)
                .setUserName("Aditya")
                .setEmailId("adit@123.com")
                .build();

        System.out.println(user);
    }
}
