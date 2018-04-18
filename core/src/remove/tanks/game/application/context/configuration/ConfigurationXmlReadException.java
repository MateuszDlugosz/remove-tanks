package remove.tanks.game.application.context.configuration;

import java.io.File;

/**
 * @author Mateusz Długosz
 */
public final class ConfigurationXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read configuration from file %s.";

    public ConfigurationXmlReadException(File file, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, file), cause);
    }
}
