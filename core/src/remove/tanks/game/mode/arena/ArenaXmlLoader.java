package remove.tanks.game.mode.arena;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.level.LevelSequenceXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ArenaXmlLoader {
    private static final String TITLE_ELEMENT = "title";

    private final XmlReader xmlReader;
    private final LevelSequenceXmlLoader levelSequenceXmlLoader;

    public ArenaXmlLoader(
            XmlReader xmlReader,
            LevelSequenceXmlLoader levelSequenceXmlLoader
    ) {
        this.xmlReader = xmlReader;
        this.levelSequenceXmlLoader = levelSequenceXmlLoader;
    }

    public Arena loadArena(String filename) {
        try {
            XmlReader.Element element = xmlReader.parse(Gdx.files.internal(filename));
            return new Arena(
                    loadTitle(element),
                    loadLevelSequence(element)
            );
        } catch (Exception e) {
            throw new ArenaXmlLoadException(filename, e);
        }
    }

    private String loadTitle(XmlReader.Element element) {
        return element.getChildByName(TITLE_ELEMENT).getText().trim();
    }

    private LevelSequence loadLevelSequence(XmlReader.Element element) {
        return levelSequenceXmlLoader.loadLevelSequence(
                element.getChildByName(LevelSequenceXmlLoader.LEVEL_SEQUENCE_ELEMENT)
        );
    }
}
