package Design.DesignPatterns.ObserverPattern.Observable;

import Design.DesignPatterns.ObserverPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class ApplePhoneObservableImpl implements PhoneStocksObservable{

    List<NotificationAlertObserver> notificationAlertObserverList = new ArrayList<>();
    int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        notificationAlertObserverList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        notificationAlertObserverList.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver notificationAlertObserver1 : notificationAlertObserverList){
            notificationAlertObserver1.updateObservers();
        }
    }

    @Override
    public void setStockCount(int newStockCount) {
        if(stockCount == 0){
            notifySubscribers();
        }
        stockCount = stockCount + newStockCount;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
