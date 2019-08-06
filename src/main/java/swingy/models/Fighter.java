package swingy.models;

public class Fighter {
    public FighterClass fighterClass;
    public int level;
    public int attack;
    public int defence;
    public int hitPoints;

    protected Fighter() {}
    
    Fighter(String fighterClass) {
        this.fighterClass = setFighterClass(fighterClass);
        this.level = 0;
        switch(this.fighterClass) {
            case BLIGHT:
                this.attack = 160;
                this.defence = 160;
                this.hitPoints = 160;
                break;
            case SOLDIER:
                this.attack = 80;
                this.defence = 80;
                this.hitPoints = 160;
                break;
            case OOZE:
                this.attack = 160;
                this.defence = 160;
                this.hitPoints = 160;
                break;
            case ROGUE:
                this.attack = 160;
                this.defence = 80;
                this.hitPoints = 80;
                break;
            case SKELETON:
                this.attack = 160;
                this.defence = 160;
                this.hitPoints = 160;
                break;
            case THIEF:
                this.attack = 80;
                this.defence = 160;
                this.hitPoints = 80;
                break;
        }
    }

    private FighterClass setFighterClass(String fighterClass) {
        for (FighterClass c : FighterClass.values()) {
            if (c.name().equals(fighterClass)) {
                return c;
            }
        }
        return FighterClass.ROGUE;
    }

    // private int setAttack() {
    //     switch(this.fighterClass) {

    //     }
    // }
}