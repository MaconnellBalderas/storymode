package storymode;

public class PlayerStats {
    public int attackDamage = 15;

    public int damage(){
        attackDamage = 35;
        return attackDamage;
    }



    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
}
