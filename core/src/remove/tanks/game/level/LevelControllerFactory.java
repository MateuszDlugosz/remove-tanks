package remove.tanks.game.level;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.event.EventExecutor;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class LevelControllerFactory {
    private final LevelUpdater levelUpdater;
    private final EventExecutor eventExecutor;
    private final LevelInitializer levelInitializer;

    public LevelControllerFactory(LevelUpdater levelUpdater, EventExecutor eventExecutor, LevelInitializer levelInitializer) {
        this.levelUpdater = levelUpdater;
        this.eventExecutor = eventExecutor;
        this.levelInitializer = levelInitializer;
    }

    public LevelController createLevelController(Level level) {
        try {
            LevelController levelController = new LevelController(level, levelUpdater, eventExecutor);
            level.getResourceRegistry().getResource(ResourceType.EventBusResource,
                    EventBus.class).register(levelController);
            levelInitializer.initializeLevel(level);
            return levelController;
        } catch (Exception e) {
            throw new LevelControllerCreateException(e);
        }
    }
}
