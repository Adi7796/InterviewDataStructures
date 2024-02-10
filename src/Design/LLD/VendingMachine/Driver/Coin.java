package Design.LLD.VendingMachine.Driver;

public enum Coin {

    TWO(2),
    FIVE(5),
    TEN(10),
    TWENTY(20);

    public int value;

    Coin(int value){
        this.value = value;
    }
}
