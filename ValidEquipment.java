import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Represents a piece of equipment.  Clients can register new equipment
 * names at runtime or look up existing ones.
 */
public class ValidEquipment {
    private final String name;

    
    private static final Map<String, ValidEquipment> REGISTRY = new HashMap<>();

    // Private constructor: use register()/getByName() to obtain instances
    private ValidEquipment(String name) {
        this.name = name;
    }

    /** 
     * Register a new equipment (if not already present), returning its instance.
     * Name matching is case-insensitive.
     */
    public static ValidEquipment register(String name) {
        String key = name.trim().toUpperCase();
        return REGISTRY.computeIfAbsent(key, k -> new ValidEquipment(name.trim()));
    }

    /**
     * Lookup an equipment by name; returns null if none registered.
     */
    public static ValidEquipment getByName(String name) {
        if (name == null) return null;
        return REGISTRY.get(name.trim().toUpperCase());
    }

    /**
     * @return a read-only set of all registered equipment names.
     */
    public static Set<String> allNames() {
        return Collections.unmodifiableSet(REGISTRY.keySet());
    }

    @Override
    public String toString() {
        return name;
    }
}
