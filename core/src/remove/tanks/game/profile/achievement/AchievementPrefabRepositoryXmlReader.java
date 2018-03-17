package remove.tanks.game.profile.achievement;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AchievementPrefabRepositoryXmlReader {
    private final XmlReader xmlReader;
    private final AchievementPrefabXmlReader achievementPrefabXmlReader;

    public AchievementPrefabRepositoryXmlReader(
            XmlReader xmlReader,
            AchievementPrefabXmlReader achievementPrefabXmlReader
    ) {
        this.xmlReader = xmlReader;
        this.achievementPrefabXmlReader = achievementPrefabXmlReader;
    }

    public AchievementPrefabRepository readAchievementPrefabRepository(FileHandle fileHandle) {
        try {
            return new AchievementPrefabRepository(readAchievementPrefabs(xmlReader.parse(fileHandle)));
        } catch (Exception e) {
            throw new AchievementPrefabRepositoryXmlReadException(fileHandle.path(), e);
        }
    }

    private Map<AchievementType, AchievementPrefab> readAchievementPrefabs(XmlReader.Element element) {
        return achievementPrefabXmlReader.readAchievementPrefabs(element).stream()
                .collect(Collectors.toMap(
                        AchievementPrefab::getAchievementType,
                        p -> p
                ));
    }
}
