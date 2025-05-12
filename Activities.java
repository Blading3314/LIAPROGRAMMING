import java.util.*;
/**
 * Write a description of class Activities here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
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
}
