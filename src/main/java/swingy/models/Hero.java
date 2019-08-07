package swingy.models;

public class Hero extends Fighter {
    public String name;
    public int exp;
    public ArtifactTypes helm;
    public ArtifactTypes armour;
    public ArtifactTypes weapon;

    public Hero() {}
    
    public Hero(String name, String heroType, int level) {
        super(heroType, level);
        this.name = name;
        this.exp = 0;
    }

    public Hero(String name, String heroType, int level, int exp) {
        super(heroType, level);
        this.name = name;
        this.exp = exp;
    }
}