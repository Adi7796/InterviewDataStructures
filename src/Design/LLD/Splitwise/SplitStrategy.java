package Design.LLD.Splitwise;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {

    Map<User, Double> splitExpense(Double totalAmount, List<User> participants);
}
