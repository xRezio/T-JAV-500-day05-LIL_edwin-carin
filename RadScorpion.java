public class RadScorpion extends Monster {
    private static int id = 0;

    public RadScorpion() {
        super("RadScorpion #" + (++id), 80, 50, 25);  // Correction ici, enlevé un argument
        System.out.println(getName() + ": Crrr!");
    }

    @Override
    public boolean attack(Fighter target) {
        if (target instanceof SpaceMarine && !(target instanceof AssaultTerminator)) {
            int originalDamage = getDamage();
            this.damage = originalDamage * 2; // Correction ici, changé de méthode
            boolean result = super.attack(target);
            this.damage = originalDamage; // Correction ici, changé de méthode
            return result;
        } else {
            return super.attack(target);
        }
    }
}
