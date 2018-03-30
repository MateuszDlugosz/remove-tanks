package remove.tanks.game.level.mode.campaign;

/**
 * @author Mateusz Długosz
 */
public final class CampaignCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create campaign from prefab %s.";

    public CampaignCreateException(CampaignPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
