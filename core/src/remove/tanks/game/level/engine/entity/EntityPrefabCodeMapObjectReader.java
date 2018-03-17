package remove.tanks.game.level.engine.entity;

import com.badlogic.gdx.maps.MapObject;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabCodeMapObjectReader {
    public static final String PREFAB_CODE_PROPERTY = "prefab.code";

    public String readEntityPrefabCode(MapObject mapObject) {
        try {
            return mapObject.getProperties().get(PREFAB_CODE_PROPERTY, String.class).trim();
        } catch (Exception e) {
            throw new EntityPrefabCodeMapObjectReadException(mapObject, e);
        }
    }
}
