package Design.LLD.SnakeLadder;

public class Dice {

    private final int maxValue;
    private final int minValue;

    public Dice(int maxValue, int minValue){
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public int roll()
    {
        return (int)(Math.random() * (maxValue - minValue + 1)) + minValue;
    }
}
