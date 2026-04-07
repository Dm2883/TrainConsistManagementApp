public class UseCase19TrainConsistMgmt {

    public static void main(String[] args) {

        // Case 1: Empty train
        String[] bogieIds = {};   // EMPTY ARRAY

        String searchId = "BG309";

        try {
            searchBogie(bogieIds, searchId);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Case 2: Non-empty train
        String[] bogieIds2 = {"BG101", "BG205", "BG309", "BG412"};

        try {
            searchBogie(bogieIds2, searchId);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Search method with FAIL-FAST validation
    public static void searchBogie(String[] bogieIds, String searchId) {

        // ✅ Defensive Programming (Fail-Fast)
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in the train. Cannot perform search.");
        }

        // ---- Linear Search Logic ----
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