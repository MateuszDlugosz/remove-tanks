package remove.tanks.game.utility.position;

import com.badlogic.gdx.maps.MapObject;

/**
 * @author Mateusz Długosz
 */
public final class PositionPrototypeMapObjectLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load position prototype from map object %s.";

    public PositionPrototypeMapObjectLoadException(MapObject mapObject, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, mapObject), cause);
    }
}
