package Design.DesignPatterns.Creational.BuilderDesignPattern;

public class User {

    private final int userId;
    private final String userName;
    private final String emailId;

    public User(UserBuilder builder){
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.emailId = builder.emailId;
    }

    @Override
    public String toString() {
        return this.userId + " : " + this.userName + " : " + this.emailId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailId() {
        return emailId;
    }

    static class UserBuilder
    {
        private int userId;
        private String userName;
        private String emailId;


        // using this constructor to make the userID field mandatory
        // while creating the User Object
        // rest all fields are optional
        public UserBuilder(int userId){
            this.userId = userId;
        }

        public UserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder setEmailId(String emailId) {
            this.emailId = emailId;
            return this;
        }

        public User build(){
            User user = new User(this);
            return user;
        }
    }

}
