import monsters.*;
import java.util.Random;

import java.util.Scanner;

public class BattleScene {

    String[] items = { "Sword", "Axe", "Bow", "Spear"};

    int maxEnemyHealth = 100;
    int maxBossHealth = 200;
    int enemyAttackDamage = 15;
    int bossDamage = 50;

    //Player Variables
    int health = 100;
    int attackDamage = 15;
    int numHealthPotions = 3;
    int healthPotionHealAmount = 60;
    int healthPotionDropChance = 50; //Percentage
    int score = 0;

    int swordDamage = 35;
    int axeDamage = 35;
    int bowDamage = 35;
    int spearDamage = 35;

    public BattleScene(){
        boolean running = true;

    GAME:
    while(running) {
        Monster[] enemies = {new Skeleton(), new Zombie(), new Assassin(), new Warrior()};
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("------------------------------------");

        Monster enemy = enemies[rand.nextInt(enemies.length)];
        int enemyHealth = rand.nextInt(enemy.getHitPoints());

        while (enemy.getHitPoints() > 0) {

            System.out.println("\t> Your HP: " + health);
            System.out.println("\t> " + enemy.getName() + "'s HP: " + enemy.getHitPoints());

            System.out.println("\t> You have " + numHealthPotions + " Health Potions.");

            System.out.println("\n\tWhat would you like to do?");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Drink a Health Potion");
            System.out.println("\t3. Run!");

            String input = in.nextLine();

            if (input.equals("1")) {
                int damageDealt = attackDamage;
                int damageTaken = enemyAttackDamage;

                enemy.setHitPoints(enemy.getHitPoints() - damageDealt);
                health -= damageTaken;

                System.out.println("\t> You Strike the " + enemy.getName() + " for " + damageDealt + " damage.");
                System.out.println("\t> You receive " + enemy.getAttackDamage() + " in retaliation!");

                if (health < 1) {
                    System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                    break;
                }

            } else if (input.equals("2")) {
                if (numHealthPotions > 0) {
                    health += healthPotionHealAmount;
                    numHealthPotions--;
                    System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + "."
                            + "\n\t> You now have " + health + " HP.");
                } else {
                    System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!\n");
                }

            } else if (input.equals("3")) {
                System.out.println("\tYou run away from the " + enemy.getName() + "!");
                continue GAME;

            } else {
                System.out.println("Invalid Command!");
            }
        }
    }
}
}
