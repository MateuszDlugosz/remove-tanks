package remove.tanks.game.utility.position;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;

/**
 * @author Mateusz Długosz
 */
public final class PositionPrototypeMapObjectLoader {
    private static final String X_PROPERTY_KEY = "x";
    private static final String Y_PROPERTY_KEY = "y";

    public PositionPrototype loadPositionPrototype(MapObject mapObject) {
        try {
            if (mapObject instanceof RectangleMapObject) {
                return new PositionPrototype(
                        mapObject.getProperties().get(X_PROPERTY_KEY, Float.class)
                                + ((RectangleMapObject) mapObject).getRectangle().getWidth() * 0.5f,
                        mapObject.getProperties().get(Y_PROPERTY_KEY, Float.class)
                                + ((RectangleMapObject) mapObject).getRectangle().getHeight() * 0.5f
                );
            }

            if (mapObject instanceof EllipseMapObject) {
                return new PositionPrototype(
                        mapObject.getProperties().get(X_PROPERTY_KEY, Float.class)
                                + ((EllipseMapObject) mapObject).getEllipse().width * 0.5f,
                        mapObject.getProperties().get(Y_PROPERTY_KEY, Float.class)
                                + ((EllipseMapObject) mapObject).getEllipse().height * 0.5f
                );
            }

            return new PositionPrototype(0, 0);
        } catch (Exception e) {
            throw new PositionPrototypeMapObjectLoadException(mapObject, e);
        }
    }
}
