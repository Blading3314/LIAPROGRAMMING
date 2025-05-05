import java.util.*;
/**
 * Write a description of class Athletes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Athletes
{
   // instance variables
   private int ID; 
   private String name;
   private String lastName;
   private Gender gender;
   private int yearOfBirth;
   private int caloriesBurned;
   /**
     * Constructor for objects of class Athletes
     */
    public Athletes(String name, Gender gender, String lastName,int yearOfBirth)
    {
       this.name = name;
       this.lastName = lastName;
       this.yearOfBirth = yearOfBirth;
       this.gender = gender;
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
