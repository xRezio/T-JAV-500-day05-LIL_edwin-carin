public class TacticalMarine extends SpaceMarine {
    public TacticalMarine(String name) {
        super(name, 100, 20);
    }

    @Override
    public void specialAttack(Fighter target) {
        System.out.println(name + " launches a grenade at " + target.getName());
        target.receiveDamage(30);
    }

    @Override
    public void specialMove() {
        System.out.println(name + " performs a tactical roll");
    }
}