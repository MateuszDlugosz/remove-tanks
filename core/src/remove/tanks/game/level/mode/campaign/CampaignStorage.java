package remove.tanks.game.level.mode.campaign;

import java.util.Map;
import java.util.Set;

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

    public Set<String> getCampaignTitles() {
        return campaigns.keySet();
    }
}
