package Design.LLD.Splitwise;

import java.util.List;
import java.util.Map;

public class SplitwiseApp {

    public static void main(String[] args) {
        SplitwiseFacade splitwise = new SplitwiseFacade();

        User user1 = new User(101, "Aditya");
        User user2 = new User(102, "Khyati");
        User user3 = new User(103, "XYZ");
        splitwise.addUser(user1);
        splitwise.addUser(user2);
        splitwise.addUser(user3);

        splitwise.addObserver(new ExpenseObserver());

        Expense expense = splitwise.addEqualExpense(1000.00, List.of(user1, user2, user3));
        for(Map.Entry<User, Double> entry : expense.getShares().entrySet())
        {
            System.out.println(entry.getKey().getUserName() + " owes " + entry.getValue());
        }
        user1.setSharePercentage(20);
        user2.setSharePercentage(30);
        user3.setSharePercentage(50);

        Expense unequalExpense = splitwise.addUnequalExpense(1000.00, List.of(user1, user2, user3));
        for(Map.Entry<User, Double> entry : unequalExpense.getShares().entrySet())
        {
            System.out.println(entry.getKey().getUserName() + " owes " + entry.getValue());
        }


        splitwise.notifyObservers();
    }
}
