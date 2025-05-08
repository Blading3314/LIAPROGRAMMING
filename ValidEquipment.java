public enum ValidEquipment 
{ 
    // Valid equipment names 
    ROLLERBLADES("Rollerblades"), SOCCERBALL("Soccer Ball"), HELMETS ("Helmets"), 
    RACKETS ("Rackets"), STICKS ("Sticks"), BASKETBALL ("Basketball") , THEDUKE ("Duke Ball"),
    UNKNOWN("?"); 
    
    private String nameString; 
    
    ValidEquipment (String nameString){
        this.nameString = nameString; 
    }
    public String toString() {
        return nameString; 
    }
}