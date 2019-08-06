package swingy.models;

public enum FighterTypes {
    ROGUE,
    THIEF,
    SOLDIER,
    SKELETON,
    OOZE,
    BLIGHT;

    public static boolean contains(String test) {

        for (FighterTypes c : FighterTypes.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
    
        return false;
    }
}