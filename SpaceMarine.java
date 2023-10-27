public abstract class SpaceMarine extends Unit {
    public SpaceMarine(String name, int hp, int ap) {
        super(name, hp, ap);
    }

    public abstract void specialAttack(Fighter target);
    public abstract void specialMove();

     @Override
    public boolean equip(Weapon weapon) {
        if (weapon == null) return false;
        if (hp > 0) {
            this.weapon = weapon;
            System.out.println(name + " has equipped a " + weapon.getName());
            return true;
        }
        return false;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    @Override
    public boolean attack(Fighter target) {
        if (weapon == null) {
            System.out.println(name + " is unarmed!");
            return false;
        }
        if (ap < weapon.getApcost()) {
            System.out.println(name + " does not have enough AP to attack with " + weapon.getName());
            return false;
        }
        if (!weapon.isMelee() && !isCloseToTarget) {
            System.out.println(name + " is too far away to attack " + target.getName());
            return false;
        }
        ap -= weapon.getApcost();
        System.out.println(name + " attacks " + target.getName() + " with a " + weapon.getName());
        target.receiveDamage(weapon.getDamage());
        return true;
    }
}
