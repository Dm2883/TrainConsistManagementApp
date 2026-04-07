public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Scenario 1: Empty train
        String[] emptyTrain = {};

        try {
            searchBogie(emptyTrain, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Scenario 2: Train with bogies
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412"};

        try {
            searchBogie(bogieIds, "BG309");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method implementing Fail-Fast Defensive Check
    public static void searchBogie(String[] bogieIds, String searchId) {

        // ✅ State Validation (Fail-Fast)
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException(
                    "Train has no bogies. Search operation cannot be performed."
            );
        }

        // ---- Linear Search ----
        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        // ---- Result ----
        if (found) {
            System.out.println("Bogie found: " + searchId);
        } else {
            System.out.println("Bogie not found: " + searchId);
        }
    }
}
