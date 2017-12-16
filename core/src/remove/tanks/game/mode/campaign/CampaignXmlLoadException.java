package remove.tanks.game.mode.campaign;

/**
 * @author Mateusz Długosz
 */
public final class CampaignXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load campaign from file %s.";

    public CampaignXmlLoadException(String filename, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, filename), cause);
    }
}
