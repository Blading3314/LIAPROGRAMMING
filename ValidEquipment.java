import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The ValidEquipment class represents a piece of equipment that can be used in an activity,
 * such as a bike, treadmill, or soccer ball.
 * 
 * All equipment is managed in a central registry, so you can look up, add, or list equipment
 * by name. Equipment names are case-insensitive and stored in a consistent way.
 * 
 * This class provides methods to:
 * - Register new equipment (if it doesn't already exist)
 * - Look up equipment by name
 * - List all registered equipment
 * 
 * Example usage:
 *   ValidEquipment.register("Bike");
 *   ValidEquipment.getByName("bike");
 *   ValidEquipment.allNames();
 */
public class ValidEquipment {
    
    /**
     * The canonical name of this equipment (as originally registered).
     */
    private final String name;

    /**
     * Registry of all known equipment, keyed by uppercase name.
     */
    private static final Map<String, ValidEquipment> REGISTRY = new HashMap<>();

    /**
     * Private constructor. Use {@link #register(String)} or {@link #getByName(String)}
     * to obtain instances.
     *
     * @param name the equipment name to store
     */
    private ValidEquipment(String name) {
        this.name = name;
    }

    /**
     * Registers a new piece of equipment, or returns the existing one if already registered.
     * Name matching is case-insensitive and ignores extra spaces.
     * @param name The equipment name to register
     * @return The ValidEquipment instance for the given name
     */
    public static ValidEquipment register(String name) {
        String key = name.trim().toUpperCase();
        return REGISTRY.computeIfAbsent(key, k -> new ValidEquipment(name.trim()));
    }

    /**
     * Looks up an equipment by name (case-insensitive).
     * @param name The equipment name to look up
     * @return The ValidEquipment instance, or null if not found
     */
    public static ValidEquipment getByName(String name) {
        if (name == null) {
            return null;
        }
        return REGISTRY.get(name.trim().toUpperCase());
    }

    /**
     * Returns a set of all registered equipment names (in uppercase).
     * @return An unmodifiable set of equipment names
     */
    public static Set<String> allNames() {
        return Collections.unmodifiableSet(REGISTRY.keySet());
    }

    /**
     * Returns the original name of this equipment as registered.
     */
    @Override
    public String toString() {
        return name;
    }
}
