public class UseCase15TrainConsistMgmt {

    // Custom Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie class
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        void assignCargo(String cargo) {
            try {
                // Rule: Rectangular bogie cannot carry Petroleum
                if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned successfully: " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Assignment attempt completed.\n");
            }
        }
    }

    public static void main(String[] args) {
        GoodsBogie bogie1 = new GoodsBogie("Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("Cylindrical");

        bogie1.assignCargo("Petroleum"); // unsafe
        bogie2.assignCargo("Petroleum"); // safe
    }
}