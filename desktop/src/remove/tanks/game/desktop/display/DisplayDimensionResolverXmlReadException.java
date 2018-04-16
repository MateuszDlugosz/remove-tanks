package remove.tanks.game.desktop.display;

import java.io.File;

/**
 * @author Mateusz Długosz
 */
public final class DisplayDimensionResolverXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read display mode from file %s.";

    public DisplayDimensionResolverXmlReadException(File file, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, file.getAbsoluteFile()), cause);
    }
}
