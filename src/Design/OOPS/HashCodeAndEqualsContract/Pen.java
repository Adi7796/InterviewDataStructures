package Design.OOPS.HashCodeAndEqualsContract;

import java.util.Objects;

public class Pen {

    private int price;
    private String color;

    public Pen(int price, String color) {
        this.price = price;
        this.color = color;
    }

    //Uncomment th below code to define the logic of equals
//    @Override
//    public boolean equals(Object obj){
//        Pen that = (Pen)obj;
//
//        boolean isEqual = this.price == that.price && this.color.equals(that.color);
//        return isEqual;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return price == pen.price && Objects.equals(color, pen.color);
    }
}
