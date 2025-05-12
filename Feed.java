import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
/**
 * Write a description of class MainApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Feed
{ 
 private List<Athletes> allAthletes = new ArrayList<>();  
 //private static final List<Athletes> allAthletes = new ArrayList<>();
 public static void main(String[] args) {
    int choice;
    
    new Athletes("John", "Doe", Gender.MALE, 1995);
    new Athletes("Jane", "Doe", Gender.FEMALE, 1998);
    
    new Activities("Walking", TransportMode.WALKING, 5, 20);
    new Activities("Biking", TransportMode.BIKING, 10, 20);
    new Activities("Swimming", TransportMode.BIKING, 10, 20);
 
    Scanner mainFeed = new Scanner(System.in);
    System.out.println("Welcome to your new favorite sports app! (๑>؂•̀๑)ᕗ");
    System.out.println();

    System.out.println("*'*.Menu.*'*");
    System.out.println("  (0) Exit");
    System.out.println("  (1) Create athlete profile");
    System.out.println("  (2) List all activities");
    System.out.println("  (3) List all athletes");
    System.out.println("  (4) List activities by mode");
    System.out.println("  (5) Print activity details");
    System.out.println("  (6) Print your details");
    System.out.println("  (7) Calculate burned calories");
    System.out.println();
    choice = mainFeed.nextInt();
    
    switch (choice){
        case 1:
            System.out.println("Enter your name: ");
            mainFeed = new Scanner(System.in);
            String name = mainFeed.nextLine();
            
            System.out.println("Enter your last name: ");
            String lastName = mainFeed.nextLine();
            
            System.out.println("Enter your gender: (MALE, FEMALE or OTHER)");
            String genderPut = mainFeed.nextLine().toUpperCase();
            Gender gender = Gender.valueOf(genderPut);
            
            System.out.println("Enter your year of birth: ");
            int yearOfBirth = mainFeed.nextInt();
            
            Athletes athlete = new Athletes(name,lastName,gender,yearOfBirth);
            System.out.println();
            System.out.println("Take a look at your profile !");
            System.out.println(athlete);
            break;
            
        case 2:
            System.out.println("List of Activities: ");
            Activities.listActivities();
            break;
            
        case 3:
          System.out.println("Here is a list of all athletes: ");
          Athletes.listAllAthletes();
          break;
        
        case 4:  
            
        case 5:
            
        case 6:    
            
        case 7:
            System.out.print("Input the activity you've done:");
          //  Athletes.calculateBurnedCalories();
    }
    
    } 
}
