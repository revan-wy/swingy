package swingy.models;

public class Fighter {
    public FighterTypes fighterType;
    public int level;
    public int attack;
    public int defence;
    public int maxHitPoints;
    public int remainingHitPoints;

    protected Fighter() {}
    
    Fighter(String fighterClass, int level) {
        this.fighterType = setFighterClass(fighterClass);
        this.level = level;
        switch(this.fighterType) {
            // case BLIGHT:
            //     this.attack = 160;
            //     this.defence = 160;
            //     this.maxHitPoints = 160;
            //     break;
            case SOLDIER:
                this.attack = 80;
                this.defence = 80;
                this.maxHitPoints = 160;
                break;
            // case OOZE:
            //     this.attack = 160;
            //     this.defence = 160;
            //     this.maxHitPoints = 160;
            //     break;
            case ROGUE:
                this.attack = 160;
                this.defence = 80;
                this.maxHitPoints = 80;
                break;
            // case SKELETON:
            //     this.attack = 160;
            //     this.defence = 160;
            //     this.maxHitPoints = 160;
            //     break;
            case THIEF:
                this.attack = 80;
                this.defence = 160;
                this.maxHitPoints = 80;
                break;
            default:
            this.attack = 80;
            this.defence = 160;
            this.maxHitPoints = 80;
            break;
        }
        this.remainingHitPoints = this.maxHitPoints;
    }

    private FighterTypes setFighterClass(String fighterClass) {
        for (FighterTypes c : FighterTypes.values()) {
            if (c.name().equals(fighterClass)) {
                return c;
            }
        }
        return FighterTypes.ROGUE;
    }

    // private int setAttack() {
    //     switch(this.fighterClass) {

    //     }
    // }
}