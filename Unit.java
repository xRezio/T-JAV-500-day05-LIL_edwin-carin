public abstract class Unit implements Fighter {
    protected String name;
    protected int hp;
    protected int ap;
    protected Weapon weapon;
    protected boolean isCloseToTarget;

    protected Unit(String name, int hp, int ap) {
        this.name = name;
        this.hp = hp;
        this.ap = ap;
        this.weapon = null;
        this.isCloseToTarget = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAp() {
        return ap;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void receiveDamage(int damage) {
        if (hp > 0) {
            hp -= damage;
            if (hp < 0) hp = 0;
        }
    }

    @Override
    public boolean moveCloseTo(Fighter fighter) {
        if (this != fighter) {
            System.out.println(name + " is moving closer to " + fighter.getName());
            isCloseToTarget = true;
            return true;
        }
        return false;
    }

    @Override
    public void recoverAP() {
        if (hp > 0) {
            ap += 7;
            if (ap > 50) ap = 50;
        }
    }
}