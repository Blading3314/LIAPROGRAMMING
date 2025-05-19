// ActivityTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActivityTest {
    //assertEquals basically checks if the two values are true (thanks w3schools!).
    @BeforeEach
    public void setUp() {
        // clear out any previously created activities so each test is isolated
        Activity.getAllActivities().clear();
    }

    @Test
    public void testGetCaloriesPerDistance() {
        // caloriesPerDistance = 5, distance = 10 => expected calories = 50
        Activity a = new Activity("Late Night Run", TransportMode.RUNNING, 5, 10);
        assertEquals(50, a.getCaloriesPerDistance(),
                     "getCaloriesPerDistance should be caloriesPerDistance x distance");
    }

    @Test
    public void testCalculateTotalDistanceAll() {
        // distances: 10 km + 20 km => total = 30 km
        new Activity("Run",   TransportMode.RUNNING, 1, 10);
        new Activity("Cycle", TransportMode.CYCLING, 1, 20);
        assertEquals(30,
                     Activity.calculateTotalDistanceAll(),
                     "calculateTotalDistanceAll should be the sum of all activity distances");
    }

    @Test
    public void testCalculateTotalCaloriesAll() {
        // calories: (2 x 5) + (3 x 7) = 10 + 21 = 31
        new Activity("Jog",    TransportMode.RUNNING, 2, 5);
        new Activity("Pedal",  TransportMode.CYCLING, 3, 7);
        assertEquals( (2*5) + (3*7),
                     Activity.calculateTotalCaloriesAll(),
                     "calculateTotalCaloriesAll should be the sum of all calories from each activity");
    }
}
