import java.util.*;
/**
 * Represents a single activity.
 * 
 * Each activity has a name, a mode of transport, a distance covered,
 * and a calorie burn rate per unit distance. Activities can be associated
 * with multiple athletes.
 */
public class Activities {
    protected TransportMode mode;
    protected String activityName;
    protected int caloriesLost;
    protected int caloriesPerDistance;
    protected int distance;
    protected List<Athletes> athletes;
    protected static List<Activities> allActivities = new ArrayList<>();

    /**
     * Constructor for objects of class Activities.
     * 
     * @param activityName         the name of the activity ("Running")
     * @param mode                 the mode of transport or activity (WALKING, RUNNING)
     * @param caloriesPerDistance  the number of calories burned per unit distance
     * @param distance             the total distance of the activity in kilometers
     */
    public Activities(String activityName, TransportMode mode, int caloriesPerDistance, int distance) {
        this.activityName = activityName;
        this.mode = mode;
        this.caloriesPerDistance = caloriesPerDistance;
        this.distance = distance;
        this.athletes = new ArrayList<>();
        allActivities.add(this);
    }

    /**
     * Calculates total calories for this activity (calories per unit * distance)
     */
    public int getCaloriesPerDistance() {
        caloriesLost = caloriesPerDistance * distance;
        return caloriesLost;
    }

    /**
     * Associates an athlete with this activity
     */
    public void setAthlete(Athletes athlete) {
        athletes.add(athlete);
    }

    /**
     * List all activity names
     */
    public static void listActivities() {
        for (Activities activity : allActivities) {
            System.out.println(activity.activityName);
        }
    }

    /**
     * List activities grouped by transport mode
     */
    public static void listActivitiesByTransportMode() {
        for (TransportMode m : TransportMode.values()) {
            System.out.println("Transport Mode: " + m);
            boolean found = false;
            for (Activities a : allActivities) {
                if (a.mode == m) {
                    System.out.println("  - " + a.activityName);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("  No activities.");
            }
        }
    }

    /**
     * Detailed listing of each activity by mode, including calories and athlete count
     */
    public static void listActivitiesDetails() {
        for (TransportMode m : TransportMode.values()) {
            System.out.println("Transport Mode: " + m);
            boolean found = false;
            for (Activities a : allActivities) {
                if (a.mode == m) {
                    System.out.println("  - Activity: " + a.activityName);
                    System.out.println("    Distance: " + a.distance + " km");
                    System.out.println("    Calories per km: " + a.caloriesPerDistance);
                    System.out.println("    Total Calories Lost: " + a.getCaloriesPerDistance());
                    System.out.println("    Athletes: " + a.athletes.size());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("  No activities.");
            }
        }
    }
    
    /**
     * Returns a string representation of the activity, including its name,
     * transport mode, distance, and calories burned per kilometer.
     *
     * @return a formatted string describing the activity
     */
    @Override
    public String toString() {
        return String.format(
            "Activity: %s%nMode: %s%nDistance: %d%nCalories/km: %d",
            activityName, mode, distance, caloriesPerDistance
        );
    }

    /**
     * Sum of the calories for a specific athlete over all their activities
     */
    public static int calculateCaloriesByAthlete(Athletes athlete) {
        int total = 0;
        for (Activities a : allActivities) {
            if (a.athletes.contains(athlete)) {
                total += a.getCaloriesPerDistance();
            }
        }
        return total;
    }

    /**
     * Sum calories for all activities regardless of athlete
     */
    public static int calculateTotalCaloriesAll() {
        int total = 0;
        for (Activities a : allActivities) {
            total += a.getCaloriesPerDistance();
        }
        return total;
    }

    /**
     * List activities performed by a given athlete, showing units, total calories and their distance
     */
        public static void listActivitiesByAthlete(Athletes athlete) {
        System.out.println("Activities for " + athlete.getName() + ":");
        int totalDist = 0;
        for (Activities a : allActivities) {
        if (a.athletes.contains(athlete)) {
            System.out.printf(" - %s: %d km%n", a.activityName, a.distance);
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
     * Calculates the total distance covered by a specific athlete across all activities.
     *
     * @param athlete the athlete whose total distance is to be calculated
     * @return the total distance (in kilometers) the athlete has participated in
     */
        public static int calculateDistanceByAthlete(Athletes athlete) {
        int total = 0;
        for (Activities a : allActivities) {
        if (a.athletes.contains(athlete)) {
            total += a.distance;
        }
        }
        return total;
    }
    
    /**
     * Calculates the total distance covered across all recorded activities,
     * regardless of which athletes participated.
     *
     * @return the total distance (in kilometers) of all activities
     */
            public static int calculateTotalDistanceAll() {
        int total = 0;
        for (Activities a : allActivities) {
        total += a.distance;
        }
            return total;
    }
    
    /**
     * Returns the list of all recorded activity instances.
     * 
     * This list includes every Activities object created and added
     * to the system via the constructor.
     *
     * @return a list containing all activity objects
     */
        public static List<Activities> getAllActivities() {
        return allActivities;
    }
}
