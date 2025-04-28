

import java.util.Random;
import java.util.Scanner;

public class Battle {
    public static boolean start(Hero hero, Monster monster) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        boolean heroTurn = rand.nextBoolean();

        while (!hero.isDead() && !monster.isDead()) {
            if (heroTurn) {
                System.out.println("\nYour turn! Choose attack type:");
                System.out.println("1. Physical Attack");
                System.out.println("2. Magic Attack");
                int choice = scanner.nextInt();
                int baseDamage = (choice == 1) ? hero.getStrength() : hero.getMana();
                int bonus = (choice == 1) ?
                        hero.getInventory().getWeapon().getBonus() :
                        hero.getInventory().getSpell().getBonus();

                int totalDamage = (int)((baseDamage * (1 + bonus / 100.0)) * (1 - monster.getArmorReduction()));
                System.out.println("You deal " + totalDamage + " damage!");
                monster.reduceHealth(totalDamage);
            } else {
                boolean magic = rand.nextBoolean();
                int base = magic ? monster.getMana() : monster.getStrength();
                int damage = base;

                double armorBlock = hero.getInventory().getArmor() != null ?
                        hero.getInventory().getArmor().getBonus() / 100.0 : 0;
                damage = (int)(damage * (1 - armorBlock));
                hero.takeDamage(damage);

                System.out.println("Monster attacks and deals " + damage + " damage!");
            }

            heroTurn = !heroTurn;
        }

        if (hero.isDead()) {
            System.out.println("You were defeated...");
            return false;
        } else {
            int restore = hero.getMaxHealth() / 2;
            if (hero.getHealth() < restore) hero.setHealth(restore);
            System.out.println("Monster defeated! Health restored to " + hero.getHealth());
            return true;
        }
    }
}
