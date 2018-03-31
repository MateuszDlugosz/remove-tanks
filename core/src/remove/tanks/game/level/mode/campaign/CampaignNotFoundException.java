package remove.tanks.game.level.mode.campaign;

/**
 * @author Mateusz Długosz
 */
public final class CampaignNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Campaign prefab titled %s not found.";

    public CampaignNotFoundException(String title) {
        super(String.format(MESSAGE_TEMPLATE, title));
    }
}
