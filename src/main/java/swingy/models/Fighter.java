package swingy.models;

public class Fighter {
    public FighterClass fighterClass;
    public int level;
    public int attack;
    public int defence;
    public int hitPoints;

    protected Fighter() {}
    
    Fighter(FighterClass fighterClass) {
        this.fighterClass = fighterClass;
    }
}