// Enum Singleton definition
public enum Logger {
    INSTANCE;

    // Example method to log messages
    public void log(String message) {
        System.out.println("Log entry: " + message);
    }
}

// Class to test the Enum Singleton
public class SingletonTest {
    public static void main(String[] args) {
        // Access the single instance of Logger
        Logger logger = Logger.INSTANCE;

        // Use the logger to log messages
        logger.log("Application started");
        logger.log("Processing request");
        logger.log("Application stopped");
    }
}
