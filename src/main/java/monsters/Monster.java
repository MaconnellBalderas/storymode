package monsters;

public class Monster{
    private String name;
    private int hitPoints;
    private int attackDamage;
    private String weakness;
    private int weaknessMultiplier;

    public Monster(String name, int hitPoints, int attackDamage, String weakness, int weaknessMultiplier) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.attackDamage = attackDamage;
        this.weakness = weakness;
        this.weaknessMultiplier = weaknessMultiplier;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints){
        this.hitPoints = hitPoints;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public String getWeakness() {
        return weakness;
    }

    public int getWeaknessMultiplier() {
        return weaknessMultiplier;
    }
}