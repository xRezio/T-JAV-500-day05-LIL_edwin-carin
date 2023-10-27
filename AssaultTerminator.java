public class AssaultTerminator extends SpaceMarine {
    public AssaultTerminator(String name) {
        super(name, 150, 30);
    }

    @Override
    public void specialAttack(Fighter target) {
        System.out.println(name + " smashes " + target.getName() + " with his power fist");
        target.receiveDamage(40);
    }

    @Override
    public void specialMove() {
        System.out.println(name + " teleports short distance");
    }
}