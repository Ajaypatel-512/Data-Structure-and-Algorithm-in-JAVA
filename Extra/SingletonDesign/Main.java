package Extra.SingletonDesign;

import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) throws Exception {
        Car c1 = Car.getInstance();
        Car c2 = Car.getInstance();

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1 == c2);
        System.out.println("----------------------------------------------------------------");


        //Singleton Design Pattern can be breached by following
        //1. Reflection
        //2. Cloning
        //3. Serialization and Deserialization
        //4. Thread

        //1. Reflection
        Constructor<Car> constructor = Car.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Car c3 = constructor.newInstance();

        System.out.println(c3.hashCode());
        System.out.println(c1 == c3); // false, as c3 is a new instance created via reflection


        //Solution
        /**
         * Inside constructor of Car class, we can check if instance is not null
         *         if (instance != null) {
         *             throw new IllegalStateException("Reflection not allowed");
         *         }
         */

        System.out.println("----------------------------------------------------------------");

        //2. Threads
        //Multiple threads can create multiple instances if not handled properly.
        Runnable r = () -> {
            Car carInstance = Car.getInstance();
            System.out.println(carInstance.hashCode());
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        //Solution
        /**
         * Inside getInstance() method, we can use synchronized block or method to ensure that only one thread can access it at a time.
         * public static synchronized Car getInstance() {
         *             if (instance == null) {
         *                 instance = new Car();
         *             }
         *             return instance;
         *}
         *
         * Alternatively, we can use double-checked locking:
         * public static Car getInstance() {
         *            if (instance == null) {
         *              synchronized (Car.class) {
         *                  if (instance == null) {
         *                      instance = new Car();
         *                  }
         *              }
         *          }
         *          return instance;
         * }
         *
         * */

        System.out.println("----------------------------------------------------------------");

        //3. Cloning
        Car c4 = Car.getInstance();
        Car c5 = (Car) c4.clone(); // This will throw CloneNotSupportedException as Car does not implement Cloneable properly
        System.out.println(c4.hashCode());
        System.out.println(c5.hashCode());
        System.out.println(c4 == c5); // false, as c5 is a new instance created via cloning

        //Solution
        /**
         * Inside clone() method, we can throw CloneNotSupportedException
         * @Override
         * protected Object clone() throws CloneNotSupportedException {
         *     throw new CloneNotSupportedException("Cloning not allowed");
         * }
         */

        System.out.println("----------------------------------------------------------------");


        //4. Serialization and Deserialization
        // This can also create a new instance if not handled properly.
        // To prevent this, we can implement readResolve() method in the Car class.
        // public Object readResolve() {
        //     return getInstance();
        // }
        // This method will be called after deserialization and will return the existing instance instead of creating a new one.
        System.out.println("----------------------------------------------------------------");

    }


}
