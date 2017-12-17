package remove.tanks.game.level;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import remove.tanks.game.level.event.Event;
import remove.tanks.game.level.event.EventExecutor;
import remove.tanks.game.level.event.destroy.DestroyEntityEvent;
import remove.tanks.game.level.event.spawn.SpawnEntityEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class LevelController {
    private final Level level;
    private final LevelUpdater levelUpdater;
    private final EventExecutor eventExecutor;

    private final List<Object> spawnEntityEvents = new ArrayList<>();
    private final List<Object> destroyEntityEvents = new ArrayList<>();
    private final List<Object> externalEvents = new ArrayList<>();
    private final List<Object> otherEvents = new ArrayList<>();

    LevelController(
            Level level,
            LevelUpdater levelUpdater,
            EventExecutor eventExecutor
    ) {
        this.level = level;
        this.levelUpdater = levelUpdater;
        this.eventExecutor = eventExecutor;
    }

    public Level getLevel() {
        return level;
    }

    public void update(float deltaTime, EventBus eventBus) {
        updateLevel(deltaTime);
        executeDestroyEntityEvents();
        executeSpawnEntityEvents();
        executeOtherEvents();
        executeExternalEvents(eventBus);
    }

    private void updateLevel(float delta) {
        levelUpdater.updateLevel(delta, level);
    }

    private void executeDestroyEntityEvents() {
        eventExecutor.executeEvents(destroyEntityEvents, level);
        destroyEntityEvents.clear();
    }

    private void executeOtherEvents() {
        eventExecutor.executeEvents(otherEvents, level);
        otherEvents.clear();
    }

    private void executeSpawnEntityEvents() {
        eventExecutor.executeEvents(spawnEntityEvents, level);
        spawnEntityEvents.clear();
    }

    private void executeExternalEvents(EventBus eventBus) {
        externalEvents.forEach(eventBus::post);
        externalEvents.clear();
    }

    @Subscribe
    public void handleEvent(Object event) {
        if (event instanceof SpawnEntityEvent) {
            spawnEntityEvents.add(event);
            return;
        }
        if (event instanceof DestroyEntityEvent) {
            destroyEntityEvents.add(event);
            return;
        }
        if (eventExecutor.getSupportedEventClasses().contains(event.getClass())) {
            otherEvents.add(event);
            return;
        }
        externalEvents.add(event);
    }
}
