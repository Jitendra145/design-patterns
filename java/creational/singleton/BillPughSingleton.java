public class BillPughSingleton {

    // Private constructor to prevent instantiation
    private BillPughSingleton() {
        System.out.println("BillPughSingleton instance created.");
    }

    // Static inner helper class responsible for holding the Singleton instance
    private static class SingletonHelper {
        // The static final instance is created only when the SingletonHelper class is loaded
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    // Public method to provide global access to the Singleton instance
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;  // Return the instance from the inner static class
    }

    // Example method to demonstrate functionality
    public void showMessage() {
        System.out.println("Hello from BillPughSingleton!");
    }
}

// Test the Singleton
public class BillPughSingletonTest {
    public static void main(String[] args) {
        // Get the Singleton instance and call a method on it
        BillPughSingleton singleton1 = BillPughSingleton.getInstance();
        singleton1.showMessage();

        // Another call to get the Singleton instance
        BillPughSingleton singleton2 = BillPughSingleton.getInstance();
        singleton2.showMessage();

        // Verify that the two references point to the same instance
        System.out.println(singleton1 == singleton2);  // Should print 'true'
    }
}
