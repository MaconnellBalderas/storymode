package storymode.weapons;

public class Sword extends Weapon {
    @Override
    public int getDamage() {
        return 35;
    }

    @Override
    public String getName() {
        return "Sword";
    }
}
