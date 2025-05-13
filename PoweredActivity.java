import java.util.Objects;

/**
 * The PoweredActivities class represents a special type of activity that uses equipment.
 * For example, biking with a bike, or running on a treadmill. It extends the Activities class
 * and adds information about the equipment used.
 *
 * If the equipment is not already registered, it will be registered automatically.
 * This class helps track which activities use which equipment.
 */
public class PoweredActivity extends Activity {
    /**
     * The equipment used for this powered activity (e.g., "Bike", "Treadmill").
     */
    private ValidEquipment equipment;

    /**
     * Creates a powered activity using a built-in transport mode (like WALKING, RUNNING, etc.).
     *
     * @param name The name of the activity (e.g., "Biking").
     * @param mode The built-in transport mode (enum value).
     * @param caloriesPerDistance How many calories are burned per unit distance.
     * @param distance The total distance for the activity.
     * @param equipmentName The name of the equipment used (e.g., "Bike").
     *                      If not already registered, it will be registered now.
     */
    public PoweredActivity(String name,
                             TransportMode mode,
                             int caloriesPerDistance,
                             int distance,
                             String equipmentName) {
        // Call the parent Activities constructor for built-in mode
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

    /**
     * Creates a powered activity using a custom (user-defined) transport mode.
     *
     * @param name The name of the activity (e.g., "Scootering").
     * @param customMode The custom transport mode (e.g., "SCOOTERING").
     * @param caloriesPerDistance How many calories are burned per unit distance.
     * @param distance The total distance for the activity.
     * @param equipmentName The name of the equipment used (e.g., "Scooter").
     *                      If not already registered, it will be registered now.
     */
    public PoweredActivity(String name,
                             String customMode,
                             int caloriesPerDistance,
                             int distance,
                             String equipmentName) {
        // Call the parent Activities constructor for custom mode
        super(name, customMode, caloriesPerDistance, distance);
        // Look up or register the equipment
        ValidEquipment eq = ValidEquipment.getByName(equipmentName);
        if (eq == null) {
            System.out.printf("'%s' was not a known equipment; registering it now.%n", equipmentName);
            eq = ValidEquipment.register(equipmentName);
        }
        this.equipment = eq;
        System.out.println("Created PoweredActivity → " + this);
    }

    /**
     * Gets the equipment used for this powered activity.
     *
     * @return The equipment object (shows the name of the equipment).
     */
    public ValidEquipment getEquipment() {
        return equipment;
    }

    /**
     * Returns a string that describes this powered activity, including the equipment used.
     *
     * @return A formatted string with all the details.
     */
    @Override
    public String toString() {
        return super.toString()
             + String.format("%nEquipment: %s", equipment);
    }

    /**
     * Used by Java to compare two PoweredActivities for equality.
     * This checks if both the activity details and the equipment are the same.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), equipment);
    }

    /**
     * Checks if this PoweredActivities object is equal to another object.
     * Two powered activities are equal if all their details and equipment match.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PoweredActivity)) return false;
        if (!super.equals(obj)) return false;
        PoweredActivity other = (PoweredActivity) obj;
        return Objects.equals(equipment, other.equipment);
    }
}
