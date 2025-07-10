package Design.LLD.Splitwise;

import java.util.List;

public class EqualExpenseFactory implements ExpenseFactory{

    @Override
    public Expense createExpense(List<User> participants, Double totalAmount) {
        return new EqualExpense(totalAmount, participants);
    }
}
