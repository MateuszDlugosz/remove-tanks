package remove.tanks.game.level.mode.campaign;

import com.badlogic.gdx.Gdx;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class CampaignPrefabStorageFactory {
    private final CampaignPrefabXmlReader campaignPrefabXmlReader;

    public CampaignPrefabStorageFactory(CampaignPrefabXmlReader campaignPrefabXmlReader) {
        this.campaignPrefabXmlReader = campaignPrefabXmlReader;
    }

    public CampaignPrefabStorage createCampaignPrefabStorage(CampaignPrefabFilenameRepository repository) {
        try {
            return new CampaignPrefabStorage(createCampaignPrefabMap(repository));
        } catch (Exception e) {
            throw new CampaignPrefabStorageCreateException(e);
        }
    }

    private Map<String, CampaignPrefab> createCampaignPrefabMap(CampaignPrefabFilenameRepository repository) {
        return campaignPrefabXmlReader.readCampaignPrefabs(
                repository.getCampaignPrefabFilenames().stream().map(Gdx.files::internal).collect(Collectors.toList())
        ).stream()
                .collect(Collectors.toMap(
                        CampaignPrefab::getTitle,
                        c -> c
                ));
    }
}
