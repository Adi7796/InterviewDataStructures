package Design.OOPS.HashCodeAndEqualsContract;

import java.util.HashSet;
import java.util.Set;

public class HashcodeAndEquals {
    public static void main(String[] args) {

        Pen pen1 = new Pen(10, "blue");
        Pen pen2 = new Pen(10, "blue");

        System.out.print("testing equality with = operator : ");
        System.out.println(pen1 == pen2);

        // if we define the logic for equals method inside Pen class
        // we can make both pens equal even if they point to 2 different references
        // we can make them equal by comparing the atributes of pen
        // without overriding equal -> false, after overriding -> true
        System.out.print("testing equality with equals method : ");
        System.out.println(pen1.equals(pen2));

        System.out.println("Pens with different hashcode");
        System.out.println(pen1.hashCode());
        System.out.println(pen2.hashCode());

        Set<Pen> penSet = new HashSet<>();

        penSet.add(pen1);
        penSet.add(pen2);

        // Since hashcode for both pens is different, hashset will allow both
        // pens to be inserted into the set even though they have same values
        System.out.println("Pen set has only 2 entries of pens as both pens have different");
        System.out.println(penSet);

        Pencil pencil = new Pencil(20, "red");
        Pencil pencil1 = new Pencil(20, "red");

        System.out.println("Pencils with same hashcode");
        System.out.println(pencil1.hashCode());
        System.out.println(pencil.hashCode());

        Set<Pencil> pencilSet = new HashSet<>();
        pencilSet.add(pencil);
        pencilSet.add(pencil1);

        System.out.println("Pencil set has only one entry of pencils as both pencils are the same");
        System.out.println(pencilSet);
    }
}
