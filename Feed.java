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
 //private static final List<Athletes> allAthletes = new ArrayList<>();
 public static void main(String[] args) {
    int choice;
    
    new Athletes("John", "Doe", Gender.MALE, 1995);
    new Athletes("Jane", "Doe", Gender.FEMALE, 1998);
    
    new Activities("Walking", TransportMode.WALKING, 70, 5 );
    new Activities("Running", TransportMode.RUNNING, 100, 5 );
    new Activities("Biking", TransportMode.BIKING, 15, 5);
    new Activities("Swimming", TransportMode.SWIMMING, 800, 1);
    new Activities("Skating", TransportMode.SKATING, 300, 5);
 
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
    //choice = mainFeed.nextInt();
    do {
        choice = mainFeed.nextInt();
    
    switch (choice){
                case 0: 
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break; 
                case 1:
                    System.out.println("Enter your name: ");
                    mainFeed = new Scanner(System.in);
                    String name = mainFeed.nextLine();
                    
                    System.out.println("Enter your last name: ");
                    String lastName = mainFeed.nextLine();
                    
                    
        Gender gender = null; 
        while(gender == null) {
            System.out.println("Enter your gender: (MALE, FEMALE or OTHER)");
           String genderPut = mainFeed.nextLine().toUpperCase();
        
        for (Gender g : Gender.values()) {
            if (g.name().equals(genderPut)) {
                gender = g;
                break;
            }
        }
        
        if (gender == null) {
            // invalid gender entered
             System.out.println("Invalid gender entered. Try again");
        
           
        }
    }
              System.out.println(" You entered: " + gender);
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
                System.out.println("Here is a list of activities sorted by mode: ");
                Activities.listActivitiesByTransportMode();
                break;
                
            case 5:
                System.out.println("Here is a list of activities and their details: ");
                Activities.listActivitiesDetails();
                break;
                
            case 6:    
                
            case 7:
    mainFeed.nextLine(); // Clear the newline buffer
    System.out.println("Input the activity you've done (Walking, Running, Biking, Swimming, Skating):");
    String activityName = mainFeed.nextLine().trim();

    System.out.println("How many kilometers did you do?");
    double distanceKm = mainFeed.nextDouble();

    Activities activity = Activities.findActivityByName(activityName);

    if (activity != null) {
        double burnedCalories = activity.calculateBurnedCalories(distanceKm);
        System.out.println("You burned approximately " + burnedCalories + " calories doing " + activityName + ".");
    } else {
        System.out.println("Activity not found.");
    }
    break;

              default: 
                  System.out.println("Not a good choice!");
                  break;
        }
    } while (choice != 7); 
        
    } 
}
