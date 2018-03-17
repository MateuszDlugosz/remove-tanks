package remove.tanks.game.level;

import com.google.common.eventbus.Subscribe;
import remove.tanks.game.level.event.Event;
import remove.tanks.game.level.event.EventExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class LevelController {
    private final Level level;
    private final LevelUpdater levelUpdater;
    private final EventExecutor eventExecutor;
    private final List<Event> events = new ArrayList<>();
    private final List<Event> eventsToExecute = new ArrayList<>();

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

    public void update(float deltaTime) {
        updateLevel(deltaTime);
        executeEvents();
    }

    private void updateLevel(float delta) {
        levelUpdater.updateLevel(delta, level);
    }

    private void executeEvents() {
        eventsToExecute.addAll(events);
        events.clear();
        eventExecutor.executeEvents(eventsToExecute, level.getResourceRegistry());
        eventsToExecute.clear();
    }

    @Subscribe
    public void handleEvent(Event event) {
        events.add(event);
    }
}
