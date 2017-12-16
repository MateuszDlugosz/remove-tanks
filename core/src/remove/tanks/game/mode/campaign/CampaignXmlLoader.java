package remove.tanks.game.mode.campaign;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.level.LevelSequenceXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class CampaignXmlLoader {
    private static final String TITLE_ELEMENT = "title";

    private final XmlReader xmlReader;
    private final LevelSequenceXmlLoader levelSequenceXmlLoader;

    public CampaignXmlLoader(
            XmlReader xmlReader,
            LevelSequenceXmlLoader levelSequenceXmlLoader
    ) {
        this.xmlReader = xmlReader;
        this.levelSequenceXmlLoader = levelSequenceXmlLoader;
    }

    public Campaign loadCampaign(String filename) {
        try {
            XmlReader.Element element = xmlReader.parse(Gdx.files.internal(filename));
            return new Campaign(
                    loadTitle(element),
                    loadLevelSequence(element)
            );
        } catch (Exception e) {
            throw new CampaignXmlLoadException(filename, e);
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
