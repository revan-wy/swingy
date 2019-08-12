package swingy.models;

import java.util.Random;

public class Artifact {
    public ArtifactTypes artifactType;
    public int buff;

    public Artifact(Hero hero) {
        this.artifactType = findArtifactType();
        this.buff = findArtifactBuff(hero);
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

    int findArtifactBuff(Hero hero) {
        Random random = new Random();
        double buff = random.nextDouble() / 10;
        switch(artifactType) {
            case ARMOUR:
                buff = hero.defence * (1 + buff);
                break;
            case HELM:
                buff = hero.maxHitPoints * (1 + buff);
                break;
            case WEAPON:
                buff = hero.attack * (1 + buff);
                break;
        }
        return (int)buff;
    }
}