package remove.tanks.game.physics.light.world;

import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class WorldLightPropertyTranslateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot translate properties %s to world light.";

    public WorldLightPropertyTranslateException(Properties properties, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, properties), cause);
    }
}
