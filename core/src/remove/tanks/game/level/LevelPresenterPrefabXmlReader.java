package remove.tanks.game.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class LevelPresenterPrefabXmlReader {
    private static final String PRESENTATION_TIME_ELEMENT = "presentationTime";

    private final XmlReader xmlReader;
    private final LevelSequenceXmlReader levelSequenceXmlReader;
    private final LevelPrefabXmlReader levelPrefabXmlReader;

    public LevelPresenterPrefabXmlReader(
            XmlReader xmlReader,
            LevelSequenceXmlReader levelSequenceXmlReader,
            LevelPrefabXmlReader levelPrefabXmlReader
    ) {
        this.xmlReader = xmlReader;
        this.levelSequenceXmlReader = levelSequenceXmlReader;
        this.levelPrefabXmlReader = levelPrefabXmlReader;
    }

    public LevelPresenterPrefab readLevelPresenterPrefab(String filename) {
        try {
            XmlReader.Element element = xmlReader.parse(Gdx.files.internal(filename));
            return new LevelPresenterPrefab(
                    readLevelPrefabs(element),
                    readPresentationTime(element)
            );
        } catch (Exception e) {
            throw new LevelPresenterPrefabXmlReadException(filename, e);
        }
    }

    private List<LevelPrefab> readLevelPrefabs(XmlReader.Element element) {
        return levelPrefabXmlReader.readLevelPrefabs(levelSequenceXmlReader.readLevelSequence(element.getChildByName(
                LevelSequenceXmlReader.LEVEL_SEQUENCE_ELEMENT)).getLevelPrefabFilenames().stream()
                .map(Gdx.files::internal)
                .collect(Collectors.toList()));
    }

    private float readPresentationTime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(PRESENTATION_TIME_ELEMENT).getText().trim());
    }
}
