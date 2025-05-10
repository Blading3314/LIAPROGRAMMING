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
   private static List<Athletes> allAthletes = new ArrayList<>(); 
   /**
     * Constructor for objects of class Athletes
     */
    public Athletes(String name,String lastName, Gender gender,int yearOfBirth)
    {
       this.name = name;
       this.lastName = lastName;
       this.yearOfBirth = yearOfBirth;
       this.gender = gender;
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
        "Year of birth: " + yearOfBirth + "\n";
    }
   
   public Gender getGender()
    {
       return gender;
    }
   
    
   public void setGender(Gender gender){
        this.gender = gender;
    } 
    
   public int calculateBurnedCalories(Activities activity){
        caloriesBurned = activity.getCaloriesPerDistance();
        return caloriesBurned;
    }  
}
