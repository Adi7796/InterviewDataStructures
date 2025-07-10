package Design.LLD.Splitwise;

import java.util.List;

public class UnequalExpenseFactory implements ExpenseFactory {

    @Override
    public Expense createExpense(List<User> participants, Double totalAmount) {
        return new UnequalExpense(totalAmount, participants);
    }
}
