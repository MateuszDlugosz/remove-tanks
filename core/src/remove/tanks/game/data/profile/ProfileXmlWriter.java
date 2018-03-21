package remove.tanks.game.data.profile;

import com.badlogic.gdx.utils.XmlWriter;
import remove.tanks.game.data.profile.achievement.AchievementType;
import remove.tanks.game.data.profile.achievement.AchievementTypeXmlWriter;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.properties.PropertiesXmlWriter;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Set;

/**
 * @author Mateusz Długosz
 */
public final class ProfileXmlWriter {
    private static final String PROFILE_ELEMENT = "profile";

    private final PropertiesXmlWriter propertiesXmlWriter;
    private final AchievementTypeXmlWriter achievementTypeXmlWriter;

    public ProfileXmlWriter(
            PropertiesXmlWriter propertiesXmlWriter,
            AchievementTypeXmlWriter achievementTypeXmlWriter
    ) {
        this.propertiesXmlWriter = propertiesXmlWriter;
        this.achievementTypeXmlWriter = achievementTypeXmlWriter;
    }

    public String writeProfile(Profile profile) {
        try {
            StringWriter stringWriter = new StringWriter();
            XmlWriter xmlWriter = new XmlWriter(stringWriter);

            xmlWriter.text("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            xmlWriter.element(PROFILE_ELEMENT);
            xmlWriter.text(writeProperties(profile.getProperties()));
            xmlWriter.text(writeAchievementTypes(profile.getAchievementTypes()));
            xmlWriter.pop();

            xmlWriter.close();

            return stringWriter.toString();
        } catch (Exception e) {
            throw new ProfileXmlWriteException(e);
        }
    }

    private String writeProperties(Properties properties) {
        return propertiesXmlWriter.writeProperties(properties);
    }

    private String writeAchievementTypes(Set<AchievementType> achievementTypes) {
        return achievementTypeXmlWriter.writeAchievementTypes(new ArrayList<>(achievementTypes));
    }
}
