public abstract class Monster extends Unit {
    protected int damage;
    protected int apcost;

    protected Monster(String name, int hp, int damage, int apcost) {
        super(name, hp, 50);
        this.damage = damage;
        this.apcost = apcost;
    }

    public int getDamage() {
        return damage;
    }

    public int getApcost() {
        return apcost;
    }
    
    public boolean isAlive() {
    return this.hp > 0;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public boolean equip(Weapon weapon) {
        System.out.println("Monsters are proud and fight with their own bodies.");
        return false;
    }

    @Override
    public boolean attack(Fighter fighter) {
        if (!isCloseToTarget) {
            System.out.println(name + ": I'm too far away from " + fighter.getName());
            return false;
        }
        if (ap < apcost) {
            return false;
        }
        System.out.println(name + " attacks " + fighter.getName());
        ap -= apcost;
        fighter.receiveDamage(damage);
        return true;
    }
}