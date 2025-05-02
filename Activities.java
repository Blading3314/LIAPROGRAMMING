
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

    /**
     * Constructor for objects of class Activities
     */
    public Activities(String activityName, TransportMode mode)
    {
        activity = activityName;
        this.mode = mode;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   /* public String activityName()
    {
        // put your code here
        return;

    }
    */
    /** 
     * Displays all items in the given list.
     * If the list is empty, a message indicating that there are no items
     * is shown. Otherwise, it goes through each item in the list and prints
     * its details to the user. This method can be used for displaying all
     * athletes, activities, or equipment depending on the list passed in.
     * 
     */
    public void listAll(){
        
    }
   /* public int setTotalDistance() {
        
        return
    }
    */
    
   /**
    * Sets the transportation mode for the activity.
    * Accepts only predefined constant modes.
    * Prints an error message if an invalid mode is given.
    */
    public void setMode(){
        this.mode = mode;
       
        
    }
}
