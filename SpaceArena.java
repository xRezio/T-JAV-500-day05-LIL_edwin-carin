import java.util.ArrayList;
import java.util.List;

public class SpaceArena {
    private List<Monster> monsters = new ArrayList<>();
    private List<SpaceMarine> spaceMarines = new ArrayList<>();

    public void enlistMonsters(List<Monster> monsterList) {
        for (Monster monster : monsterList) {
            if (!monsters.contains(monster)) {
                monsters.add(monster);
                System.out.println(monster.getName() + " has entered the arena.");
            }
        }
    }

    public void enlistSpaceMarines(List<SpaceMarine> spaceMarineList) {
        for (SpaceMarine spaceMarine : spaceMarineList) {
            if (!spaceMarines.contains(spaceMarine)) {
                spaceMarines.add(spaceMarine);
                System.out.println(spaceMarine.getName() + " has entered the arena.");
            }
        }
    }

    public boolean fight() {
        if (monsters.isEmpty()) {
            System.out.println("No monsters available to fight.");
            return false;
        }

        if (spaceMarines.isEmpty()) {
            System.out.println("Those cowards ran away.");
            return false;
        }

        while (!monsters.isEmpty() && !spaceMarines.isEmpty()) {
            // Space Marines attack
            for (SpaceMarine marine : spaceMarines) {
                for (Monster monster : monsters) {
                    if (marine.attack(monster)) {
                        monsters.removeIf(m -> m.getHp() <= 0);
                        break;
                    }
                }
            }

            // Monsters attack
            for (Monster monster : monsters) {
                for (SpaceMarine marine : spaceMarines) {
                    if (monster.attack(marine)) {
                        spaceMarines.removeIf(m -> m.getHp() <= 0);
                        break;
                    }
                }
            }
        }

        if (monsters.isEmpty()) {
            System.out.println("The monsters are victorious.");
        } else {
            System.out.println("The spaceMarines are victorious.");
        }

        for (SpaceMarine marine : spaceMarines) {
            marine.recoverAP();
        }
        for (Monster monster : monsters) {
            monster.recoverAP();
        }

        return true;
    }
}
