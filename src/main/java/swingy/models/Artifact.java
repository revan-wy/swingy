package swingy.models;

import java.util.Random;

public class Artifact {
    public ArtifactTypes artifactType;
    public int buff;

    public Artifact(Hero hero) {
        this.artifactType = findArtifactType();
        this.buff = getArtifactBuff(hero);
    }

    ArtifactTypes findArtifactType() {
        Random random = new Random();
        double type = random.nextDouble() * 3;
        switch((int)type) {
            case 0:
            case 1:
            default:
        }
    }
}