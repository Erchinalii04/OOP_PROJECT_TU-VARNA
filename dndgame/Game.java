package dndgame;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Hero hero;
    private Map map;
    private int level;
    private int posX, posY;
    private Scanner scanner;

    public void start() {
        scanner = new Scanner(System.in);
        System.out.println("Welcome to Dungeons & Dragons!");

        System.out.print("Enter your hero's name: ");
        String name = scanner.nextLine();

        System.out.println("Choose race: 1.HUMAN 2.MAGE 3.WARRIOR");
        int raceChoice = scanner.nextInt();
        scanner.nextLine();
        Race race = switch (raceChoice) {
            case 2 -> Race.MAGE;
            case 3 -> Race.WARRIOR;
            default -> Race.HUMAN;
        };

        hero = new Hero(name, race);
        level = 1;

        while (true) {
            playLevel();
            if (hero.isDead()) break;
            level++;
            distributeStats();
        }

        System.out.println("Game Over. Thank you for playing!");
    }

    private void playLevel() {
        int w = 10 + 5 * (level - 1);
        int h = 10 + 5 * (level - 1);
        map = new Map(w, h);
        map.placeObjects(2 + level, 2 + level);
        posX = 0;
        posY = 0;

        boolean playing = true;
        while (playing) {
            map.printMap();
            System.out.println("Move (WASD): ");
            char move = scanner.nextLine().toUpperCase().charAt(0);

            int newX = posX, newY = posY;
            switch (move) {
                case 'W' -> newX--;
                case 'S' -> newX++;
                case 'A' -> newY--;
                case 'D' -> newY++;
            }

            if (newX < 0 || newY < 0 || newX >= map.getHeight() || newY >= map.getWidth()) {
                System.out.println("Cannot move out of bounds!");
                continue;
            }

            char tile = map.getGrid()[newX][newY];

            if (tile == 'M') {
                System.out.println("A monster appears!");
                if (Battle.fight(hero, new Monster(level))) {
                    map.getGrid()[newX][newY] = '.';
                    moveHero(newX, newY);
                } else {
                    playing = false;
                }
            } else if (tile == 'T') {
                System.out.println("You found a treasure!");
                collectTreasure();
                map.getGrid()[newX][newY] = '.';
                moveHero(newX, newY);
            } else if (tile == 'E') {
                System.out.println("Level completed!");
                playing = false;
            } else {
                moveHero(newX, newY);
            }
        }
    }

    private void moveHero(int newX, int newY) {
        map.getGrid()[posX][posY] = '.';
        posX = newX;
        posY = newY;
        map.getGrid()[posX][posY] = 'P';
    }

    private void collectTreasure() {
        Random rand = new Random();
        int type = rand.nextInt(3);
        int bonus = 10 + rand.nextInt(20);

        Item item = switch (type) {
            case 0 -> new Weapon("Sword of Power", bonus);
            case 1 -> new Armor("Shield of Defense", bonus);
            default -> new Spell("Spell of Magic", bonus);
        };

        System.out.println("Found: " + item.getName() + " +" + item.getBonus() + "% bonus.");
        System.out.println("Equip? (yes/no)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            if (item instanceof Weapon w) hero.getInventory().equipWeapon(w);
            if (item instanceof Armor a) hero.getInventory().equipArmor(a);
            if (item instanceof Spell s) hero.getInventory().equipSpell(s);
        }
    }

    private void distributeStats() {
        System.out.println("Distribute 30 points (example 10 10 10): ");
        System.out.print("Strength: ");
        int str = scanner.nextInt();
        System.out.print("Mana: ");
        int mana = scanner.nextInt();
        System.out.print("Health: ");
        int hp = scanner.nextInt();
        scanner.nextLine();
        hero.levelUp(str, mana, hp);
    }
}
