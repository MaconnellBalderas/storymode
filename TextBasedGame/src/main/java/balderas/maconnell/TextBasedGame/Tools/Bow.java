package balderas.maconnell.TextBasedGame.Tools;

public class Bow extends Weapon{
	
	private int damage = 35;
	
	private int durablitiy = 100;
	
	@Override
	public int getDamage() {
		return damage;
	}
	
	@Override
	public int setDamage(int damage) {
		return this.damage = damage;
	}
	
	@Override
	public int getDurability() {
		return durablitiy;
	}
	
	@Override
	public int setDurability(int durability) {
		return this.durablitiy = durability;
	}

	@Override
	public String getName() {
		return "Bow";
	}
	
}
