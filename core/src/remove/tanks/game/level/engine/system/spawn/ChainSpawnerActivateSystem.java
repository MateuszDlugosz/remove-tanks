package remove.tanks.game.level.engine.system.spawn;

import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.level.engine.utility.letter.NATOLetter;
import remove.tanks.game.level.engine.utility.spwan.activator.SpawnerActivator;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ChainSpawnerActivateSystem extends EntitySystem {
    private List<SpawnerActivator> spawnerActivators;

    public ChainSpawnerActivateSystem(List<SpawnerActivator> spawnerActivators, int priority) {
        super(priority);
        this.spawnerActivators = spawnerActivators;
    }

    @Override
    public void update(float deltaTime) {
        if (spawnerActivators.size() > 0) {
            if (spawnerActivators.get(0).getTimer().isComplete()) {
                activateSpawner(spawnerActivators.get(0).getLetter());
                spawnerActivators.remove(0);
            } else {
                spawnerActivators.get(0).getTimer().update(deltaTime);
            }
        }
    }

    private void activateSpawner(NATOLetter letter) {
        if (getEngine().getSystem(AutoSpawnerSystem.class) != null) {
            getEngine().getSystem(AutoSpawnerSystem.class).activateSpawner(letter);
        }
    }
}
