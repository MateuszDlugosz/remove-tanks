package remove.tanks.game.level.mode.campaign;

import com.badlogic.gdx.Gdx;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class CampaignStorageFactory {
    private final CampaignPrefabXmlReader campaignPrefabXmlReader;
    private final CampaignFactory campaignFactory;

    public CampaignStorageFactory(
            CampaignPrefabXmlReader campaignPrefabXmlReader,
            CampaignFactory campaignFactory
    ) {
        this.campaignPrefabXmlReader = campaignPrefabXmlReader;
        this.campaignFactory = campaignFactory;
    }

    public CampaignStorage createCampaignPrefabStorage(CampaignPrefabFilenameRepository repository, AssetStorage assetStorage, Scale scale) {
        try {
            return new CampaignStorage(createCampaignPrefabMap(repository, assetStorage, scale));
        } catch (Exception e) {
            throw new CampaignStorageCreateException(e);
        }
    }

    private Map<String, Campaign> createCampaignPrefabMap(CampaignPrefabFilenameRepository repository, AssetStorage assetStorage, Scale scale) {
        return campaignPrefabXmlReader.readCampaignPrefabs(
                repository.getCampaignPrefabFilenames().stream().map(Gdx.files::internal).collect(Collectors.toList())
        ).stream()
                .collect(Collectors.toMap(
                        CampaignPrefab::getTitle,
                        c -> campaignFactory.createCampaign(c, assetStorage, scale)
                ));
    }
}
