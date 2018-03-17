package remove.tanks.game.profile.achievement;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.sprite.SpritePrefab;
import remove.tanks.game.graphics.sprite.SpritePrefabXmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AchievementPrefabXmlReader {
    public static final String ACHIEVEMENT_ELEMENT = "achievement";
    public static final String ACHIEVEMENTS_ELEMENT = "achievements";

    private final AchievementTypeXmlReader achievementTypeXmlReader;
    private final SpritePrefabXmlReader spritePrefabXmlReader;

    public AchievementPrefabXmlReader(
            AchievementTypeXmlReader achievementTypeXmlReader,
            SpritePrefabXmlReader spritePrefabXmlReader
    ) {
        this.achievementTypeXmlReader = achievementTypeXmlReader;
        this.spritePrefabXmlReader = spritePrefabXmlReader;
    }

    public List<AchievementPrefab> readAchievementPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(ACHIEVEMENT_ELEMENT).toArray())
                .map(this::readAchievementPrefab)
                .collect(Collectors.toList());
    }

    public AchievementPrefab readAchievementPrefab(XmlReader.Element element) {
        try {
             return new AchievementPrefab(
                     readAchievementType(element),
                     readSpritePrefab(element)
             );
        } catch (Exception e) {
            throw new AchievementPrefabXmlReadException(element, e);
        }
    }

    private AchievementType readAchievementType(XmlReader.Element element) {
        return achievementTypeXmlReader.readAchievementType(
                element.getChildByName(AchievementTypeXmlReader.ACHIEVEMENT_TYPE_ELEMENT));
    }

    private SpritePrefab readSpritePrefab(XmlReader.Element element) {
        return spritePrefabXmlReader.readSpritePrefab(
                element.getChildByName(SpritePrefabXmlReader.SPRITE_ELEMENT));
    }
}
