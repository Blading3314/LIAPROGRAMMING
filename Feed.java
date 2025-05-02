import java.util.ArrayList;
/**
 * Write a description of class MainApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Feed
{
    private ArrayList<Activities> activities;

   /**
     * Constructor for objects of class MainApp
     */
    public Feed()
    {
        activities = new ArrayList<>();
    }
    
    public void addActivity(Activities activity)
    {
        activities.add(activity);
    }

    /**
     * Prints all activities in a list
     */
   public void listActivities()
    {
        for(Activities activity : activities) {
            activity.getDetails();
            System.out.println();   // empty line between posts
        }
        /*
            get ArrayList<Activities> activityName 
            for every string activity in activityName
            print activity
        */
        
    }
}
