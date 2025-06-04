package Extra.SingletonDesign;

public class Car implements Cloneable {
    private static Car instance;
    private Car(){
        // 1. Prevents Reflection
        if (instance != null) {
            throw new IllegalStateException("Reflection not allowed");
        }
    }

    public static Car getInstance() {
        if (instance == null) {
            instance = new Car();
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
