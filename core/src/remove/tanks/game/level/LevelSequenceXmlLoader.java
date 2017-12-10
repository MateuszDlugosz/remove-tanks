package remove.tanks.game.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class LevelSequenceXmlLoader {
    private static final String LEVEL_PROTOTYPE_FILENAME_ELEMENT = "levelPrototypeFilename";

    private final XmlReader xmlReader;

    public LevelSequenceXmlLoader(XmlReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    public LevelSequence loadCampaign(String filename) {
        try {
            XmlReader.Element element = xmlReader.parse(Gdx.files.internal(filename));
            return new LevelSequence(
                    Arrays.stream(element.getChildrenByName(LEVEL_PROTOTYPE_FILENAME_ELEMENT).toArray())
                            .map(e -> e.getText().trim())
                            .collect(Collectors.toList())
            );
        } catch (Exception e) {
            throw new LevelSequenceXmlLoadException(filename, e);
        }
    }
}
