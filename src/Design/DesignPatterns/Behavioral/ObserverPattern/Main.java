package Design.DesignPatterns.Behavioral.ObserverPattern;

import Design.DesignPatterns.Behavioral.ObserverPattern.Observable.ApplePhoneObservableImpl;
import Design.DesignPatterns.Behavioral.ObserverPattern.Observable.PhoneStocksObservable;
import Design.DesignPatterns.Behavioral.ObserverPattern.Observer.EmailAlertObserverImpl;
import Design.DesignPatterns.Behavioral.ObserverPattern.Observer.MobileAlertObserverImpl;
import Design.DesignPatterns.Behavioral.ObserverPattern.Observer.NotificationAlertObserver;

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
