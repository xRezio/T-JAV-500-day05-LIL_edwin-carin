public abstract class Unit implements Fighter {

    protected String name;
    protected int hp;
    protected int ap;
    protected Fighter fighterClose = null;

    protected Unit(String name, int hp, int ap) {
        this.name = name;
        this.hp = hp;
        this.ap = ap;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getAp() {
        return ap;
    }

    @Override
    public void receiveDamage(int damage) {
        if(damage < 1) {
            return;
        }
        if(damage >= this.hp) {
            this.hp = 0;
        } else {
            this.hp -= damage;
        }
    }

    @Override
    public boolean moveCloseTo(Fighter fighter) {
        if (this == fighter || fighter == null) { return false; }
        if (this.fighterClose == null || this.fighterClose != fighter) {
            this.fighterClose = fighter;
            System.out.println(this.name + " is moving closer to " + fighter.getName() + ".");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void recoverAP() {
        if (this.ap + 7 > 50) {
            this.ap = 50;
        } else {
            this.ap += 7;
        }
    }
}
