package Design.DesignPatterns.Creational.SingletonDesignPattern;


import java.io.Serializable;

/*
 2) Deserialization --> if we serialize after deserializing the object, we can break the singleton pattern
*/
public class BreakingSingletonPattern implements Serializable {

    private static BreakingSingletonPattern breakingSingletonPattern;

    private BreakingSingletonPattern(){};

    public static BreakingSingletonPattern getObject(){
        if(breakingSingletonPattern == null)
            breakingSingletonPattern = new BreakingSingletonPattern();

        return breakingSingletonPattern;
    }

    // Uncomment this method to prevent break using deserialization
    // Serializable interface internally implements this method to solve for the breaking
//    public Object readResolve() {
//        return breakingSingletonPattern;
//    }
}
