package remove.tanks.game.level.mode.campaign;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class CampaignStorage {
    private final Map<String, Campaign> campaigns;

    CampaignStorage(Map<String, Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public Campaign getCampaign(String title) {
        if (!campaigns.containsKey(title)) {
            throw new CampaignNotFoundException(title);
        }
        return campaigns.get(title);
    }

    public List<Campaign> getCampaignPrefabs() {
        return new ArrayList<>(campaigns.values());
    }
}
