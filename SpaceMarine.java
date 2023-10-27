public abstract class SpaceMarine extends Unit {
    private Weapon weapon;

    public SpaceMarine(String name, int hp, int ap) {
        super(name, hp, ap);
        weapon = null;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public boolean equip(Weapon weapon) {
        if (this.weapon == null) {
            this.weapon = weapon;
            System.out.println(name + " has been equipped with a " + weapon.getName() + ".");
            return true;
        } else {
            System.out.println("Weapon already equipped.");
            return false;
        }
    }

    @Override
    public boolean attack(Fighter target) {
        if (weapon == null) {
            System.out.println(name + ": Hey, this is crazy. I'm not going to fight this empty-handed.");
            return false;
        }

        if (weapon.isMelee() && !moveCloseTo(target)) {
            System.out.println(name + ": I'm too far away from " + target.getName());
            return false;
        }

        if (ap < weapon.getApcost()) {
            recoverAP();
        }

        if (ap >= weapon.getApcost()) {
            System.out.println(name + " attacks " + target.getName() + " with a " + weapon.getName());
            target.receiveDamage(weapon.getDamage());
            ap -= weapon.getApcost();
            return true;
        }

        return false;
    }

    @Override
    public boolean moveCloseTo(Fighter target) {
        if (weapon != null && weapon.isMelee()) {
            return super.moveCloseTo(target);
        }
        return false;
    }

    @Override
    public void recoverAP() {
        ap += 9;
        if (ap > 50) {
            ap = 50;
        }
    }
}
