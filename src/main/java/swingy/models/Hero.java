package swingy.models;

public class Hero extends Fighter {
    public String name;
    public int exp;

    public Hero() {}
    
    public Hero(String name, String heroType, int level) {
        super(heroType, level);
        this.name = name;
        this.exp = 0;
    }

    // name
    // fighterclass
    // level
    // exp

    public Hero(String name, String heroType, int level, int exp) {
        super(heroType, level);
        this.name = name;
        this.exp = exp;
    }
}