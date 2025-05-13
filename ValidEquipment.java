import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Represents a piece of equipment.  
 * <p>
 * Clients may register new equipment names at runtime or look up existing ones
 * via a centralized, case-insensitive registry.
 * </p>
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
     * Register a new equipment name (if not already present), returning its instance.
     * <p>
     * Name matching is case-insensitive and leading/trailing whitespace is trimmed.
     * If an existing entry matches, that instance is returned; otherwise a new one
     * is created and stored.
     * </p>
     *
     * @param name the equipment name to register
     * @return the {@code ValidEquipment} instance for the given name
     */
    public static ValidEquipment register(String name) {
        String key = name.trim().toUpperCase();
        return REGISTRY.computeIfAbsent(key, k -> new ValidEquipment(name.trim()));
    }

    /**
     * Lookup an equipment by name.
     *
     * @param name the equipment name to look up (case-insensitive)
     * @return the matching {@code ValidEquipment} instance, or {@code null} if none registered
     */
    public static ValidEquipment getByName(String name) {
        if (name == null) {
            return null;
        }
        return REGISTRY.get(name.trim().toUpperCase());
    }

    /**
     * Returns a read-only view of all registered equipment names.
     * <p>
     * The returned set contains the uppercase keys used in the registry.
     * </p>
     *
     * @return an unmodifiable {@code Set<String>} of all registered equipment names
     */
    public static Set<String> allNames() {
        return Collections.unmodifiableSet(REGISTRY.keySet());
    }

    /**
     * Returns the original name of this equipment.
     *
     * @return the name as registered
     */
    @Override //ensures no unexpected compiler errors
    public String toString() {
        return name;
    }
}
