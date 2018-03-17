package remove.tanks.game.profile.achievement;

import com.badlogic.gdx.utils.XmlWriter;

import java.io.StringWriter;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class AchievementTypeXmlWriter {
    private static final String ACHIEVEMENT_TYPE_ELEMENT = "achievementType";
    private static final String ACHIEVEMENT_TYPES_ELEMENT = "achievementTypes";

    public String writeAchievementTypes(List<AchievementType> achievementTypes) {
        try {
            StringWriter stringWriter = new StringWriter();
            XmlWriter xmlWriter = new XmlWriter(stringWriter);

            xmlWriter.element(ACHIEVEMENT_TYPES_ELEMENT);

            for (AchievementType achievementType : achievementTypes) {
                xmlWriter.text(writeAchievementType(achievementType));
            }

            xmlWriter.pop();
            xmlWriter.close();

            return stringWriter.toString();
        } catch (Exception e) {
            throw new AchievementTypeXmlWriteException(e);
        }
    }

    public String writeAchievementType(AchievementType achievementType) {
        try {
            StringWriter stringWriter = new StringWriter();
            XmlWriter xmlWriter = new XmlWriter(stringWriter);

            xmlWriter.element(ACHIEVEMENT_TYPE_ELEMENT);
            xmlWriter.text(achievementType.name());
            xmlWriter.pop();
            xmlWriter.close();

            return stringWriter.toString();
        } catch (Exception e) {
            throw new AchievementTypeXmlWriteException(e);
        }
    }
}
