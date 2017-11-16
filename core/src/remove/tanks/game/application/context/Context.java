package remove.tanks.game.application.context;

import remove.tanks.game.application.context.configuration.Configuration;

/**
 * @author Mateusz Długosz
 */
public interface Context {
    Configuration getConfiguration();
    Object getComponent(String name);
    <T> T getComponent(Class<T> type);
    <T> T getComponent(String name, Class<T> type);
}
