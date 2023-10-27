public class SuperMutant extends Monster {
    private static int id = 0;

    public SuperMutant() {
        super("SuperMutant #" + (++id), 170, 20, 60);  // Correction ici, enlevé un argument
        System.out.println(getName() + ": Roaarrr!");
    }

    @Override
    public void recoverAP() {
        if (getHp() <= 0) return;

        int newHp = getHp() + 10;
        this.hp = Math.min(newHp, 170);  // Correction ici, changé de méthode
        super.recoverAP();
    }
}
