
import java.util.ArrayList;
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
    protected String activity;
    protected int caloriesLost;
    protected int caloriesPerDistance;
    protected int distance;
    protected ArrayList<Athletes> athletes;
    /**
     * Constructor for objects of class Activities
     */
    public Activities(String activityName, TransportMode mode, int caloriesPerDistance, int distance)
    {
        activity = activityName;
        this.mode = mode;
        this.caloriesPerDistance = caloriesPerDistance;
        this.distance = distance;
        athletes = new ArrayList<>();
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
    
    /** 
     * Displays all items in the given list.
     * If the list is empty, a message indicating that there are no items
     * is shown. Otherwise, it goes through each item in the list and prints
     * its details to the user. This method can be used for displaying all
     * athletes, activities, or equipment depending on the list passed in.
     * 
     */
    public void getDetails()
    {
        System.out.println(activity);
    }
}
