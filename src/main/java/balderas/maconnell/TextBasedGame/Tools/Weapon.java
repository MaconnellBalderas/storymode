package balderas.maconnell.TextBasedGame.Tools;

public abstract class Weapon extends Item{
	
	public abstract int getDamage();
	
	public abstract int setDamage(int damage);
	
	public abstract int getDurability();
	
	public abstract int setDurability(int durability);

}
