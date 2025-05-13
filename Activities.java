import java.util.*;
public class Activities {
    protected TransportMode mode;
    protected String activityName;
    protected int caloriesLost;
    protected int caloriesPerDistance;
    protected int distance;
    protected List<Athletes> athletes;
    protected static List<Activities> allActivities = new ArrayList<>();

    /**
     * Constructor for objects of class Activities
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
    
        public static int calculateDistanceByAthlete(Athletes athlete) {
        int total = 0;
        for (Activities a : allActivities) {
        if (a.athletes.contains(athlete)) {
            total += a.distance;
        }
        }
        return total;
    }
            public static int calculateTotalDistanceAll() {
        int total = 0;
        for (Activities a : allActivities) {
        total += a.distance;
        }
            return total;
    }
        public static List<Activities> getAllActivities() {
        return allActivities;
    }
}
