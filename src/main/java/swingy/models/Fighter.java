package swingy.models;

import javax.validation.constraints.NotNull;

public class Fighter {
    
    @NotNull
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
            case SOLDIER:
                this.attack = 80;
                this.defence = 80;
                this.maxHitPoints = 160;
                break;
            case ROGUE:
                this.attack = 160;
                this.defence = 80;
                this.maxHitPoints = 80;
                break;
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

    Fighter(String fighterClass, Hero hero) {
        this.fighterType = setFighterClass(fighterClass);
        switch(this.fighterType) {
            case BLIGHT:
                this.attack = hero.attack / 2;
                this.defence = hero.defence / 4;
                this.maxHitPoints = hero.maxHitPoints / 4;
                break;
            case OOZE:
                this.attack = hero.attack / 4;
                this.defence = hero.defence / 2;
                this.maxHitPoints = hero.maxHitPoints / 4;
                break;
            case SKELETON:
                this.attack = hero.attack / 4;
                this.defence = hero.defence / 4;
                this.maxHitPoints = hero.maxHitPoints / 2;
                break;
            default:
                this.attack = hero.attack / 2;
                this.defence = hero.defence / 4;
                this.maxHitPoints = hero.maxHitPoints / 4;
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