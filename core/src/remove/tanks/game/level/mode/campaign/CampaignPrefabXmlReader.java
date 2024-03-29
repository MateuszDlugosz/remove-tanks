package remove.tanks.game.level.mode.campaign;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.level.LevelSequenceXmlReader;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class CampaignPrefabXmlReader {
    private static final String TITLE_ELEMENT = "title";

    private final XmlReader xmlReader;
    private final LevelSequenceXmlReader levelSequenceXmlReader;

    public CampaignPrefabXmlReader(
            XmlReader xmlReader,
            LevelSequenceXmlReader levelSequenceXmlReader
    ) {
        this.xmlReader = xmlReader;
        this.levelSequenceXmlReader = levelSequenceXmlReader;
    }

    public List<CampaignPrefab> readCampaignPrefabs(List<FileHandle> fileHandles) {
        return fileHandles.stream()
                .map(this::readCampaignPrefab)
                .collect(Collectors.toList());
    }

    public CampaignPrefab readCampaignPrefab(FileHandle fileHandle) {
        try {
            XmlReader.Element element = xmlReader.parse(fileHandle);
            return new CampaignPrefab(
                    readTitle(element),
                    readLevelSequence(element)
            );
        } catch (Exception e) {
            throw new CampaignPrefabXmlReadException(fileHandle, e);
        }
    }

    private String readTitle(XmlReader.Element element) {
        return element.getChildByName(TITLE_ELEMENT).getText().trim();
    }

    private LevelSequence readLevelSequence(XmlReader.Element element) {
        return levelSequenceXmlReader.readLevelSequence(
                element.getChildByName(LevelSequenceXmlReader.LEVEL_SEQUENCE_ELEMENT)
        );
    }
}
