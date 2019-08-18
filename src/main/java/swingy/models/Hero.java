package swingy.models;

import java.util.Random;

import swingy.controllers.GetInput;
import swingy.views.Show;

public class Hero extends Fighter {
    public String name;
    public int exp;
    public Artifact helm;
    public Artifact armour;
    public Artifact weapon;

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

    public void gainExp(Villian villian) {
        int rawExp = this.exp + ((this.level * 1000 + (this.level - 1) * (this.level - 1) * 450) / 10);
        double actualExp = (double)rawExp * ((double)villian.statSum() / (double)this.statSum()) * 3;
        this.exp = this.exp + (int)actualExp;
        Show.gainedExp(actualExp, this);
        levelUp();
    }

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

    public void levelUp() {
        int requiredExp = this.level * 1000 + (this.level - 1) * (this.level - 1) * 450;
        if (this.exp > requiredExp) {
            this.level += 1;
            this.exp -= requiredExp;
            Show.leveledUp(this);
        }
    }
    
    public boolean run(Villian villian) {
        String action = "";
        while (!(action.equals("FIGHT") || action.equals("RUN"))) {
            Show.fightOrRun();
            action = GetInput.read();
        }
        if (action.equals("FIGHT")) {
            return false;
        } else {
            Random random = new Random();
            boolean result = random.nextBoolean();
            if (result) {
                Show.runSuccess(villian);
            } else {
                Show.runFail();
            }
            return result;
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

    public boolean takeArtifact(Artifact artifact) {
        Show.displayStats(artifact);
        Show.displayStats(this);
        String take = "";
        while (!(take.equals("YES") || take.equals("NO"))) {
            Show.equipAsk();
            take = GetInput.read();
        }
        switch(take) {
            case "YES":
                return true;
            default:
                return false;
        }
    }

}