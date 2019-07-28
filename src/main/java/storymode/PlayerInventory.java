package storymode;

public class PlayerInventory {
    private int gold = 0;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String inventory(Dungeon dungeon){
        if(attackDamage == 35){
            return "You Currently Have A Sword.";
        }else{
            return "You Currently Have No Items! Trying Going To A Shop To Get Items.\n";
        }
    }

}