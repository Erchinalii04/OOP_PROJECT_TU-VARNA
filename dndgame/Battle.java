package dndgame;

import java.util.Scanner;

public class Battle {
    public static boolean fight(Hero hero, Monster monster) {
        Scanner scanner = new Scanner(System.in);

        while (!hero.isDead() && !monster.isDead()) {
            System.out.println("Choose attack:");
            System.out.println("1. Strength Attack");
            System.out.println("2. Magic Attack");
            int choice = scanner.nextInt();
            scanner.nextLine(); // чистене на буфера

            int damage;
            if (choice == 1) {
                damage = hero.getStrength();
            } else {
                damage = hero.getMana();
            }

            System.out.println("You hit the monster for " + damage + " damage!");
            monster.takeDamage(damage);

            if (!monster.isDead()) {
                System.out.println("Monster attacks you back!");
                hero.takeDamage(monster.getStrength());
                System.out.println("You received " + monster.getStrength() + " damage.");
            }
        }

        if (hero.isDead()) {
            System.out.println("You lost the battle...");
            return false;
        } else {
            System.out.println("You won the battle!");
            hero.heal();
            return true;
        }
    }
}
