package Design.DesignPatterns.Behavioral.ObserverPattern.Observable;

import Design.DesignPatterns.Behavioral.ObserverPattern.Observer.NotificationAlertObserver;

public interface PhoneStocksObservable {

    void add(NotificationAlertObserver notificationAlertObserver);

    void remove(NotificationAlertObserver notificationAlertObserver);

    void notifySubscribers();

    void setStockCount(int stockCount);

    int getStockCount();
}
