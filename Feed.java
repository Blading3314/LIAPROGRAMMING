import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class MainApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Feed
{  
 public static void main(String[] args) {
    int choice;
    
    Athletes currentAthlete = null;
    
    new Athletes("John", "Doe", Gender.MALE, 1995, 78.5);
    new Athletes("Jane", "Doe", Gender.FEMALE, 1998, 50.0);
    
    new Activities("Walking", TransportMode.WALKING, 0.0009, 1000);   
    new Activities("Running", TransportMode.RUNNING, 0.0012, 1000);   
    new Activities("Biking", TransportMode.BIKING, 0.0005, 1000);     
    new Activities("Swimming", TransportMode.SWIMMING, 0.0014, 1000); 
    new Activities("Skating", TransportMode.SKATING, 0.0011, 1000);

 
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
                System.out.println("Enter your year of birth: ");
                int yearOfBirth = mainFeed.nextInt();
                
                System.out.println("Enter your weight (kg): ");
                double weight = mainFeed.nextDouble();
                
                currentAthlete = new Athletes(name,lastName,gender,yearOfBirth,weight);
                System.out.println();
                System.out.println("Take a look at your profile !");
                System.out.println(currentAthlete);
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
                if (currentAthlete == null) {
                    System.out.println("Create your profile first!!");
                    break;
                }
                mainFeed.nextLine(); // clear buffer
                System.out.println("Choose the activity you've done (Walking, Running, Biking, Swimming, Skating):");
                String activityName = mainFeed.nextLine().trim();
            
                System.out.println("How many meters did you do?");
                double distanceKm = mainFeed.nextDouble();
            
                Activities activity = Activities.findActivityByName(activityName);
            
                if (activity != null) {
                    activity.distance = (int) distanceKm;
                    int burnedCalories = currentAthlete.calculateBurnedCalories(activity, distanceKm);
                    System.out.println("You burned approximately " + burnedCalories + " calories doing " + activityName + ".");
                } else {
                    System.out.println("Activity not found.");
                }
                break;

            
            default: 
                System.out.println("Not a good choice!");
                break;
                    }
        } while (choice != 8); 
    } 
}
