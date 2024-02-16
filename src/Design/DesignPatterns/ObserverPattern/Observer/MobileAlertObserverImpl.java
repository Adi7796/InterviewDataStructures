package Design.DesignPatterns.ObserverPattern.Observer;

import Design.DesignPatterns.ObserverPattern.Observable.PhoneStocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{

    String mobileNumber;
    PhoneStocksObservable phoneStocksObservable;

    public MobileAlertObserverImpl(String mobileNumber, PhoneStocksObservable phoneStocksObservable){
        this.mobileNumber = mobileNumber;
        this.phoneStocksObservable = phoneStocksObservable;
    }
    @Override
    public void updateObservers() {
        sendSMS(mobileNumber, phoneStocksObservable);
    }

    public void sendSMS(String mobileNumber, PhoneStocksObservable phoneStocksObservable){
        System.out.println("Notified Observer over phone : " + mobileNumber + " stock : " + phoneStocksObservable.getStockCount());
    }
}
