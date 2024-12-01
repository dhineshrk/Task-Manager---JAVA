// Abstract Handler Class
abstract class Logger {
    protected int level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);
}

// Concrete Handler 1: InfoLogger
class InfoLogger extends Logger {
    public InfoLogger() {
        this.level = 1; // Info level is 1
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO: " + message);
    }
}

// Concrete Handler 2: DebugLogger
class DebugLogger extends Logger {
    public DebugLogger() {
        this.level = 2; // Debug level is 2
    }

    @Override
    protected void write(String message) {
        System.out.println("DEBUG: " + message);
    }
}

// Concrete Handler 3: ErrorLogger
class ErrorLogger extends Logger {
    public ErrorLogger() {
        this.level = 3; // Error level is 3
    }

    @Override
    protected void write(String message) {
        System.out.println("ERROR: " + message);
    }
}

// Client Code
public class ChainOfResponsibility {
    public static void main(String[] args) {
        // Create the chain of responsibility
        Logger infoLogger = new InfoLogger();
        Logger debugLogger = new DebugLogger();
        Logger errorLogger = new ErrorLogger();

        // Set up the chain: InfoLogger -> DebugLogger -> ErrorLogger
        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);

        // Sending log messages
        System.out.println("Logging INFO message:");
        infoLogger.logMessage(1, "This is an info message.");
        
        System.out.println("\nLogging DEBUG message:");
        infoLogger.logMessage(2, "This is a debug message.");
        
        System.out.println("\nLogging ERROR message:");
        infoLogger.logMessage(3, "This is an error message.");
    }
}
