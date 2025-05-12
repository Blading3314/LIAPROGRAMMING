import java.util.*;
public class Activities
{
    // instance variables - replace the example below with your own
    protected TransportMode mode;
    protected String activityName;
    protected int caloriesLost;
    protected int caloriesPerDistance;
    protected int distance;
    protected ArrayList<Athletes> athletes;
    protected static ArrayList<Activities> allActivities = new ArrayList<Activities>();;
    /**
     * Constructor for objects of class Activities
     */
    public Activities(String activityName, TransportMode mode, int caloriesPerDistance, int distance)
    {
        this.activityName = activityName;
        this.mode = mode;
        this.caloriesPerDistance = caloriesPerDistance;
        this.distance = distance;
        athletes = new ArrayList<>();
        allActivities.add(this);
        }
    
    public int getCaloriesPerDistance()
    {
        caloriesLost = caloriesPerDistance * distance;
        return caloriesLost;
    }
    
    public void setAthlete(Athletes athlete)
    {
        athletes.add(athlete);
    }
    
    public static void listActivities()
    {
        for(Activities activity : allActivities)
        {
            System.out.println(activity.activityName);
        }
    }
    
    public static void listActivitiesByTransportMode() {
        for (TransportMode mode : TransportMode.values()) {
            System.out.println("Transport Mode: " + mode);
            boolean found = false;
            for (Activities activity : allActivities) {
                if (activity.mode == mode) {
                    System.out.println("  - " + activity.activityName);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("  No activities.");
            }
        }
    }
    
    public static void listActivitiesDetails() {
    for (TransportMode mode : TransportMode.values()) {
        System.out.println("Transport Mode: " + mode);
        boolean found = false;
        for (Activities activity : allActivities) {
            if (activity.mode == mode) {
                System.out.println("  - Activity: " + activity.activityName);
                System.out.println("    Distance: " + activity.distance + " units");
                System.out.println("    Calories per Unit: " + activity.caloriesPerDistance);
                System.out.println("    Total Calories Lost: " + activity.getCaloriesPerDistance());
                System.out.println("    Athletes: " + activity.athletes.size());
                found = true;
            }
        }
        if (!found) {
            System.out.println("  No activities.");
        }
    }
}

public static Activities findActivityByName(String name) {
    for (Activities activity : allActivities) { // assuming allActivities is a static list
        if (activity.activityName.equalsIgnoreCase(name)) {
            return activity;
        }
    }
    return null;
}

public double calculateBurnedCalories(double distanceKm) {
    return this.caloriesPerDistance * distanceKm;
}

}
