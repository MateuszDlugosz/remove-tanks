package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.EntityPrefabCodeXmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneSpawnerComponentPrefabXmlReader implements SubComponentPrefabXmlReader<AirplaneSpawnerComponentPrefab> {
    private final EntityPrefabCodeXmlReader entityPrefabCodeXmlReader;

    public AirplaneSpawnerComponentPrefabXmlReader(EntityPrefabCodeXmlReader entityPrefabCodeXmlReader) {
        this.entityPrefabCodeXmlReader = entityPrefabCodeXmlReader;
    }

    @Override
    public AirplaneSpawnerComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new AirplaneSpawnerComponentPrefab(readEntityPrefabCode(element));
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private String readEntityPrefabCode(XmlReader.Element element) {
        return entityPrefabCodeXmlReader.readEntityPrefabCode(
                element.getChildByName(EntityPrefabCodeXmlReader.ENTITY_PREFAB_CODE_ELEMENT));
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.AirplaneSpawnerComponent;
    }
}
