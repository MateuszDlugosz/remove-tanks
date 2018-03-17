package remove.tanks.game.level.event;

import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public interface SubEventExecutor<T extends Event> {
    void executeEvent(T event, ResourceRegistry registry);
    Class<T> getExecutorType();
}
