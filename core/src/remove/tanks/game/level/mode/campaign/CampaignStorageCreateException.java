package remove.tanks.game.level.mode.campaign;

/**
 * @author Mateusz Długosz
 */
public final class CampaignStorageCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create campaign prefab storage.";

    public CampaignStorageCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
