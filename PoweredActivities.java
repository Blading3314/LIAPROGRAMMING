import java.util.HashMap;

/**
 * Write a description of class PoweredActivities here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PoweredActivities extends Activities
{
    // Mapping between the equipment name and the ValidEquipment
    // associated with it. 
    private HashMap <String, ValidEquipment> equipmentName;
    
    public PoweredActivities(String activityName, TransportMode mode, int caloriesPerDistance, int distance)
    {
        super(activityName, mode, caloriesPerDistance, distance);
        equipmentName = new HashMap<>();
        
        for(ValidEquipment command : ValidEquipment.values()) {
            if(command != ValidEquipment.UNKNOWN) {
                equipmentName.put(command.toString(), command);
            }
        }
    }

    /** 
     * Find the ValidEquipment associated with its respective name/command typed 
     * as String. Returns UNKNOWN if the equipment name is not valid.
     */
    public ValidEquipment getNameOfEquipment(String nameWord)
    {
        ValidEquipment name = equipmentName.get(nameWord);
        if(name != null) {
            return name;
        }
        else {
            return ValidEquipment.UNKNOWN;
        }
    }
    
    /**
     * Check whether a given String is a valid name of equipment. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return equipmentName.containsKey(aString);
    }
    public void showALL() {
         System.out.println("Valid equipment names are:\n");
         for (String command : equipmentName.keySet()) {
             System.out.println("* "+command + "  \n");
         }
         System.out.println(); 
     }
    }

