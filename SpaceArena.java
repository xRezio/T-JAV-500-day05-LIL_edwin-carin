import java.util.ArrayList;
import java.util.List;

public class SpaceArena {
    private List<Monster> monsters = new ArrayList<>();
    private List<SpaceMarine> spaceMarines = new ArrayList<>();

    public void enlistMonsters(List<Monster> monsters) {
        for (Monster monster : monsters) {
            if (!this.monsters.contains(monster)) {
                this.monsters.add(monster);
            }
        }
    }

    public void enlistSpaceMarines(List<SpaceMarine> spaceMarines) {
        for (SpaceMarine spaceMarine : spaceMarines) {
            if (!this.spaceMarines.contains(spaceMarine)) {
                this.spaceMarines.add(spaceMarine);
            }
        }
    }

    public boolean fight() {
        if (monsters.isEmpty()) {
            System.out.println("No monsters available to fight.");
            return false;
        } else if (spaceMarines.isEmpty()) {
            System.out.println("Those cowards ran away.");
            return false;
        }

        while (!monsters.isEmpty() && !spaceMarines.isEmpty()) {
            // Assuming first space marine and monster are always fighting
            SpaceMarine spaceMarine = spaceMarines.get(0);
            Monster monster = monsters.get(0);

            System.out.println(spaceMarine.getName() + " has entered the arena.");
            System.out.println(monster.getName() + " has entered the arena.");

            while (spaceMarine.isAlive() && monster.isAlive()) {
                spaceMarine.attack(monster);
                if (monster.isAlive()) {
                    monster.attack(spaceMarine);
                }
            }

            if (spaceMarine.isAlive()) {
                spaceMarine.recoverAP();
                monsters.remove(0);
            } else {
                spaceMarines.remove(0);
            }
        }

        if (spaceMarines.isEmpty()) {
            System.out.println("The monsters are victorious.");
        } else {
            System.out.println("The space marines are victorious.");
        }

        return true;
    }
}
