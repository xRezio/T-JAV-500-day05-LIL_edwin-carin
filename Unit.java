public abstract class Unit implements Fighter {
    protected String name;
    protected int hp;
    protected int ap;

    protected Unit(String name, int hp, int ap) {
        this.name = name;
        this.hp = hp;
        this.ap = ap;
    }

    public String getName() {
        return name;
    }

    public int getAp() {
        return ap;
    }

    public int getHp() {
        return hp;
    }

    public void receiveDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
        }
    }

    public boolean moveCloseTo(Fighter target) {
        if (target != this) {
            System.out.println(name + " is moving closer to " + target.getName() + ".");
            return true;
        } else {
            System.out.println("Can't move closer to yourself.");
            return false;
        }
    }

    public void recoverAP() {
        ap += 7;
        if (ap > 50) {
            ap = 50;
        }
    }
}