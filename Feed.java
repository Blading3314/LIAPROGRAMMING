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
    public static void main(String[] args) {
        // Pre-registered equipment (could add more ?)
        ValidEquipment.register("Bike");
        ValidEquipment.register("E_Bike");
        ValidEquipment.register("Rollerblade");
        ValidEquipment.register("Treadmill");
        ValidEquipment.register("Elliptical");
        ValidEquipment.register("Soccer Ball");

        int choice;
        
        // Preload athletes and activities (need to add more!)
        new Athletes("John", "Doe", Gender.MALE, 1995);
        new Athletes("Jane", "Doe", Gender.FEMALE, 1998);
        new Athletes ("Zayn","Dickerson", Gender.MALE, 1990);
        new Athletes("Opal","Owens",Gender.OTHER, 2001);
        new Athletes("Adrien","Agreste",Gender.MALE, 2006);
        new Athletes("Marinette","Dupain-cheng",Gender.FEMALE,2006);
        
        
        new Activities("Walking", TransportMode.WALKING, 70, 5 );
        new Activities("Running", TransportMode.RUNNING, 100, 5 );
        new Activities("Biking", TransportMode.BIKING, 15, 5);
        new Activities("Swimming", TransportMode.SWIMMING, 18, 1);
        new Activities("Skating", TransportMode.SKATING, 10, 5);
    
        Scanner mainFeed = new Scanner(System.in);
        System.out.println("Welcome to your new favorite sports app! (๑>؂•̀๑)ᕗ");
        System.out.println();
       
        
        
        do {
            System.out.println("\n*'*.Menu.*'* ");
            System.out.println("  (0) Exit");
            System.out.println("  (1) Create athlete profile");
            System.out.println("  (2) List all activities");
            System.out.println("  (3) List all athletes");
            System.out.println("  (4) List activities by mode");
            System.out.println("  (5) Print activity details");
            System.out.println("  (6) Create equipment");      
            System.out.println("  (7) List equipment");
            System.out.println("  (8) List activities by athlete");        
            System.out.println("  (9) Calculate burned calories");
            System.out.println(" (10) Create new activity");            
            System.out.println(" (11) Total distance (all activities)");
            System.out.println(" (12) Assign activity to athlete");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = mainFeed.nextInt(); //expect an integer by the user, which explains the int, obviously
            mainFeed.nextLine(); 
        
            switch (choice){
                case 0: 
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break; 
                case 1:
                    System.out.println("Enter your name: ");
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
                            System.out.println("Invalid gender entered. Try again.");
                        }
                    }
                    System.out.println("You entered: " + gender);
                    System.out.println("Enter your year of birth: ");
                    int yearOfBirth = mainFeed.nextInt();
                    mainFeed.nextLine();

                    Athletes athlete = new Athletes(name, lastName, gender, yearOfBirth);
                    System.out.println();
                    System.out.print("Enter your current calories burned: ");
                    int initialCalories = mainFeed.nextInt();
                mainFeed.nextLine();
                athlete.setCaloriesBurned(initialCalories);

                    System.out.println("Take a look at your profile!");
                    System.out.println(athlete);
                    break;
                case 2:
                    System.out.println("List of Activities:");
                    Activities.listActivities();
                    break;
                case 3:
                    System.out.println("Here is a list of all athletes:");
                    Athletes.listAllAthletes();
                    break;
                case 4:
                    System.out.println("Here is a list of activities sorted by mode:");
                    Activities.listActivitiesByTransportMode();
                    break;
                case 5:
                    System.out.println("Here is a list of activities and their details:");
                    Activities.listActivitiesDetails();
                    break;
                case 6:
                    createEquipment(mainFeed);
                    break;
                case 7:
                    listEquipment();
                    break;
                case 8:
                    List<Athletes> athletes = Athletes.getAllAthletes();
            System.out.println("Select an athlete:");
            for (int i = 0; i < athletes.size(); i++) {
                System.out.printf("  %d) %s%n", i+1, athletes.get(i).getName());
            }
            System.out.print("Your choice: ");
            int sel = mainFeed.nextInt(); mainFeed.nextLine();
            Athletes a = athletes.get(sel - 1);
            System.out.println();
            Activities.listActivitiesByAthlete(a);
            break;
            

                case 9:
                    List<Athletes> list = Athletes.getAllAthletes();
                    System.out.println("Choose an athlete to see calories burned:");
                    for (int i = 0; i < list.size(); i++) {
                    System.out.printf("  %d) %s%n", i+1, list.get(i).toString());
                }
                    System.out.print("Enter number: ");
                    int selection = mainFeed.nextInt();
                    mainFeed.nextLine();

                    Athletes chosenForCalories = list.get(selection-1);
                int burned = Activities.calculateCaloriesByAthlete(chosenForCalories);
                System.out.printf("%s burned a total of %d calories.%n",
                      chosenForCalories.toString(), burned);
                    break;
                default: 
                    System.out.println("Not a good choice!");
                    break;
                    case 10: {  
            System.out.print("Activity name: ");
            String actName = mainFeed.nextLine();
            System.out.print("Transport mode (WALKING, RUNNING, etc.): ");
            TransportMode m = TransportMode.valueOf(mainFeed.nextLine().toUpperCase());
            System.out.print("Calories per km: ");
            int cals = mainFeed.nextInt(); mainFeed.nextLine();
            System.out.print("Distance (km): ");
            int dist = mainFeed.nextInt(); mainFeed.nextLine();

            Activities newAct = new Activities(actName, m, cals, dist);

            List<Athletes> athList = Athletes.getAllAthletes();
            System.out.println("Assign which athlete did this?");
            for (int i = 0; i < athList.size(); i++) {
                System.out.printf("  %d) %s%n", i+1, athList.get(i).getName());
            }
            System.out.print("Your choice: ");
            int ai = mainFeed.nextInt(); mainFeed.nextLine();
            newAct.setAthlete(athList.get(ai - 1));

            System.out.println("Created: " + newAct);
        }       break;

            case 11:  // Total distance
            int totalDist = Activities.calculateTotalDistanceAll();
            System.out.println("Total distance across all activities: "
                               + totalDist + " km");
            break;
            case 12: {
            // 1) Let user pick activity
            List<Activities> acts = Activities.getAllActivities();
            System.out.println("Select an activity to assign:");
            for (int i = 0; i < acts.size(); i++) {
                Activities a1 = acts.get(i);
                System.out.printf("  %d) %s (%d km)%n", i+1, a1.activityName, a1.distance);
            }
            System.out.print("Your choice: ");
            int aSel = mainFeed.nextInt();
            mainFeed.nextLine();
            Activities chosenAct = acts.get(aSel - 1);
    
            // 2) Let user pick an athlete
            List<Athletes> aths = Athletes.getAllAthletes();
            System.out.println("Select an athlete to assign it to:");
            for (int i = 0; i < aths.size(); i++) {
            System.out.printf("  %d) %s%n", i+1, aths.get(i).getName());
            }
            System.out.print("Your choice: ");
            int uSel = mainFeed.nextInt();
            mainFeed.nextLine();
            Athletes chosenAth = aths.get(uSel - 1);
    
            // 3) Perform the assignment
            chosenAct.setAthlete(chosenAth);
            System.out.printf(
            "Assigned \"%s\" to %s.%n",
            chosenAct.activityName,
            chosenAth.getName()
            );
        }    
        break;


            }
        } while (choice != 0);
    }

    private static void createEquipment(Scanner scanner) {
        System.out.print("Enter new equipment name: ");
        String name = scanner.nextLine();
        ValidEquipment eq = ValidEquipment.register(name);
        System.out.println("Registered equipment: " + eq);
    }

    private static void listEquipment() {
        System.out.println("All equipment:");
        for (String nm : ValidEquipment.allNames()) {
            System.out.println(" • " + nm);
        }
    }
}
