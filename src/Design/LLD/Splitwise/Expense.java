package Design.LLD.Splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Expense {

    protected Double totalAmount;
    protected List<User> participants;
    protected Map<User, Double> shares;
    protected SplitStrategy splitStrategy;

    public Expense(Double totalAmount, List<User> participants, SplitStrategy splitStrategy) {
        this.totalAmount = totalAmount;
        this.participants = participants;
        this.splitStrategy = splitStrategy;
    }

    public abstract void calculateShares();

    public Map<User, Double> getShares()
    {
        Map<User, Double> tempMap = new HashMap<>();
        for(Map.Entry<User, Double> entry : shares.entrySet())
        {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}
