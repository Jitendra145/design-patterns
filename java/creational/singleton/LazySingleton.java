public class LazySingleton {
    // Step 1: Create a private static instance variable
    private static LazySingleton instance;

    // Step 2: Create a private constructor to prevent instantiation
    private LazySingleton() {
    }

    // Step 3: Provide a public static method for accessing the singleton instance
    public static LazySingleton getInstance() {
        if (instance == null) {
            // Lazy initialization
            instance = new LazySingleton();
        }
        return instance;
    }
}

public class Test {
    public static void main(String[] args) {
        LazySingleton singleton1 = LazySingleton.getInstance();
        LazySingleton singleton2 = LazySingleton.getInstance();

        // Both will refer to the same instance
        System.out.println(singleton1 == singleton2);  // Outputs: true
    }
}
