package Design.LLD.Splitwise;

import java.util.List;

public class UnequalExpense extends Expense {

    public UnequalExpense(Double totalAmount, List<User> participants) {
        super(totalAmount, participants, new UnequalSplitStrategy());
    }

    @Override
    public void calculateShares() {
        shares = splitStrategy.splitExpense(totalAmount, participants);
    }
}
