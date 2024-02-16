package Design.DesignPatterns.ObserverPattern;

import Design.DesignPatterns.ObserverPattern.Observable.ApplePhoneObservableImpl;
import Design.DesignPatterns.ObserverPattern.Observable.PhoneStocksObservable;
import Design.DesignPatterns.ObserverPattern.Observer.EmailAlertObserverImpl;
import Design.DesignPatterns.ObserverPattern.Observer.MobileAlertObserverImpl;
import Design.DesignPatterns.ObserverPattern.Observer.NotificationAlertObserver;

public class Main {
    public static void main(String[] args) {
        PhoneStocksObservable observable = new ApplePhoneObservableImpl();
        observable.setStockCount(10);

        NotificationAlertObserver emailObserver = new EmailAlertObserverImpl("abc@xyz.com", observable);
        NotificationAlertObserver emailObserver2 = new EmailAlertObserverImpl("cvb@uio.com", observable);

        NotificationAlertObserver mobileObserver = new MobileAlertObserverImpl("234212123", observable);
        NotificationAlertObserver mobileObserver2 = new MobileAlertObserverImpl("98982138", observable);

        observable.add(emailObserver);
        observable.add(emailObserver2);
        observable.add(mobileObserver);
        observable.add(mobileObserver2);

        observable.notifySubscribers();

        observable.setStockCount(0);
    }
}
