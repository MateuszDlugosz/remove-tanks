package remove.tanks.game.level;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.event.EventExecutor;

/**
 * @author Mateusz Długosz
 */
public final class LevelControllerFactory {
    private final EventExecutor eventExecutor;
    private final LevelUpdater levelUpdater;

    public LevelControllerFactory(
            EventExecutor eventExecutor,
            LevelUpdater levelUpdater
    ) {
        this.eventExecutor = eventExecutor;
        this.levelUpdater = levelUpdater;
    }

    public LevelController createLevelController(Level level) {
        LevelController levelController = new LevelController(level, levelUpdater, eventExecutor);
        level.getResourceRegistry().getResource(LevelResource.EventBus.toString(), EventBus.class)
                .register(levelController);
        return levelController;
    }
}
