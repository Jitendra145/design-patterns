public class ThreadSafeSingleton {

    // Static instance of the class, not initialized until requested
    private static ThreadSafeSingleton instance;

    // Private constructor to prevent instantiation from outside
    private ThreadSafeSingleton() {
        System.out.println("ThreadSafeSingleton instance created.");
    }

    // Public synchronized method to provide global access to the Singleton instance
    public static synchronized ThreadSafeSingleton getInstance() {
        // Check if the instance is null (lazy initialization)
        if (instance == null) {
            // Create the instance if it doesn't exist
            instance = new ThreadSafeSingleton();
        }
        // Return the single instance
        return instance;
    }

    // Example method to demonstrate functionality
    public void showMessage() {
        System.out.println("Hello from ThreadSafeSingleton!");
    }
}

// Test the Singleton
public class ThreadSafeSingletonTest {
    public static void main(String[] args) {
        // Get the Singleton instance and call a method on it
        ThreadSafeSingleton singleton1 = ThreadSafeSingleton.getInstance();
        singleton1.showMessage();

        // Another call to get the Singleton instance
        ThreadSafeSingleton singleton2 = ThreadSafeSingleton.getInstance();
        singleton2.showMessage();

        // Verify that the two references point to the same instance
        System.out.println(singleton1 == singleton2);  // Should print 'true'
    }
}
