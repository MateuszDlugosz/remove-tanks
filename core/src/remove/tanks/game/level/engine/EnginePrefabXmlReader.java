package remove.tanks.game.level.engine;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.EntityListenerPrefab;
import remove.tanks.game.level.engine.listener.EntityListenerPrefabXmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefab;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class EnginePrefabXmlReader {
    public static final String ENGINE_ELEMENT = "engine";

    private final EntitySystemPrefabXmlReader entitySystemPrefabXmlReader;
    private final EntityListenerPrefabXmlReader entityListenerPrefabXmlReader;

    public EnginePrefabXmlReader(
            EntitySystemPrefabXmlReader entitySystemPrefabXmlReader,
            EntityListenerPrefabXmlReader entityListenerPrefabXmlReader
    ) {
        this.entitySystemPrefabXmlReader = entitySystemPrefabXmlReader;
        this.entityListenerPrefabXmlReader = entityListenerPrefabXmlReader;
    }

    public EnginePrefab readEnginePrefab(XmlReader.Element element) {
        try {
            return new EnginePrefab(
                    readEntitySystemPrefabs(element),
                    readEntityListenerPrefabs(element)
            );
        } catch (Exception e) {
            throw new EnginePrefabXmlReadException(element, e);
        }
    }

    private List<EntitySystemPrefab> readEntitySystemPrefabs(XmlReader.Element element) {
        if (element.getChildByName(EntitySystemPrefabXmlReader.SYSTEMS_ELEMENT) == null) {
            return new ArrayList<>();
        }
        return entitySystemPrefabXmlReader.readEntitySystemPrefabs(
                element.getChildByName(EntitySystemPrefabXmlReader.SYSTEMS_ELEMENT)
        );
    }

    private List<EntityListenerPrefab> readEntityListenerPrefabs(XmlReader.Element element) {
        if (element.getChildByName(EntityListenerPrefabXmlReader.LISTENERS_ELEMENT) == null) {
            return new ArrayList<>();
        }
        return entityListenerPrefabXmlReader.readEntityListenersPrefabs(
                element.getChildByName(EntityListenerPrefabXmlReader.LISTENERS_ELEMENT)
        );
    }
}
