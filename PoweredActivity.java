import java.util.Objects;

/**
 * The PoweredActivity class represents an activity that uses a specific piece of equipment,
 * such as biking with a bike or running on a treadmill.
 * 
 * This class extends Activity and adds information about the equipment used.
 * If the equipment is not already registered, it will be added automatically.
 * 
 * PoweredActivity helps track which activities use which equipment, and provides
 * methods to get details about the equipment for each activity.
 */
public class PoweredActivity extends Activity {
    /** The equipment used for this powered activity (e.g., "Bike", "Treadmill"). */
    private ValidEquipment equipment;

    /**
     * Creates a powered activity using either a built-in or custom transport mode.
     * If the equipment is not already registered, it will be added automatically.
     * @param name The name of the activity (e.g., "Biking")
     * @param mode The transport mode (enum or custom string)
     * @param caloriesPerDistance Calories burned per unit distance
     * @param distance The total distance for the activity
     * @param equipmentName The name of the equipment used (e.g., "Bike")
     */
    public PoweredActivity(String name,
                          Object mode,
                          int caloriesPerDistance,
                          int distance,
                          String equipmentName) {
        super(name, mode, caloriesPerDistance, distance);
        
        // Look up or register the equipment
        ValidEquipment eq = ValidEquipment.getByName(equipmentName);
        if (eq == null) {
            System.out.printf("'%s' was not a known equipment; registering it now.%n", equipmentName);
            eq = ValidEquipment.register(equipmentName);
        }
        this.equipment = eq;
        System.out.println("Created PoweredActivity → " + this);
    }

    /** Returns the equipment used for this powered activity. */
    public ValidEquipment getEquipment() {
        return equipment;
    }

    /** Returns a string describing this powered activity, including the equipment used. */
    @Override
    public String toString() {
        return super.toString()
             + String.format("%nEquipment: %s", equipment);
    }

    // Standard equality and hashCode methods for comparing PoweredActivity objects
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), equipment);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PoweredActivity)) return false;
        if (!super.equals(obj)) return false;
        PoweredActivity other = (PoweredActivity) obj;
        return Objects.equals(equipment, other.equipment);
    }
}
