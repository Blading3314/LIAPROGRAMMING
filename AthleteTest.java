// AthleteTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AthleteTest {
    //assertEquals basically checks if the two values are true (thanks w3schools!).
    @BeforeEach
    public void setUp() {
        // ensure no leftover athletes from previous tests
        Athlete.getAllAthletes().clear();
    }

    @Test
    public void testConstructorAndListAllAthletes() {
        Athlete ath = new Athlete("Uvuvenvwevuvwen", "Osas", Gender.MALE, 1990);
       
        assertEquals(1,
                     Athlete.getAllAthletes().size(),
                     "Constructor should add the new athlete to the master list");
        assertSame(ath,
                   Athlete.getAllAthletes().get(0),
                   "The athlete in the list should be exactly the one just created");
    }

    @Test
    public void testGetName() {
        Athlete ath = new Athlete("Jaden", "Smith", Gender.FEMALE, 1992);
        assertEquals("Jaden Smith", //the name has to be the same as the ath
                     ath.getName(),
                     "getName should return firstName + lastName");
    }

    @Test
    public void testCalculateBurnedCalories() {
        Athlete ath = new Athlete("Barack", "Osama", Gender.MALE, 1988);
        // new    Activity that burns 4 calories/km over 5 km => 20 calories
        Activity run = new Activity("Trail Run", TransportMode.RUNNING, 4, 5);
        int burned = ath.calculateBurnedCalories(run);
         
        assertEquals(20,
                     burned,
                     "calculateBurnedCalories should return the calories for that single activity");
    }
}
