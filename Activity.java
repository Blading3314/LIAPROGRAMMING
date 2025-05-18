
import java.util.*;
/**
 * The Activities class represents a physical activity performed by athletes.
 * It supports both built-in (enum) and user-defined (custom) transport modes,
 * and can be extended for powered activities (with equipment).
 *
 * Activities are tracked globally in a static list, and can be queried,
 * listed, and analyzed by various criteria (mode, athlete, calories, etc).
 */
public class Activity {
    /**
     * The transport mode for this activity (enum, or null if custom).
     */
    protected TransportMode mode;
    /**
     * The custom transport mode for this activity (null if using enum).
     */
    protected String customMode = null;
    /**
     * The name of the activity (e.g., "Running").
     */
    protected String activityName;
    /**
     * The total calories lost for this activity (calculated).
     */
    protected int caloriesLost;
    /**
     * Calories burned per unit distance (e.g., per km).
     */
    protected int caloriesPerDistance;
    /**
     * The distance of the activity (e.g., in km).
     */
    protected int distance;
    /**
     * List of athletes who performed this activity.
     */
    protected List<Athlete> athletes;
    /**
     * Global list of all activities (for listing, stats, etc).
     */
    protected static List<Activity> allActivities = new ArrayList<>();
    /**
     * Set of all custom (user-defined) transport modes.
     */
    protected static Set<String> customModes = new HashSet<>();

    /**
     * Constructor for built-in (enum) transport mode.
     */
    public Activity(String activityName, TransportMode mode, int caloriesPerDistance, int distance) {
        this.activityName = activityName;
        this.mode = mode;
        this.customMode = null;
        this.caloriesPerDistance = caloriesPerDistance;
        this.distance = distance;
        this.athletes = new ArrayList<>();
        allActivities.add(this);
    }

    /**
     * Constructor for custom (user-defined) transport mode.
     */
    public Activity(String activityName, String customMode, int caloriesPerDistance, int distance) {
        this.activityName = activityName;
        this.mode = null;
        this.customMode = customMode;
        this.caloriesPerDistance = caloriesPerDistance;
        this.distance = distance;
        this.athletes = new ArrayList<>();
        allActivities.add(this);
    }

    /**
     * Calculates and returns the total calories lost for this activity.
     * @return total calories lost (caloriesPerDistance * distance)
     */
    public int getCaloriesPerDistance() {
        caloriesLost = caloriesPerDistance * distance;
        return caloriesLost;
    }

    /**
     * Associates an athlete with this activity.
     * @param athlete the athlete to add
     */
    public void setAthlete(Athlete athlete) {
        athletes.add(athlete);
    }

    /**
     * Lists the names of all activities.
     */
    public static void listActivities() {
        for (Activity activity : allActivities) {
            System.out.println(activity.activityName);
        }
    }

    /**
     * Lists all activities grouped by transport mode (enum and custom).
     * Shows if an activity is powered in parentheses.
     */
    public static void listActivitiesByTransportMode() {
        for (String modeName : getAllModes()) {
            boolean found = false;
            for (Activity a : allActivities) {
                String aMode = (a.mode != null) ? a.mode.name() : null;
                String aCustom = a.customMode;
                if ((aMode != null && aMode.equals(modeName)) || (aCustom != null && aCustom.equals(modeName))) {
                    if (!found) {
                        System.out.println("Transport Mode: " + modeName);
                        found = true;
                    }
                    if (a instanceof PoweredActivity) {
                        System.out.println("  - " + a.activityName + " (Powered)");
                    } else {
                        System.out.println("  - " + a.activityName);
                    }
                }
            }
            if (!found) {
                System.out.println("Transport Mode: " + modeName);
                System.out.println("  No activities.");
            }
        }
    }

    /**
     * Shows detailed information for all activities, grouped by mode.
     * Includes distance, calories, athlete count, and powered/equipment info.
     */
    public static void listActivitiesDetails() {
        for (String modeName : getAllModes()) {
            boolean found = false;
            for (Activity a : allActivities) {
                String aMode = (a.mode != null) ? a.mode.name() : null;
                String aCustom = a.customMode;
                if ((aMode != null && aMode.equals(modeName)) || (aCustom != null && aCustom.equals(modeName))) {
                    if (!found) {
                        System.out.println("Transport Mode: " + modeName);
                        found = true;
                    }
                    System.out.println("  - Activity: " + a.activityName);
                    System.out.println("    Distance: " + a.distance + " km");
                    System.out.println("    Calories per km: " + a.caloriesPerDistance);
                    System.out.println("    Total Calories Lost: " + a.getCaloriesPerDistance());
                    System.out.println("    Athletes: " + a.athletes.size());
                    if (a instanceof PoweredActivity) {
                        PoweredActivity pa = (PoweredActivity) a;
                        System.out.println("    Powered: Yes");
                        System.out.println("    Equipment: " + pa.getEquipment());
                    } else {
                        System.out.println("    Powered: No");
                    }
                }
            }
            if (!found) {
                System.out.println("Transport Mode: " + modeName);
                System.out.println("  No activities.");
            }
        }
    }

    /**
     * Returns a string representation of this activity, including mode, distance, and calories.
     */
    @Override
    public String toString() {
        String modeStr = (mode != null) ? mode.toString() : (customMode != null ? customMode : "");
        return String.format(
            "Activity: %s%nMode: %s%nDistance: %d%nCalories/km: %d",
            activityName, modeStr, distance, caloriesPerDistance
        );
    }

    /**
     * Calculates the total calories burned by a specific athlete across all their activities.
     * @param athlete the athlete to check
     * @return total calories burned
     */
    public static int calculateCaloriesByAthlete(Athlete athlete) {
        int total = 0;
        for (Activity a : allActivities) {
            if (a.athletes.contains(athlete)) {
                total += a.getCaloriesPerDistance();
            }
        }
        return total;
    }

    /**
     * Calculates the total calories burned across all activities.
     * @return total calories burned
     */
    public static int calculateTotalCaloriesAll() {
        int total = 0;
        for (Activity a : allActivities) {
            total += a.getCaloriesPerDistance();
        }
        return total;
    }

    /**
     * Lists all activities performed by a given athlete, showing units, total calories, and distance.
     * Indicates if an activity is powered and the equipment used.
     * @param athlete the athlete to check
     */
    public static void listActivitiesByAthlete(Athlete athlete) {
        System.out.println("Activities for " + athlete.getName() + ":");
        int totalDist = 0;
        for (Activity a : allActivities) {
            if (a.athletes.contains(athlete)) {
                if (a instanceof PoweredActivity) {
                    PoweredActivity pa = (PoweredActivity) a;
                    System.out.printf(" - %s: %d km [Powered, Equipment: %s]%n", a.activityName, a.distance, pa.getEquipment());
                } else {
                    System.out.printf(" - %s: %d km%n", a.activityName, a.distance);
                }
                totalDist += a.distance;
            }
        }
        if (totalDist == 0) {
            System.out.println("   (none)");
        } else {
            System.out.println("Total distance: " + totalDist + " km");
        }
    }
    
    /**
     * Calculates the total distance for a given athlete across all their activities.
     * @param athlete the athlete to check
     * @return total distance
     */
    public static int calculateDistanceByAthlete(Athlete athlete) {
        int total = 0;
        for (Activity a : allActivities) {
            if (a.athletes.contains(athlete)) {
                total += a.distance;
            }
        }
        return total;
    }
    
    /**
     * Calculates the total distance across all activities.
     * @return total distance
     */
    public static int calculateTotalDistanceAll() {
        int total = 0;
        for (Activity a : allActivities) {
            total += a.distance;
        }
        return total;
    }
    
    /**
     * Returns the global list of all activities.
     * @return list of all activities
     */
    public static List<Activity> getAllActivities() {
        return allActivities;
    }

    /**
     * Checks if a mode is a registered custom mode.
     * @param mode the mode name
     * @return true if custom, false otherwise
     */
    public static boolean isCustomMode(String mode) {
        return customModes.contains(mode);
    }

    /**
     * Registers a new custom mode.
     * @param mode the mode name
     */
    public static void registerCustomMode(String mode) {
        customModes.add(mode);
    }

    /**
     * Returns a list of all mode names (enum and custom).
     * @return list of all mode names
     */
    public static List<String> getAllModes() {
        List<String> all = new ArrayList<>();
        for (TransportMode tm : TransportMode.values()) {
            all.add(tm.name());
        }
        all.addAll(customModes);
        return all;
    }
}

