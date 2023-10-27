public interface Fighter {

    public boolean equip(Weapon weapon);

    public boolean attack(Fighter fighter);

    public void receiveDamage(int damage);

    public boolean moveCloseTo(Fighter fighter);

    public void recoverAP();

    public String getName();

    public int getAp();

    public int getHp();


}
