package Design.LLD.Amazon.Notification;

import Design.LLD.Amazon.Account;

public abstract class Notification {

    private int notificationId;
    private String notificationText;
    public abstract boolean sendNotification(Account account);
}
