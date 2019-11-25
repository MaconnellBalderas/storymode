package balderas.maconnell.TextBasedGame;

import java.util.Random;
import java.util.Scanner;

import balderas.maconnell.TextBasedGame.Entity.Assassin;
import balderas.maconnell.TextBasedGame.Entity.Monster;
import balderas.maconnell.TextBasedGame.Entity.Skeleton;
import balderas.maconnell.TextBasedGame.Entity.Warrior;
import balderas.maconnell.TextBasedGame.Entity.Zombie;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerStats;
import balderas.maconnell.TextBasedGame.Tools.Axe;
import balderas.maconnell.TextBasedGame.Tools.Bow;
import balderas.maconnell.TextBasedGame.Tools.Spear;
import balderas.maconnell.TextBasedGame.Tools.Sword;
import balderas.maconnell.TextBasedGame.Tools.Weapon;

public class Dungeon {
	
	//redo dungeon class!!!!!!!!!!!!
	
	public static final String WEAPON_BOW = "Bow";
	public static final String WEAPON_AXE = "Axe";
	public static final String WEAPON_SWORD = "Sword";
	public static final String WEAPON_SPEAR = "Spear";
	
	boolean inDungeon = true;
	
	Scanner in = new Scanner(System.in);
	
	public void enter(PlayerInventory playerInventory, PlayerStats playerStats, Axe axe, Spear spear, Sword sword, Bow bow) {
		
		Random random = new Random();
		
		Monster[] enemies = {new Skeleton(), new Zombie(), new Assassin(), new Warrior()};
		String[] items = {"Sword", "Axe", "Bow", "Spear"};
		
		//Enemy Stats
		//int enemyAttackDamage = 15;
		//Player Stats
		int health = playerStats.getHealth();
		int numHealthPotions = 3;
		int healthPotionHealAmount = 50;
		int healthPotionDropChance = 50; // Percentage
		
		boolean running = true;
		
		GAME:
		while( running ) {
			System.out.println("--------------------------------------------------------");
			
			Monster enemy = enemies[random.nextInt(enemies.length)];
			int enemeyHealth = random.nextInt(enemy.getHitPoints());
			
			int damageDealt = playerStats.getAttackDamge();
			int damgeTaken = enemy.getAttackDamage();
			
			System.out.println("\t# " + enemy.getName() + " has appeared! #\n");
			
			while( enemeyHealth > 0) {
				System.out.println("> Your HP: " + health);
				System.out.println("> " + enemy.getName() + "'s HP: " + enemeyHealth);
				
				System.out.println("> You Have " + numHealthPotions + " Health Potions.");
				
				System.out.println("\n What Would You Like To Do?");
				System.out.println("1. Attack");
				System.out.println("2. Drink A Health Potion");
				System.out.println("3. Run!");
				
				String input = in.nextLine();
				
				if(input.equals("Axe")) {
					damageDealt = axe.getDamage();
				} else if(input.equals("Sword")) {
					damageDealt = sword.getDamage();
				} else if(input.equals("Spear")) {
					damageDealt = spear.getDamage();
				} else if(input.equals("Bow")) {
					damageDealt = bow.getDamage();
				} else if(input.equals("1")) {
					
					enemeyHealth -= damageDealt;
					health -= damgeTaken;
					
					//decrease weapon durability
					//decrease armor durability
					
					
					System.out.println("--------------------------------------------------------");
					System.out.println("> You Strike The " + enemy.getName() + " For " + damageDealt + " damage.");
					System.out.println("> You Receive " + enemy.getAttackDamage() + " In Retaliation!");
					
					if (health < 1) {
						System.out.println("> You Have Taken Too Much Damage, You Are Too Weak To Go On!");
						break;
					}
					
				} else if (input.equals("2")) {
					
					if(numHealthPotions > 0) {
						health += healthPotionHealAmount;
						numHealthPotions--;
						System.out.println("--------------------------------------------------------");
						System.out.println("> You Drink A Health Potion, Healing Yourself For " + healthPotionHealAmount + "." + "\n> You Now Have " + health + " HP.");
						System.out.println("--------------------------------------------------------");
					} else {
						System.out.println("--------------------------------------------------------");
						System.out.println("> You Have No Health Potions Left! Deat Enemies For A Change To Get One!\n");
					}
					
				} else if (input.equals("3")) {
					System.out.println("You run away from the " + enemy.getName() + "!");

                    running = doesPlayerWantToStay();

                    continue GAME;
					
				} else if (input.equals("Inventory")) {
					System.out.println("--------------------------------------------------------");
					for (String item : playerInventory.getInventory()) {
						System.out.println(item);
					}
					System.out.println("--------------------------------------------------------");
				} else {
					System.out.println("Invalid Command");
				}
			}
			
			int gold = random.nextInt(10);
			System.out.println("> You Have Found " + gold + " Coins!\n");
			playerInventory.setGold(playerInventory.getGold() + gold);
			
			if (health < 1) {
				System.out.println("You Limp Out Of The Dungeon, Weak From Battle.");
				break;
			}
			
			System.out.println("------------------------------------");
			System.out.println(" # " + enemy.getName() + " Was Defeated! #");
			System.out.println(" # You Have " + health + " HP Left #");
			
			if(random.nextInt(100) < healthPotionDropChance) {
				numHealthPotions++;
				System.out.println(" # The " + enemy.getName() + " Dropped A Health Potion! # ");
				System.out.println(" # You Now Have " + numHealthPotions + " Health Potion(s). # ");
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
	
}
