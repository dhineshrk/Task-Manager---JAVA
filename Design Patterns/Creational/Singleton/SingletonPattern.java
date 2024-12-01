import java.util.HashMap;
import java.util.Map;

public class SingletonPattern {
    private static SingletonPattern instance;
    private Map<String, String> config = new HashMap<>();

    // Private constructor to prevent instantiation
    private SingletonPattern() {}

    // Method to get the instance of ConfigurationManager
    public static SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }
        return instance;
    }

    // Method to set a configuration
    public void setConfig(String key, String value) {
        config.put(key, value);
    }

    // Method to get a configuration
    public String getConfig(String key) {
        return config.get(key);
    }

    public static void main(String[] args) {
        // Client Code
        SingletonPattern configManager1 = SingletonPattern.getInstance();
        configManager1.setConfig("apiUrl", "https://api.example.com");

        SingletonPattern configManager2 = SingletonPattern.getInstance();
        System.out.println(configManager2.getConfig("apiUrl")); // Output: https://api.example.com

        System.out.println(configManager1 == configManager2); // Output: true
    }
}
