package Design.LLD.Splitwise;

public class ExpenseObserver implements Observer{

    @Override
    public void updateObserver() {
        System.out.println("Notifying observers.. ");
    }
}
