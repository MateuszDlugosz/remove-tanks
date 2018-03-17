package remove.tanks.game.utility.surface.position;

import com.badlogic.gdx.maps.MapObject;

/**
 * @author Mateusz Długosz
 */
public final class PositionPrefabMapObjectReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read position prefab from map object %s.";

    public PositionPrefabMapObjectReadException(MapObject mapObject, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, mapObject), cause);
    }
}