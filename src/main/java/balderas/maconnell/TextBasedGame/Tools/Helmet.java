package balderas.maconnell.TextBasedGame.Tools;

public class Helmet extends Armor{
	
	private int durablitiy = 100;

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
		return "Helmet";
	}

}
