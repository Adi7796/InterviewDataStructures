package Design.DesignPatterns.ObserverPattern.Observable;

import Design.DesignPatterns.ObserverPattern.Observer.NotificationAlertObserver;

public interface PhoneStocksObservable {

    void add(NotificationAlertObserver notificationAlertObserver);

    void remove(NotificationAlertObserver notificationAlertObserver);

    void notifySubscribers();

    void setStockCount(int stockCount);

    int getStockCount();
}
