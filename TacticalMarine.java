public class TacticalMarine extends SpaceMarine {

    public TacticalMarine(String name) {
        super(name, 100, 20);
        this.name = name;
        System.out.println(this.name + " on duty.");
        super.equip(new PlasmaRifle());
    }

    @Override
    public void recoverAP() {
        this.ap += 12;
        if (this.ap > 50) {
            this.ap = 50;
        }
    }
}
