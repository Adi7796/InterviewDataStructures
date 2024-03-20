package Design.LLD.CarRentalSystem.Service;

public class User {

    private int userId;
    private String userName;
    private String drivingLicenseNumber;

    public User(int userId, String userName, String drivingLicenseNumber) {
        this.userId = userId;
        this.userName = userName;
        this.drivingLicenseNumber = drivingLicenseNumber;
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

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }
}
