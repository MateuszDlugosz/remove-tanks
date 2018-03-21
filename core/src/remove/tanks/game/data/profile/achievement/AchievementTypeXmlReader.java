package remove.tanks.game.data.profile.achievement;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AchievementTypeXmlReader {
    public static final String ACHIEVEMENT_TYPE_ELEMENT = "achievementType";
    public static final String ACHIEVEMENT_TYPES_ELEMENT = "achievementTypes";

    public Set<AchievementType> readAchievementTypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(ACHIEVEMENT_TYPE_ELEMENT).toArray())
                .map(this::readAchievementType)
                .collect(Collectors.toSet());
    }

    public AchievementType readAchievementType(XmlReader.Element element) {
        try {
            return AchievementType.valueOf(element.getText().trim());
        } catch (Exception e) {
            throw new AchievementTypeXmlReadException(element, e);
        }
    }
}
