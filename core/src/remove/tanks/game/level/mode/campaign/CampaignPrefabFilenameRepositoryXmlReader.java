package remove.tanks.game.level.mode.campaign;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class CampaignPrefabFilenameRepositoryXmlReader {
    private static final String CAMPAIGN_PREFAB_FILENAME_ELEMENT = "campaignPrefabFilename";

    private final XmlReader xmlReader;

    public CampaignPrefabFilenameRepositoryXmlReader(XmlReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    public CampaignPrefabFilenameRepository readCampaignPrefabRepository(FileHandle fileHandle) {
        try {
            XmlReader.Element element = xmlReader.parse(fileHandle);
            return new CampaignPrefabFilenameRepository(readCampaignPrefabFilenames(element));
        } catch (Exception e) {
            throw new CampaignPrefabFilenameRepositoryXmlReadException(fileHandle, e);
        }
    }

    private List<String> readCampaignPrefabFilenames(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(CAMPAIGN_PREFAB_FILENAME_ELEMENT).toArray())
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
    }
}
