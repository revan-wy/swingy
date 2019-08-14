package swingy.models;

import swingy.controllers.GetInput;
import swingy.views.Show;

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

    public boolean takeArtifact(Artifact artifact) {
        Show.displayStats(artifact);
        Show.displayStats(this);
        String take = "";
        while (!(take.equals("YES") || take.equals("NO"))) {
            System.out.print("\nDo you want to equip this artifact? YES/NO "); // move this code to VIEW
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

    public int statSum() {
        int helmBuff = 0;
        int armourBuff = 0;
        int weaponBuff = 0;
        
        if (this.helm != null) {
            helmBuff = this.helm.buff;
        }
         if (this.armour != null) {
            armourBuff = this.armour.buff;
        }
        if (this.weapon != null) {
            weaponBuff = this.weapon.buff;
        }
        
        int sum = this.attack + this.defence + this.maxHitPoints + helmBuff + armourBuff + weaponBuff;
        return sum;
    }

}