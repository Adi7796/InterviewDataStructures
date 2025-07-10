package Design.LLD.Splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements SplitStrategy{

    @Override
    public Map<User, Double> splitExpense(Double totalAmount, List<User> participants) {
        Map<User, Double> shares = new HashMap<>();
        Double equalShare = totalAmount/participants.size();
        for(User user : participants)
        {
            shares.put(user, equalShare);
        }
        return shares;
    }
}
