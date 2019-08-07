package swingy.models;

public class Hero extends Fighter {
    public String name;
    public int exp;
    public Artifact helm;
    public Artifact armour;
    public Artifact weapon;

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