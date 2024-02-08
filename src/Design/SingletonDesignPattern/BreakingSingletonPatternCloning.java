package Design.SingletonDesignPattern;


import java.io.Serializable;

/*
 3) Cloning --> if we serialize after deserializing the object, we can break the singleton pattern
*/
public class BreakingSingletonPatternCloning implements Cloneable {

    private static BreakingSingletonPatternCloning breakingSingletonPattern;

    private BreakingSingletonPatternCloning(){};

    public static BreakingSingletonPatternCloning getObject(){
        if(breakingSingletonPattern == null)
            breakingSingletonPattern = new BreakingSingletonPatternCloning();

        return breakingSingletonPattern;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
        //To prevent cloning with a different hash code we can return the same breakingSingletonPattern instance
        // Uncomment the below line to prevent breaking of singleton pattern
        //return breakingSingletonPattern;
    }
}
