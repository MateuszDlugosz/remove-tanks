package remove.tanks.game.data.profile;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.data.profile.achievement.AchievementType;
import remove.tanks.game.data.profile.achievement.AchievementTypeXmlReader;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.properties.PropertiesXmlReader;

import java.util.Set;

/**
 * @author Mateusz Długosz
 */
public final class ProfileXmlReader {
    private final XmlReader xmlReader;
    private final PropertiesXmlReader propertiesXmlReader;
    private final AchievementTypeXmlReader achievementTypeXmlReader;

    public ProfileXmlReader(
            XmlReader xmlReader,
            PropertiesXmlReader propertiesXmlReader,
            AchievementTypeXmlReader achievementTypeXmlReader
    ) {
        this.xmlReader = xmlReader;
        this.propertiesXmlReader = propertiesXmlReader;
        this.achievementTypeXmlReader = achievementTypeXmlReader;
    }

    public Profile readProfile(FileHandle fileHandle) {
        try {
            XmlReader.Element element = xmlReader.parse(fileHandle);
            return new Profile(
                    readProperties(element),
                    readAchievementTypes(element)
            );
        } catch (Exception e) {
            throw new ProfileXmlReadException(fileHandle.name(), e);
        }
    }

    private Properties readProperties(XmlReader.Element element) {
        return propertiesXmlReader.readProperties(
                element.getChildByName(PropertiesXmlReader.PROPERTIES_ELEMENT));
    }

    private Set<AchievementType> readAchievementTypes(XmlReader.Element element) {
        return achievementTypeXmlReader.readAchievementTypes(
                element.getChildByName(AchievementTypeXmlReader.ACHIEVEMENT_TYPES_ELEMENT));
    }
}
