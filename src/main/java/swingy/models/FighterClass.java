package swingy.models;

public enum FighterClass {
    ROGUE,
    THIEF,
    SOLDIER,
    SKELETON,
    OOZE,
    BLIGHT;

    public static boolean contains(String test) {

        for (FighterClass c : FighterClass.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
    
        return false;
    }
}