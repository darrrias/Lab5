package CityObject;

public enum StandardOfLiving {
    VERY_HIGH(2),
    HIGH(1),
    VERY_LOW(0);
    int choice;
    StandardOfLiving(int i) {
        choice = i;
    }
    public int getLevel(){
        return choice;
    }
}
