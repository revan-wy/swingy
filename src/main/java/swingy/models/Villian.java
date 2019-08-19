package swingy.models;

import java.util.Random;

public class Villian extends Fighter {
    public static Villian getRandomVillian(Hero hero) {
        Random random = new Random();
        double doubleMax3 = random.nextDouble() * 3;
        if (doubleMax3 >= 0 && doubleMax3 < 1) {
            return new Villian("OOZE", hero);
        } else if (doubleMax3 >= 1 && doubleMax3 < 2) {
            return new Villian("BLIGHT", hero);
        } else {
            return new Villian("SKELETON", hero);
        }
    }

    public int statSum() {
        int sum = this.attack + this.defence + this.maxHitPoints;
        return sum;
    }
    
    Villian(String type, Hero hero) {
        super(type, hero);
    }
    
}