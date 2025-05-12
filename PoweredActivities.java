public class PoweredActivities extends Activities {
    private ValidEquipment equipment;

    public PoweredActivities(String name,
                             TransportMode mode,
                             int caloriesPerDistance,
                             int distance,
                             String equipmentName) {
        super(name, mode, caloriesPerDistance, distance);
        
        ValidEquipment eq = ValidEquipment.getByName(equipmentName);
        if (eq == null) {
            System.out.printf("'%s' was not a known equipment; registering it now.%n", equipmentName);
            eq = ValidEquipment.register(equipmentName);
        }
        this.equipment = eq;
        System.out.println("Created PoweredActivity → " + this);
    }

    public ValidEquipment getEquipment() {
        return equipment;
    }

       @Override
        public String toString() {
    return super.toString() + String.format("%nEquipment: %s", equipment);
    }

}
