package Design.OOPS.HashCodeAndEqualsContract;

public class Pencil {

    private int price;
    private String color;

    public Pencil(int price, String color) {
        this.price = price;
        this.color = color;
    }

    //Uncomment th below code to define the logic of equals
    @Override
    public boolean equals(Object obj){
        Pencil that = (Pencil)obj;

        boolean isEqual = this.price == that.price && this.color.equals(that.color);
        return isEqual;
    }

    @Override
    public int hashCode() {
        return price + color.hashCode();
    }

}
