/**
 * Volatile keyword:
 *
 * The instance variable is declared volatile to ensure that changes made by one thread to the
 * instance are visible to all other threads. This is important for thread-safety in a multithreaded environment.
 *
 * First check (without synchronization):
 *
 * The first if (instance == null) check is done without synchronization. This is to avoid the performance cost
 * of acquiring a lock every time getInstance() is called
 *
 * Synchronized block:
 *
 * The synchronized block ensures that only one thread can create the singleton instance at a time. It’s executed
 * only if the instance is null, so it prevents multiple threads from entering this block simultaneously.
 *
 * Second check (within synchronization):
 *
 * The second if (instance == null) check is inside the synchronized block. This ensures that no other thread
 * has created an instance between the first check and acquiring the lock. This is the core of the double-checked locking technique.
 */
public class DoubleCheckedLockingSingleton {
    // Volatile variable ensures changes made by one thread are visible to others
    private static volatile DoubleCheckedLockingSingleton instance;

    // Private constructor to prevent instantiation
    private DoubleCheckedLockingSingleton() {
        // Initialization code, e.g., setting up resources
        System.out.println("DoubleCheckedLockingSingleton instance created.");
    }

    // Method to provide global access to the singleton instance
    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {  // First check (no synchronization)
            // Synchronize on the class object to prevent multiple threads from creating multiple instances
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {  // Second check (with synchronization)
                    instance = new DoubleCheckedLockingSingleton();  // Create the singleton instance
                }
            }
        }
        return instance;
    }

    // Example method to demonstrate functionality
    public void showMessage() {
        System.out.println("Hello from DoubleCheckedLockingSingleton!");
    }
}

// Test the Singleton
public class SingletonTest {
    public static void main(String[] args) {
        // Get the Singleton instance and call a method on it
        DoubleCheckedLockingSingleton singleton1 = DoubleCheckedLockingSingleton.getInstance();
        singleton1.showMessage();

        // Another call to get the Singleton instance
        DoubleCheckedLockingSingleton singleton2 = DoubleCheckedLockingSingleton.getInstance();
        singleton2.showMessage();

        // Verify that the two references point to the same instance
        System.out.println(singleton1 == singleton2);  // Should print 'true'
    }
}
