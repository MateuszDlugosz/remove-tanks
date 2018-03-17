package remove.tanks.game.physics.world;

import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class WorldPropertyTranslateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot translate properties %s to world.";

    public WorldPropertyTranslateException(Properties properties, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, properties), cause);
    }
}
