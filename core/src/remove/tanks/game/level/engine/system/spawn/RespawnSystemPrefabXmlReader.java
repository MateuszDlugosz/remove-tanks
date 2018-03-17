package remove.tanks.game.level.engine.system.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.EntityPrefabCodeXmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class RespawnSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<RespawnSystemPrefab> {
    private static final String RESPAWN_TIME_ELEMENT = "respawnTime";

    private final EntityPrefabCodeXmlReader entityPrefabCodeXmlReader;

    public RespawnSystemPrefabXmlReader(EntityPrefabCodeXmlReader entityPrefabCodeXmlReader) {
        this.entityPrefabCodeXmlReader = entityPrefabCodeXmlReader;
    }

    @Override
    public RespawnSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new RespawnSystemPrefab(
                    priority,
                    readEntityPrefabCode(element),
                    readRespawnTime(element)
            );
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    private String readEntityPrefabCode(XmlReader.Element element) {
        return entityPrefabCodeXmlReader.readEntityPrefabCode(
                element.getChildByName(EntityPrefabCodeXmlReader.ENTITY_PREFAB_CODE_ELEMENT));
    }

    private float readRespawnTime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(RESPAWN_TIME_ELEMENT).getText().trim());
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.RespawnSystem;
    }
}
