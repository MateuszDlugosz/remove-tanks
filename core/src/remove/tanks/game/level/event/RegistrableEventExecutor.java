package remove.tanks.game.level.event;

import remove.tanks.game.level.Level;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableEventExecutor<T> {
    void executeEvent(T event, Level level);
    Class<T> getExecutorType();
}
