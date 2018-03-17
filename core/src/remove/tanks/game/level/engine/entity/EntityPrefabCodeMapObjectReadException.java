package remove.tanks.game.level.engine.entity;

import com.badlogic.gdx.maps.MapObject;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabCodeMapObjectReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read entity prefab code from %s map object.";

    public EntityPrefabCodeMapObjectReadException(MapObject mapObject, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, mapObject), cause);
    }
}
