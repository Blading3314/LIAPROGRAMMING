
import java.util.Objects;

/**
 * A {@code PoweredActivities} represents an {@link Activities} that
 * additionally uses a specific piece of equipment, tracked via {@link ValidEquipment}.
 * <p>
 * If the provided equipment name is not already known, it is registered on first use.
 * </p>
 */
public class PoweredActivities extends Activities {
    
    /**
     * The equipment used for this powered activity.
     */
    private ValidEquipment equipment;

    /**
     * Constructs a new PoweredActivities instance.
     *
     * @param name               the name of the activity
     * @param mode               the transport mode for the activity
     * @param caloriesPerDistance the number of calories burned per unit distance
     * @param distance           the total distance for the activity
     * @param equipmentName      the name of the equipment to use;
     *                           if unknown, it will be registered automatically
     */
    public PoweredActivities(String name,
                             TransportMode mode,
                             int caloriesPerDistance,
                             int distance,
                             String equipmentName) {
        super(name, mode, caloriesPerDistance, distance);
        
        // Look up or register equipment by name
        ValidEquipment eq = ValidEquipment.getByName(equipmentName);
        if (eq == null) {
            System.out.printf("'%s' was not a known equipment; registering it now.%n", equipmentName);
            eq = ValidEquipment.register(equipmentName);
        }
        this.equipment = eq;
        System.out.println("Created PoweredActivity → " + this);
    }

    /**
     * Returns the equipment associated with this activity.
     *
     * @return the {@link ValidEquipment} used
     */
    public ValidEquipment getEquipment() {
        return equipment;
    }

    /**
     * Returns a string representation of this powered activity,
     * including its base activity info plus the equipment details.
     *
     * @return formatted string describing the activity
     */
    @Override
    public String toString() {
        return super.toString()
             + String.format("%nEquipment: %s", equipment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), equipment);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PoweredActivities)) return false;
        if (!super.equals(obj)) return false;
        PoweredActivities other = (PoweredActivities) obj;
        return Objects.equals(equipment, other.equipment);
    }
}
