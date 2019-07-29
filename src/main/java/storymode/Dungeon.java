package storymode;

import storymode.monsters.*;

import java.util.Random;
import java.util.Scanner;

public class Dungeon {
    public static final String WEAPON_BOW = "Bow";
    public static final String WEAPON_AXE = "Axe";
    public static final String WEAPON_SWORD = "Sword";
    public static final String WEAPON_SPEAR = "Spear";

    boolean inDungeon = true;

    Scanner in = new Scanner(System.in);

    public void enter(PlayerInventory playerInventory, PlayerStats playerStats) {
        //Objects
        Random rand = new Random();

        //Game Variables
        Monster[] enemies = {new Skeleton(), new Zombie(), new Assassin(), new Warrior()};
        String[] leader = {"The Middengard Wyrm"};
        // Skeleton weak against Bow
        // Zombie weak against Axe
        // Warrior weak against Spear
        // Assassin weak against Sword
        String[] items = {"Sword", "Axe", "Bow", "Spear"};
        int maxEnemyHealth = 100;
        int maxBossHealth = 200;
        int enemyAttackDamage = 15;
        int bossDamage = 50;

        //Player Variables
        int health = 100;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 60;
        int healthPotionDropChance = 50; //Percentage

        int swordDamage = 35;
        int axeDamage = 35;
        int bowDamage = 35;
        int spearDamage = 35;

        boolean running = true;


        GAME:
        while (running) {
            System.out.println("------------------------------------");

            Monster enemy = enemies[rand.nextInt(enemies.length)];
            int enemyHealth = rand.nextInt(enemy.getHitPoints());
            //  String boss = leader[leader.length];

            System.out.println("\t# " + enemy.getName() + " has appeared! #\n");

            while (enemyHealth > 0) {

                System.out.println("\t> Your HP: " + health);
                System.out.println("\t> " + enemy.getName() + "'s HP: " + enemyHealth);

                System.out.println("\t> You have " + numHealthPotions + " Health Potions.");

                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink a Health Potion");
                System.out.println("\t3. Run!");

                String input = in.nextLine();

                if (input.equals("1")) {
                    int damageDealt = playerStats.damage();
                    int damageTaken = enemyAttackDamage;

                    enemyHealth -= damageDealt;
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

                    running = doesPlayerWantToStay();

                    continue GAME;

                } else if (input.equals("Inventory")) {
                    System.out.println("\tYou Have No Weapons!");

                } else {
                    System.out.println("Invalid Command!");

                }
            }

            int gold = 5;
            System.out.println("You Have Found " + gold + " coins!\n");
            playerInventory.setGold(playerInventory.getGold() + 5);

            if (health < 1) {
                System.out.println("You limp out of the dungeon, weak from battle.");
                break;
            }

            System.out.println("------------------------------------");
            System.out.println(" # " + enemy.getName() + " was defeated! #");
            System.out.println(" # You have " + health + " HP left #");

            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # The " + enemy.getName() + " dropped a Health Potion! # ");
                System.out.println(" # You now have " + numHealthPotions + " Health Potion(s). # ");
            }
            System.out.println("------------------------------------\n");
        }

    }

    public boolean doesPlayerWantToStay() {
        System.out.println("What would you like to do now?");
        System.out.println("1. Continue fighting");
        System.out.println("2. Exit Dungeon");

        String input = in.nextLine();

        while (!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid Command!");
            input = in.nextLine();
        }

        if (input.equals("1")) {
            System.out.println("You continue on your adventure");
        } else if (input.equals("2")) {
            System.out.println("You exit the Dungeon, successful from your adventures! and Return Home.\n");
            return false;
        }
        return true;
    }

    public boolean shop() {

        System.out.println("\tWelcome Home Traveler! What Would You Like To Do First.\n");

            String input = in.nextLine();

            if(input.equals("Leave!")){
                System.out.println("\tDo You Wish To Leave Town?");
            }
            if (input.equals("Yes!")) {
                return false;
            } else if (input.equals("No!")) {
                return true;
            }
            while (!input.equals("Yes!") && !input.equals("No!") && !input.equals("Leave!")) {
                System.out.println("Invalid Command!");
                input = in.nextLine();
            }
        return true;
    }


}