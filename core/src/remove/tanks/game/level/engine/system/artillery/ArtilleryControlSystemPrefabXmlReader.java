package remove.tanks.game.level.engine.system.artillery;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.EntityPrefabCodeXmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ArtilleryControlSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<ArtilleryControlSystemPrefab> {
    private static final String FREQUENCY_ELEMENT = "frequency";

    private final EntityPrefabCodeXmlReader entityPrefabCodeXmlReader;

    public ArtilleryControlSystemPrefabXmlReader(EntityPrefabCodeXmlReader entityPrefabCodeXmlReader) {
        this.entityPrefabCodeXmlReader = entityPrefabCodeXmlReader;
    }

    @Override
    public ArtilleryControlSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new ArtilleryControlSystemPrefab(
                    priority,
                    readFrequency(element),
                    readEntityPrefabCodes(element)
            );
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    private float readFrequency(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(FREQUENCY_ELEMENT).getText().trim());
    }

    private List<String> readEntityPrefabCodes(XmlReader.Element element) {
        return entityPrefabCodeXmlReader.readEntityPrefabCodes(
                element.getChildByName(EntityPrefabCodeXmlReader.ENTITY_PREFAB_CODES_ELEMENT)
        );
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.ArtilleryControlSystem;
    }
}
