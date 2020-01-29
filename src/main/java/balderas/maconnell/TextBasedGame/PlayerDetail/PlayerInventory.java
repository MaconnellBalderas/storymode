package balderas.maconnell.TextBasedGame.PlayerDetail;

import java.util.ArrayList;
import java.util.List;

public class PlayerInventory {
	
	List<String> inventory = new ArrayList<String>();
	
	private int gold = 100;
	
	public void display() {
		System.out.println("Player Inventory: \n" + getGold() + " Gold Coins\n" + getInventory());
	}
	
	public int getGold() {
		return gold;
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public void addItem(String item) {
		inventory.add(item);
		System.out.println("You Have Recieved: " + inventory);
	}
	public void removeItem(String item) {
		inventory.remove(item);
		System.out.println("You Have Removed An Item ");
	}

	public String getInventory() {
		String listOfInventory = "";
		for(String s : inventory){
			listOfInventory += s + "";
		}
		return listOfInventory;
	}
		
}
