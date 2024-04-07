package Design.LLD.Amazon.Notification;

import Design.LLD.Amazon.Account;

public class PhoneNotification extends Notification{
    @Override
    public boolean sendNotification(Account account) {
        return false;
    }
}
