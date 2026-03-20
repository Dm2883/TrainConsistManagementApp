import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        
        System.out.println("=== Train Consist Management App ===");

        // Initialize empty train consist
        List<String> trainConsist = new ArrayList<>();

        // Display initial bogie count
        System.out.println("Train initialized successfully.");
        System.out.println("Initial bogie count: " + trainConsist.size());

        // Current state
        System.out.println("Current train consist: " + trainConsist);
    }
}
