package swingy.models;

import swingy.controllers.GetInput;

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

    public boolean takeArtifact() {
        String take = "";
        while (!(take.equals("YES") || take.equals("NO"))) {
            System.out.print("Do you want to equip this artifact? YES/NO ");
            take = GetInput.read();
        }
        switch(take) {
            case "YES":
                return true;
            default:
                return false;
        }
    }

    public void equipArtifact(Artifact artifact) {
        switch(artifact.artifactType) {
            case HELM:
                helm = artifact;
                break;
            case ARMOUR:
                armour = artifact;
                break;
            case WEAPON:
                weapon = artifact;
                break;
        }
    }
}