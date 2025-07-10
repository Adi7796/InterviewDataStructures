package Design.LLD.Splitwise;

import java.util.ArrayList;
import java.util.List;

public class SplitwiseFacade {

    private UserManager userManager;
    private List<Observer> observerList;
    private List<Expense> expensesList;

    public SplitwiseFacade()
    {
        userManager = UserManager.getUserManagerInstance();
        observerList = new ArrayList<>();
        expensesList = new ArrayList<>();
    }
    public void addUser(User user)
    {
        userManager.addUser(user);
    }

    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    public Expense addEqualExpense(Double totalAmount, List<User> participants)
    {
        ExpenseFactory equalExpenseFactory = new EqualExpenseFactory();
        Expense expense = equalExpenseFactory.createExpense(participants, totalAmount);

        expense.calculateShares();
        expensesList.add(expense);

        return expense;
    }

    public Expense addUnequalExpense(Double totalAmount, List<User> participants)
    {
        ExpenseFactory unequalExpenseFactory = new UnequalExpenseFactory();
        Expense expense = unequalExpenseFactory.createExpense(participants, totalAmount);

        expense.calculateShares();
        expensesList.add(expense);

        return expense;
    }

    public void notifyObservers()
    {
        for(Observer observer : observerList){
            observer.updateObserver();
        }
    }
}
