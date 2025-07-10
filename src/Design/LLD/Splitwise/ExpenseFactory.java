package Design.LLD.Splitwise;

import java.util.List;

public interface ExpenseFactory {
    Expense createExpense(List<User> participants, Double totalAmount);
}
