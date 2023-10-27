public abstract class Unit implements Fighter {
    protected String name;
    protected int hp;
    protected int ap;

    protected Unit(String name, int hp, int ap) {
        this.name = name;
        this.hp = hp;
        this.ap = ap;
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
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
        }
    }

    @Override
    public boolean moveCloseTo(Fighter target) {
        System.out.println(name + " is moving closer to " + target.getName());
        return true;
    }

    @Override
    public void recoverAP() {
        ap += 7;
        if (ap > 50) {
            ap = 50;
        }
    }
}