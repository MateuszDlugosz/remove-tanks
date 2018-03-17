package remove.tanks.game.level.utility.spawner;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.EntityPrefabCodeXmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SpawnerPrefabXmlReader {
    public static final String SPAWNER_ELEMENT = "spawner";
    public static final String SPAWNERS_ELEMENT = "spawners";

    private static final String TIME_ELEMENT = "time";
    private static final String LIMIT_ELEMENT = "limit";
    private static final String ID_ATTRIBUTE = "id";
    private static final String AUTOSTART_ATTRIBUTE = "autoStart";

    private final EntityPrefabCodeXmlReader entityPrefabCodeXmlReader;

    public SpawnerPrefabXmlReader(EntityPrefabCodeXmlReader entityPrefabCodeXmlReader) {
        this.entityPrefabCodeXmlReader = entityPrefabCodeXmlReader;
    }

    public List<SpawnerPrefab> readSpawnerPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(SPAWNER_ELEMENT).toArray())
                .map(this::readSpawnerPrefab)
                .collect(Collectors.toList());
    }

    public SpawnerPrefab readSpawnerPrefab(XmlReader.Element element) {
        try {
            return new SpawnerPrefab(
                    readId(element),
                    readEntityPrefabCodes(element),
                    readLimit(element),
                    readTime(element),
                    readAutoStart(element)
            );
        } catch (Exception e) {
            throw new SpawnerPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE).trim();
    }

    private List<String> readEntityPrefabCodes(XmlReader.Element element) {
        return entityPrefabCodeXmlReader.readEntityPrefabCodes(
                element.getChildByName(EntityPrefabCodeXmlReader.ENTITY_PREFAB_CODES_ELEMENT));
    }

    private int readLimit(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(LIMIT_ELEMENT).getText().trim());
    }

    private float readTime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(TIME_ELEMENT).getText().trim());
    }

    private boolean readAutoStart(XmlReader.Element element) {
        return Boolean.valueOf(element.getAttribute(AUTOSTART_ATTRIBUTE).trim());
    }
}
