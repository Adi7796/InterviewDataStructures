package Immutable;

public class DriverClass {

    public static void main(String[] args) {

        DOB dob = new DOB();
        dob.setDate(12);
        dob.setMonth(03);
        dob.setYear(1996);

        ImmutableStudent immutableStudent = new ImmutableStudent("Aditya", 25, dob);
        System.out.println(immutableStudent);
    }
}
