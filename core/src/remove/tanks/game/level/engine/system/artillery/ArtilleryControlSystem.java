package remove.tanks.game.level.engine.system.artillery;

import com.badlogic.ashley.core.EntitySystem;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.event.create.CreateEvent;
import remove.tanks.game.level.utility.create.CreateEntry;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;
import remove.tanks.game.utility.surface.boundary.Boundary;
import remove.tanks.game.utility.surface.position.Position;
import remove.tanks.game.utility.time.Timer;

import java.util.Collections;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ArtilleryControlSystem extends EntitySystem {
    private final RandomNumberGenerator randomNumberGenerator;
    private final Boundary boundary;
    private final EventBus eventBus;
    private final Timer frequencyTimer;
    private final List<String> entityPrefabCodes;
    private int shootQueue;

    public ArtilleryControlSystem(
            int priority,
            RandomNumberGenerator randomNumberGenerator,
            Boundary boundary,
            EventBus eventBus,
            Timer frequencyTimer,
            List<String> entityPrefabCodes
    ) {
        super(priority);
        this.randomNumberGenerator = randomNumberGenerator;
        this.boundary = boundary;
        this.eventBus = eventBus;
        this.frequencyTimer = frequencyTimer;
        this.entityPrefabCodes = entityPrefabCodes;
        this.shootQueue = 0;
    }

    public void shoot() {
        shootQueue += 1;
    }

    @Override
    public void update(float deltaTime) {
        if (shootQueue > 0) {
            if (frequencyTimer.isCompleted()) {
                frequencyTimer.reset();
                shootQueue -= 1;

                eventBus.post(new CreateEvent(Collections.singletonList(new CreateEntry(
                        getRandomEntityPrefabCode(),
                        getRandomPosition()
                ))));
            } else {
                frequencyTimer.update(deltaTime);
            }
        }
    }

    private String getRandomEntityPrefabCode() {
        return entityPrefabCodes.get(randomNumberGenerator.getRandomInt(0, entityPrefabCodes.size() - 1));
    }

    private Position getRandomPosition() {
        return new Position(
                randomNumberGenerator.getRandomFloat(boundary.getMinX(), boundary.getMaxX()),
                randomNumberGenerator.getRandomFloat(boundary.getMinY(), boundary.getMaxY())
        );
    }
}
