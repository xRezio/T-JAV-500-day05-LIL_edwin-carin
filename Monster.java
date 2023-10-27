public abstract class Monster extends Unit {

    protected int damage = 0;
    protected  int apcost = 0;

    protected Monster(String name, int hp, int ap) {
        super(name, hp, ap);
    }

    public int getDamage() {
        return this.damage;
    }

    public int getApcost() {
        return this.apcost;
    }

    @Override
    public boolean equip(Weapon weapon) {
        System.out.println("Monsters are proud and fight with their own bodies.");
        return false;
    }

    @Override
    public boolean attack(Fighter fighter) {
        if (fighter == null) {
            return false;
        }
        if (this.fighterClose != fighter) {
            System.out.println(getName() + ": I'm too far away from " + fighter.getName() + ".");
            return false;
        }
        if (this.ap < this.apcost) {
            return false;
        }
        this.ap -= this.apcost;
        System.out.println(this.getName() + " attacks " + fighter.getName() + ".");
        fighter.receiveDamage(this.damage);
        return true;
    }


}
