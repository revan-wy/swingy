package swingy.models;

public class Hero extends Fighter {
    public String name;
    public int exp;

    public Hero() {}
    
    public Hero(String name, String heroClass) {
        super(heroClass);
        this.name = name;
        this.exp = 0;
    }
}