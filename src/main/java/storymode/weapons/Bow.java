package storymode.weapons;

public class Bow extends Weapon {
    @Override
    public int getDamage() {
        return 35;
    }

    @Override
    public String getName() {
        return "Bow";
    }
}
