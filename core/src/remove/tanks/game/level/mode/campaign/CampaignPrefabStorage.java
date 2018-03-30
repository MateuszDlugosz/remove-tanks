package remove.tanks.game.level.mode.campaign;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class CampaignPrefabStorage {
    private final Map<String, CampaignPrefab> campaignPrefabs;

    CampaignPrefabStorage(Map<String, CampaignPrefab> campaignPrefabs) {
        this.campaignPrefabs = campaignPrefabs;
    }

    public CampaignPrefab getCampaignPrefab(String title) {
        if (!campaignPrefabs.containsKey(title)) {
            throw new CampaignPrefabNotFoundException(title);
        }
        return campaignPrefabs.get(title);
    }

    public List<CampaignPrefab> getCampaignPrefabs() {
        return new ArrayList<>(campaignPrefabs.values());
    }
}
