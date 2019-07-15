import monsters.*;

import java.util.Random;

public class PlayerInventory {
    public Random rand = new Random();
    public Monster[] enemies = {new Skeleton(), new Zombie(), new Assassin(), new Warrior()};
    public Monster enemy = enemies[rand.nextInt(enemies.length)];
    public int enemyHealth = rand.nextInt(enemy.getHitPoints());

    int gold = 0;

    public int gold(){
        if(enemyHealth <= 0){
            gold += 5;
        }
        return gold;
    }


    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
