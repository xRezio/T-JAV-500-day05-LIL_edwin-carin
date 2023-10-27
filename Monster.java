public abstract class Monster extends Unit {
    protected int damage;
    protected int apcost;

    public Monster(String name, int hp, int ap) {
        super(name, hp, ap);
        damage = 0;
        apcost = 0;
    }

    public int getDamage() {
        return damage;
    }

    public int getApcost() {
        return apcost;
    }

    @Override
    public boolean equip(Weapon weapon) {
        System.out.println("Monsters are proud and fight with their own bodies.");
        return false;
    }

    @Override
    public boolean attack(Fighter target) {
        if (!moveCloseTo(target)) {
            System.out.println(name + ": I'm too far away from " + target.getName());
            return false;
        }

        if (ap < apcost) {
            recoverAP();
        }

        if (ap >= apcost) {
            System.out.println(name + " attacks " + target.getName());
            target.receiveDamage(damage);
            ap -= apcost;
            return true;
        }

        return false;
    }
}
