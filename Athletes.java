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
    public Athletes(String name,String lastName, Gender gender,int yearOfBirth)
    {
       this.name = name;
       this.lastName = lastName;
       this.yearOfBirth = yearOfBirth;
       this.gender = gender;
    }
   
   @Override
   public String toString(){
        return "Name: " + name + " " + lastName + "\n" + 
        "Gender: " + gender + "\n" +
        "Year of birth: " + yearOfBirth;
    }
   
   /**public static void listAllAthletes(){
        for (Athletes allAthletes : allAthletes ){
            System.out.println(allAthletes);
        }
    } */    
    
   public Gender getGender()
    {
       return gender;
    }
   
   public int calculateAge(){
        int year = 2025;
        int age = 2025 - yearOfBirth;
        return age;
    } 
    
   public void setGender(Gender gender){
        this.gender = gender;
    } 
    
   public int calculateBurnedCalories(Activities activity){
        caloriesBurned = activity.getCaloriesPerDistance();
        return caloriesBurned;
    }  
}
