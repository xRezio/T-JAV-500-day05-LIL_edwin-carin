public abstract class SpaceMarine extends Unit {

    protected Weapon weapon = null;

    protected SpaceMarine(String name, int hp, int ap) {
        super(name, hp, ap);
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    @Override
    public boolean equip(Weapon weapon) {
        if (weapon == null || weapon.isEquipped) {
            return false;
        }

        if (this.weapon != null) {
            this.weapon.isEquipped = false;
        }

        System.out.println(getName() + " has been equipped with a " + weapon.getName() + ".");
        this.weapon = weapon;
        weapon.isEquipped = true;
        return true;
    }


    @Override
    public boolean attack(Fighter fighter) {
        if (fighter == null) {
            return false;
        }
        if (weapon == null) {
            System.out.println(getName() + ": Hey, this is crazy. I'm not going to fight this empty-handed.");
            return false;
        }
        if (ap < weapon.getApcost()) {
            return false;
        }
        if (weapon.isMelee()) {
            if(this.fighterClose != fighter) {
                System.out.println(getName() + ": I'm too far away from " + fighter.getName() + ".");
                return false;
            }
        }
        ap -= weapon.getApcost();
        System.out.println(getName() + " attacks " + fighter.getName() + " with a " + weapon.getName() + ".");
        weapon.attack();
        fighter.receiveDamage(weapon.getDamage());
        return true;
    }

    @Override
    public boolean moveCloseTo(Fighter fighter) {
        if (this == fighter || fighter == null) {
            return false;
        } else if (this.weapon != null && this.weapon.isMelee()) {
            return super.moveCloseTo(fighter);
        } else {
            return false;
        }
    }

    @Override
    public void recoverAP() {
        this.ap += 9;
        if (this.ap > 50) {
            this.ap = 50;
        }
    }
}
