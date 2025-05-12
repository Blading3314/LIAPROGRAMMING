import java.util.*;
/**
 * Write a description of class Athletes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Athletes
{
   private String name;
   private String lastName;
   private Gender gender;
   private int yearOfBirth;
   private int caloriesBurned;
   private double weight;
   private static List<Athletes> allAthletes = new ArrayList<>(); 
   /**
     * Constructor for objects of class Athletes
     */
    public Athletes(String name,String lastName, Gender gender,int yearOfBirth, double weight)
    {
       this.name = name;
       this.lastName = lastName;
       this.yearOfBirth = yearOfBirth;
       this.gender = gender;
       this.weight = weight;
       allAthletes.add(this);
    }
   
   public static void listAllAthletes(){
        for(Athletes athletes : allAthletes){
            System.out.println(athletes.name + " " + athletes.lastName);
        }
    } 
    
   @Override
   public String toString(){
        return "Name: " + name + " " + lastName + "\n" + 
        "Gender: " + gender + "\n" +
        "Year of birth: " + yearOfBirth + "\n" + "Weight: " + weight + "kg";
    }
   
   public Gender getGender()
    {
       return gender;
    }
  
   public void setGender(Gender gender){
        this.gender = gender;
    } 
    
   public int calculateBurnedCalories(Activities activity, double distanceM) {
        // Calculate total calories burned: weight * distance (in meters) * calories per meter
        double totalCalories = weight * distanceM * activity.getCaloriesPerM();
        caloriesBurned = (int) totalCalories;  // Cast to int to get the calories as a whole number
        return caloriesBurned;
    }

}

