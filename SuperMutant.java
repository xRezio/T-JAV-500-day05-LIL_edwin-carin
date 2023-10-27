public class SuperMutant extends Monster {
    public SuperMutant() {
        super("SuperMutant", 170, 20);
        damage = 60;
        apcost = 20;
    }

    @Override
    public void recoverAP() {
        super.recoverAP();
        hp += 10;
        if (hp > 170) {
            hp = 170;
        }
    }
}