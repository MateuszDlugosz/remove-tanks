package remove.tanks.game.level.mode.campaign;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class CampaignPrefabFilenameRepository {
    private final List<String> campaignPrefabFilenames;

    public CampaignPrefabFilenameRepository(List<String> campaignPrefabFilenames) {
        this.campaignPrefabFilenames = campaignPrefabFilenames;
    }

    public List<String> getCampaignPrefabFilenames() {
        return campaignPrefabFilenames;
    }
}
