package swingy.models;

import java.util.Random;

import swingy.views.Show;

public class Artifact {
    public ArtifactTypes artifactType;
    public int buff;

    public Artifact(Hero hero) {
        Random random = new Random();
        if (random.nextBoolean()) {
            this.artifactType = findArtifactType();
            this.buff = findArtifactBuff(hero);
        }
        if (this.buff != 0) {
            Show.artifactDropped();
        }
    }

    int findArtifactBuff(Hero hero) {
        Random random = new Random();
        double buff = random.nextDouble() / 10;
        switch(artifactType) {
            case ARMOUR:
                buff = hero.defence * (0.01 + buff);
                break;
            case HELM:
                buff = hero.maxHitPoints * (0.01 + buff);
                break;
            case WEAPON:
                buff = hero.attack * (0.01 + buff);
                break;
        }
        return (int)buff;
    }
    
    ArtifactTypes findArtifactType() {
        Random random = new Random();
        double type = random.nextDouble() * 3;
        switch((int)type) {
            case 0:
                return ArtifactTypes.ARMOUR;
            case 1:
                return ArtifactTypes.HELM;
            default:
                return ArtifactTypes.WEAPON;
        }
    }

}