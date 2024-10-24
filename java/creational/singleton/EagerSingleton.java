public class EagerSingleton {
    // Step 1: Create a single instance of the class at the time of class loading (eager initialization)
    private static final EagerSingleton instance = new EagerSingleton();

    // Step 2: Private constructor to prevent instantiation from outside
    private EagerSingleton() {
        System.out.println("EagerSingleton instance created.");
    }

    // Step 3: Public method to provide global access to the instance
    public static EagerSingleton getInstance() {
        return instance;  // Return the single instance created at the time of class loading
    }

    // Example method to demonstrate functionality
    public void showMessage() {
        System.out.println("Hello from EagerSingleton!");
    }
}

// Test the Singleton
public class EagerSingletonTest {
    public static void main(String[] args) {
        // Get the Singleton instance and call a method on it
        EagerSingleton singleton1 = EagerSingleton.getInstance();
        singleton1.showMessage();

        // Another call to get the Singleton instance
        EagerSingleton singleton2 = EagerSingleton.getInstance();
        singleton2.showMessage();

        // Verify that the two references point to the same instance
        System.out.println(singleton1 == singleton2);  // Should print 'true'
    }
}
