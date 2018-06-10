package remove.tanks.game.level.mode.campaign;

/**
 * @author Mateusz Długosz
 */
public final class CampaignFactory {
    public Campaign createCampaign(CampaignPrefab prefab) {
        try {
            return new Campaign(
                    prefab.getTitle(),
                    prefab.getLevelSequence()
            );
        } catch (Exception e) {
            throw new CampaignCreateException(prefab, e);
        }
    }

}
