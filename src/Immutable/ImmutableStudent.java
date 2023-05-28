package Immutable;

public final class ImmutableStudent {

    private final String name;
    private final int age;
    private final DOB dob;

    public ImmutableStudent(String name, int age, DOB dob){
        this.age=age;
        this.name=name;
        this.dob=dob;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public DOB getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "ImmutableStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                '}';
    }
}
