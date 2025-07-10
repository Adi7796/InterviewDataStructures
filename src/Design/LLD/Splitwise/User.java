package Design.LLD.Splitwise;

public class User {

    private int userId;
    private String userName;
    private int sharePercentage;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSharePercentage(int sharePercentage){ this.sharePercentage = sharePercentage;}

    public int getSharePercentage(){ return sharePercentage; }
}
