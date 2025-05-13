import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Random;

/**
 * The Feed class is the main entry point for the sports app.
 * It provides a menu-driven interface for users to create and manage athletes, activities, and equipment.
 * Users can also view statistics and details about their activities.
 *
 * This class is designed to be beginner-friendly, with comments explaining each step.
 */
public class Feed
{  
    public static void main(String[] args) {
        // Register some equipment that users can use for powered activities
        ValidEquipment.register("Bike");
        ValidEquipment.register("E_Bike");
        ValidEquipment.register("Rollerblade");
        ValidEquipment.register("Treadmill");
        ValidEquipment.register("Elliptical");
        ValidEquipment.register("Soccer Ball");

        int choice; // This variable stores the user's menu selection
        
        // Preload some example athletes and activities for demonstration
        new Athlete("John", "Doe", Gender.MALE, 1995);
        new Athlete("Jane", "Doe", Gender.FEMALE, 1998);
        new Athlete("Zayn","Dickerson", Gender.MALE, 1990);
        new Athlete("Opal","Owens",Gender.OTHER, 2001);
        new Athlete("Adrien","Agreste",Gender.MALE, 2006);
        new Athlete("Marinette","Dupain-cheng",Gender.FEMALE,2006);
        
        new Activity("Walking", TransportMode.WALKING, 70, 5 );
        new Activity("Running", TransportMode.RUNNING, 100, 5 );
        new Activity("Biking", TransportMode.BIKING, 15, 5);
        new Activity("Swimming", TransportMode.SWIMMING, 18, 1);
        new Activity("Skating", TransportMode.SKATING, 10, 5);
    
        Scanner mainFeed = new Scanner(System.in);
        System.out.println("Welcome to your new favorite sports app! (๑>؂•̀๑)ᕗ");
        System.out.println();
        
        // Main menu loop: keeps running until the user chooses to exit
        do {
            // Print the main menu options
            System.out.println("\n---| MAIN MENU |---");
            System.out.println("  (1) Create athlete profile");
            System.out.println("  (2) List all athletes");
            System.out.println("  (3) Create equipment");
            System.out.println("  (4) List all equipment");
            System.out.println("  (5) Create new activity");
            System.out.println("  (6) List all activities (names only)");
            System.out.println("  (7) List activities by mode");
            System.out.println("  (8) Show detailed activity info");
            System.out.println("  (9) List activities by athlete");
            System.out.println(" (10) Assign activity to athlete");
            System.out.println(" (11) Show total distance for all activities");
            System.out.println(" (12) Show total calories burned by athlete");
            System.out.println("  (0) Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = mainFeed.nextInt();
            mainFeed.nextLine(); 
        
            // Handle the user's menu selection
            switch (choice){
                case 0: 
                    // Exit the program
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break; 
                case 1:
                    // Create a new athlete profile
                    System.out.println("Enter your first name: ");
                    String name = mainFeed.nextLine();
                    System.out.println("Enter your last name: ");
                    String lastName = mainFeed.nextLine();

                    Gender gender = null; 
                    // Ask for gender until a valid one is entered
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

                    Athlete athlete = new Athlete(name, lastName, gender, yearOfBirth);
                    System.out.println();
                    System.out.print("Enter your current calories burned: ");
                    int initialCalories = mainFeed.nextInt();
                    mainFeed.nextLine();
                    athlete.setCaloriesBurned(initialCalories);

                    System.out.println("Profile created! Here are your details:");
                    System.out.println(athlete);
                    break;
                case 2:
                    // List all athletes in the system
                    System.out.println("\n--- All Athletes ---");
                    Athlete.listAllAthletes();
                    break;
                case 3:
                    // Create a new piece of equipment
                    createEquipment(mainFeed);
                    break;
                case 4:
                    // List all registered equipment
                    listEquipment();
                    break;
                case 5: {
                    // Create a new activity (can be powered or not)
                    System.out.print("What would you like to call this activity? ");
                    String actName = mainFeed.nextLine();
                    System.out.print("How did you get moving? (e.g., WALKING, RUNNING): ");
                    String modeInput = mainFeed.nextLine().toUpperCase();
                    Object mode = null;
                    boolean found = false;
                    // Check if the mode is a built-in enum
                    for (TransportMode tm : TransportMode.values()) {
                        if (tm.name().equals(modeInput)) {
                            mode = tm;
                            found = true;
                            break;
                        }
                    }
                    // If not found, use as custom mode
                    if (!found) {
                        if (!Activity.isCustomMode(modeInput)) {
                            System.out.println("New transport mode. Registering it now");
                            Activity.registerCustomMode(modeInput);
                        }
                        mode = modeInput;
                    }
                    System.out.print("How many calories do you burn per km? ");
                    int cals = mainFeed.nextInt(); mainFeed.nextLine();
                    System.out.print("How far did you go (in km)? ");
                    int dist = mainFeed.nextInt(); mainFeed.nextLine();

                    // Ask if this is a powered activity (uses equipment)
                    String powered = "";
                    boolean firstPrompt = true;
                    String[] errorMessages = {
                        "Whoops! Please answer with 'yes' or 'no'.",
                        "Hmm, I was expecting 'yes' or 'no'. Try again!",
                        "Let's try that again—just type 'yes' or 'no'.",
                        "Oops! Just a simple 'yes' or 'no', please."
                    };
                    Random rand = new Random();
                    while (true) {
                        if (!firstPrompt) {
                            System.out.println();
                        }
                        if (!powered.isEmpty()) {
                            System.out.println(errorMessages[rand.nextInt(errorMessages.length)]);
                        }
                        System.out.print("Does this activity use any equipment? (yes/no): ");
                        powered = mainFeed.nextLine().trim().toLowerCase();
                        if (powered.equals("yes") || powered.equals("no")) {
                            break;
                        }
                        firstPrompt = false;
                    }
                    System.out.println();

                    Activity newAct;
                    if (powered.equals("yes")) {
                        // Show all registered equipment
                        System.out.println("Available equipment:");
                        for (String eqName : ValidEquipment.allNames()) {
                            System.out.println(" - " + eqName);
                        }
                        System.out.print("Enter equipment name: ");
                        String equipmentName = mainFeed.nextLine();
                        System.out.println(); // Add blank line for clarity

                        // Register new equipment if needed
                        if (ValidEquipment.getByName(equipmentName) == null) {
                            System.out.println("New equipment. Registering it now");
                            ValidEquipment.register(equipmentName);
                        }

                        // Create powered activity with combined constructor
                        newAct = new PoweredActivity(actName, mode, cals, dist, equipmentName);
                    } else {
                        // Create regular activity with combined constructor
                        newAct = new Activity(actName, mode, cals, dist);
                    }

                    // Assign the activity to an athlete
                    List<Athlete> athList = Athlete.getAllAthletes();
                    System.out.println("Who did this activity? Pick from the list below:");
                    for (int i = 0; i < athList.size(); i++) {
                        System.out.printf("  %d) %s%n", i+1, athList.get(i).getName());
                    }
                    System.out.print("Enter the number of the athlete: ");
                    int ai = mainFeed.nextInt(); mainFeed.nextLine();
                    System.out.println(); // Add blank line for clarity
                    newAct.setAthlete(athList.get(ai - 1));

                    System.out.println("Created activity: " + newAct);
                } break;
                case 6:
                    // List all activity names
                    System.out.println("\n--- All Activities (Names Only) ---");
                    Activity.listActivities();
                    break;
                case 7:
                    // List activities grouped by mode (shows powered in parentheses)
                    System.out.println("\n--- Activities by Transport Mode ---");
                    Activity.listActivitiesByTransportMode();
                    break;
                case 8:
                    // Show detailed info for all activities
                    System.out.println("\n--- Detailed Activity Information ---");
                    Activity.listActivitiesDetails();
                    break;
                case 9:
                    // List activities for a specific athlete
                    List<Athlete> athletes = Athlete.getAllAthletes();
                    System.out.println("Select an athlete to view their activities:");
                    for (int i = 0; i < athletes.size(); i++) {
                        System.out.printf("  %d) %s%n", i+1, athletes.get(i).getName());
                    }
                    System.out.print("Your choice: ");
                    int sel = mainFeed.nextInt(); mainFeed.nextLine();
                    Athlete a = athletes.get(sel - 1);
                    System.out.println();
                    Activity.listActivitiesByAthlete(a);
                    break;
                case 10: {
                    // Assign an existing activity to an athlete
                    List<Activity> acts = Activity.getAllActivities();
                    System.out.println("Select an activity to assign:");
                    for (int i = 0; i < acts.size(); i++) {
                        Activity a1 = acts.get(i);
                        System.out.printf("  %d) %s (%d km)%n", i+1, a1.activityName, a1.distance);
                    }
                    System.out.print("Your choice: ");
                    int aSel = mainFeed.nextInt();
                    mainFeed.nextLine();
                    Activity chosenAct = acts.get(aSel - 1);

                    List<Athlete> aths = Athlete.getAllAthletes();
                    System.out.println("Select an athlete to assign it to:");
                    for (int i = 0; i < aths.size(); i++) {
                        System.out.printf("  %d) %s%n", i+1, aths.get(i).getName());
                    }
                    System.out.print("Your choice: ");
                    int uSel = mainFeed.nextInt();
                    mainFeed.nextLine();
                    Athlete chosenAth = aths.get(uSel - 1);

                    chosenAct.setAthlete(chosenAth);
                    System.out.printf(
                        "Assigned activity '%s' to %s.%n",
                        chosenAct.activityName,
                        chosenAth.getName()
                    );
                } break;
                case 11:
                    // Show the total distance for all activities
                    int totalDist = Activity.calculateTotalDistanceAll();
                    System.out.println("Total distance across all activities: " + totalDist + " km");
                    break;
                case 12:
                    // Show the total calories burned by a specific athlete
                    List<Athlete> list = Athlete.getAllAthletes();
                    System.out.println("Choose an athlete to see total calories burned:");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.printf("  %d) %s%n", i+1, list.get(i).getName());
                    }
                    System.out.print("Enter number: ");
                    int selection = mainFeed.nextInt();
                    mainFeed.nextLine();

                    Athlete chosenForCalories = list.get(selection-1);
                    int burned = Activity.calculateCaloriesByAthlete(chosenForCalories);
                    System.out.printf("%s burned a total of %d calories across all activities.%n",
                              chosenForCalories.getName(), burned);
                    break;
                default: 
                    // Handle invalid menu choices
                    System.out.println("Not a valid choice! Please select a valid menu option.");
                    break;
            }
        } while (true);
    }

    /**
     * Prompts the user to enter a new equipment name and registers it.
     * This method is called when the user selects the menu option to create equipment.
     */
    private static void createEquipment(Scanner scanner) {
        System.out.print("Enter new equipment name: ");
        String name = scanner.nextLine();
        ValidEquipment eq = ValidEquipment.register(name);
        System.out.println("Registered equipment: " + eq);
    }

    /**
     * Lists all registered equipment.
     * This method is called when the user selects the menu option to list equipment.
     */
    private static void listEquipment() {
        System.out.println("All equipment:");
        for (String nm : ValidEquipment.allNames()) {
            System.out.println(" • " + nm);
        }
    }
}
