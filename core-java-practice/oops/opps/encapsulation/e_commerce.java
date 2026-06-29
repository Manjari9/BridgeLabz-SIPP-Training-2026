 
class Package {
    private String trackingId;
    private double weight;
    public Package(String trackingId, double weight) {
        this.trackingId = trackingId;
        setWeight(weight);
    }
    public String getTrackingId() {
        return trackingId;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        if (weight <= 0.0) {
            System.out.println("Error: Weight must be greater than 0. Current weight unchanged.");
        } else {
            this.weight = weight;
        }
    }
}
class ExpressPackage extends Package {
    private String priorityLevel;
    public ExpressPackage(String trackingId, double weight, String priorityLevel) {
        super(trackingId, weight);
        this.priorityLevel = priorityLevel;
    }
    public String getPriorityLevel() {
        return priorityLevel;
    }
    public void printShippingLabel() {
        System.out.println("========== SHIPPING LABEL ==========");
        System.out.println("Tracking ID   : " + getTrackingId());
        System.out.println("Weight (kg)   : " + getWeight());
        System.out.println("Priority Level: " + priorityLevel);
        System.out.println("====================================");
    }
}
public class e_commerce {
    public static void main(String[] args) {
        System.out.println("--- Scenario A: Valid Input ---");
        ExpressPackage pkg1 = new ExpressPackage("EXP101", 2.5, "Critical");
        pkg1.printShippingLabel();
        
        System.out.println("\n--- Scenario B: Invalid Input - Negative Weight ---");
        ExpressPackage pkg2 = new ExpressPackage("EXP102", 1.0, "High");
        pkg2.setWeight(-1.5);
        System.out.println("Tracking ID: " + pkg2.getTrackingId());
        System.out.println("Weight: " + pkg2.getWeight());
        
        System.out.println("\n--- Scenario B: Invalid Input - Zero Weight ---");
        ExpressPackage pkg3 = new ExpressPackage("EXP103", 3.0, "High");
        pkg3.setWeight(0.0);
        System.out.println("Tracking ID: " + pkg3.getTrackingId());
        System.out.println("Weight: " + pkg3.getWeight());
        
        System.out.println("\n--- Standard Package Example ---");
        Package standardPkg = new Package("STD001", 5.0);
        System.out.println("Standard Package - Tracking ID: " + standardPkg.getTrackingId());
        System.out.println("Standard Package - Weight: " + standardPkg.getWeight());
    }
}

