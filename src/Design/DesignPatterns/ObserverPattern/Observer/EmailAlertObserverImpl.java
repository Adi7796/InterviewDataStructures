package Design.DesignPatterns.ObserverPattern.Observer;

import Design.DesignPatterns.ObserverPattern.Observable.PhoneStocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    String emailId;
    PhoneStocksObservable phoneStocksObservable;

    public EmailAlertObserverImpl(String emailId, PhoneStocksObservable phoneStocksObservable){
        this.emailId = emailId;
        this.phoneStocksObservable = phoneStocksObservable;
    }
    @Override
    public void updateObservers() {
        sendEmail(emailId, phoneStocksObservable);
    }

    public void sendEmail(String emailId, PhoneStocksObservable phoneStocksObservable){
        System.out.println("Notified Observer over email : " + emailId + " stock : " + phoneStocksObservable.getStockCount());
    }
}
