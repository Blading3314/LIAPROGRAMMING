import java.util.*;
/**
 * Class that creates and holds the athletes's informations
 */
public class Athlete
{
    // 1) Fields
    private String name;
    private String lastName;
    private Gender gender;
    private int yearOfBirth;
    private int caloriesBurned;
    private static List <Athlete> allAthletes = new ArrayList<>();

    // 2) Constructor
    public Athlete(String name, String lastName, Gender gender, int yearOfBirth)
    {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        allAthletes.add(this);
    }

    // 3) Public getters/setters
    public String getFirstName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    /** Full name convenience */
    public String getName() {
        return name + " " + lastName;
    }

    public void setCaloriesBurned(int calories) {
        this.caloriesBurned = calories;
    }

    
    @Override //ensure no compiler error
    public String toString(){
        return "Name: " + name + " " + lastName + "\n" +
               "Gender: " + gender + "\n" +
               "Year of birth: " + yearOfBirth + "\n" +
               "Calories burned: " + caloriesBurned;
    }

    // 5) Static helpers
    /** Print all profiles */
    public static void listAllAthletes(){
        for (Athlete athlete : allAthletes) {
            System.out.println(athlete);
            System.out.println();
        }
    }

    /** Return the master list for other classes to use */
    public static List<Athlete> getAllAthletes() {
        return allAthletes;
    }

    
    /**
     * Calculate this athlete’s calories for one activity.
     * 
     */
    public int calculateBurnedCalories(Activity activity){
        int cals = activity.getCaloriesPerDistance();
        this.caloriesBurned += cals;
        return cals;
    }
}
