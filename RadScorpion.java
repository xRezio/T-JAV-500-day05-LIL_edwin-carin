public class RadScorpion extends Monster {
    public RadScorpion() {
        super("RadScorpion", 80, 50);
        damage = 25;
        apcost = 8;
    }

    @Override
    public boolean attack(Fighter target) {
        if (target instanceof AssaultTerminator) {
            damage *= 2;
        }
        return super.attack(target);
    }
}


