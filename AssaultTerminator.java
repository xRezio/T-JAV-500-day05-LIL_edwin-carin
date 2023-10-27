public class AssaultTerminator extends SpaceMarine {
    public AssaultTerminator(String name) {
        super(name, 150, 30);
        equip(new PowerFist());
    }

    @Override
    public void receiveDamage(int damage) {
        if (damage <= 3) {
            damage = 1;
        }
        super.receiveDamage(damage);
    }
}