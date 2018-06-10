package remove.tanks.game.level.mode.arena;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.sprite.SpritePrefab;
import remove.tanks.game.graphics.sprite.SpritePrefabXmlReader;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.level.LevelSequenceXmlReader;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ArenaPrefabXmlReader {
    private static final String TITLE_ELEMENT = "title";

    private final XmlReader xmlReader;
    private final LevelSequenceXmlReader levelSequenceXmlReader;

    public ArenaPrefabXmlReader(
            XmlReader xmlReader,
            LevelSequenceXmlReader levelSequenceXmlReader
    ) {
        this.xmlReader = xmlReader;
        this.levelSequenceXmlReader = levelSequenceXmlReader;
    }

    public List<ArenaPrefab> readArenaPrefabs(List<FileHandle> fileHandles) {
        return fileHandles.stream()
                .map(this::readArenaPrefab)
                .collect(Collectors.toList());
    }

    public ArenaPrefab readArenaPrefab(FileHandle fileHandle) {
        try {
            XmlReader.Element element = xmlReader.parse(fileHandle);
            return new ArenaPrefab(
                    readTitle(element),
                    readLevelSequence(element)
            );
        } catch (Exception e) {
            throw new ArenaPrefabXmlReadException(fileHandle, e);
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
