package storymode;

import storymode.weapons.Item;
import storymode.weapons.Sword;

import java.util.ArrayList;
import java.util.List;

public class PlayerInventory {
    List<Item> inventory = new ArrayList<Item>();

    private int gold = 100;

    public int getGold() {
        return gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }

    public String inventory(Dungeon dungeon, PlayerStats playerStats){
        if(){
            return "You Currently Have A Sword.";
        }else{
            return "You Currently Have No Items! Trying Going To A Shop To Get Items.\n";
        }
    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println(inventory);
    }


}