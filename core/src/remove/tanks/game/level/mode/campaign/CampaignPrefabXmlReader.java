package remove.tanks.game.level.mode.campaign;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.sprite.SpritePrefab;
import remove.tanks.game.graphics.sprite.SpritePrefabXmlReader;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.level.LevelSequenceXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class CampaignPrefabXmlReader {
    private final XmlReader xmlReader;
    private final SpritePrefabXmlReader spritePrefabXmlReader;
    private final LevelSequenceXmlReader levelSequenceXmlReader;

    public CampaignPrefabXmlReader(
            XmlReader xmlReader,
            SpritePrefabXmlReader spritePrefabXmlReader,
            LevelSequenceXmlReader levelSequenceXmlReader
    ) {
        this.xmlReader = xmlReader;
        this.spritePrefabXmlReader = spritePrefabXmlReader;
        this.levelSequenceXmlReader = levelSequenceXmlReader;
    }

    public CampaignPrefab readCampaignPrefab(FileHandle fileHandle) {
        try {
            XmlReader.Element element = xmlReader.parse(fileHandle);
            return new CampaignPrefab(
                    readSpritePrefab(element),
                    readLevelSequence(element)
            );
        } catch (Exception e) {
            throw new CampaignPrefabXmlReadException(fileHandle, e);
        }
    }

    private SpritePrefab readSpritePrefab(XmlReader.Element element) {
        return spritePrefabXmlReader.readSpritePrefab(
                element.getChildByName(SpritePrefabXmlReader.SPRITE_ELEMENT)
        );
    }

    private LevelSequence readLevelSequence(XmlReader.Element element) {
        return levelSequenceXmlReader.readLevelSequence(
                element.getChildByName(LevelSequenceXmlReader.LEVEL_SEQUENCE_ELEMENT)
        );
    }
}
