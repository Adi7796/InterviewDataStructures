package Design.LLD.Splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnequalSplitStrategy implements SplitStrategy{

    @Override
    public Map<User, Double> splitExpense(Double totalAmount, List<User> participants) {
        Map<User, Double> shareMap = new HashMap<>();
        double amount = 0;
        for(User user : participants)
        {
            double currentShare = ((double)user.getSharePercentage()/100) * totalAmount;
            amount += currentShare;
            shareMap.put(user, currentShare);
        }

        if(amount != totalAmount){
            throw new ArithmeticException("Amount " + amount + " does not add up to the total amount : " + totalAmount);
        }
        return shareMap;
    }
}
