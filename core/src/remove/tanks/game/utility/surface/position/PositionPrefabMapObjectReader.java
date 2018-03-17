package remove.tanks.game.utility.surface.position;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class PositionPrefabMapObjectReader {
    private static final String X_PROPERTY_KEY = "x";
    private static final String Y_PROPERTY_KEY = "y";

    public List<PositionPrefab> readPositionPrefabs(List<MapObject> mapObjects) {
        return mapObjects.stream()
                .map(this::readPositionPrefab)
                .collect(Collectors.toList());
    }

    public PositionPrefab readPositionPrefab(MapObject mapObject) {
        try {
            if (mapObject instanceof EllipseMapObject) {
                return new PositionPrefab(
                        readXMapObjectValueFromEllipse((EllipseMapObject) mapObject),
                        readYMapObjectValueFromEllipse((EllipseMapObject) mapObject)
                );
            }

            if (mapObject instanceof RectangleMapObject) {
                return new PositionPrefab(
                        readXMapObjectValueFromRectangle((RectangleMapObject) mapObject),
                        readYMapObjectValueFromRectangle((RectangleMapObject) mapObject)
                );
            }

            return PositionPrefab.POSITION_PREFAB_ZERO;
        } catch (Exception e) {
            throw new PositionPrefabMapObjectReadException(mapObject, e);
        }
    }

    private Float readXMapObjectValueFromEllipse(EllipseMapObject mapObject) {
        return mapObject.getProperties().get(X_PROPERTY_KEY, Float.class) + mapObject.getEllipse().width * 0.5f;
    }

    private Float readYMapObjectValueFromEllipse(EllipseMapObject mapObject) {
        return mapObject.getProperties().get(Y_PROPERTY_KEY, Float.class) + mapObject.getEllipse().height * 0.5f;
    }

    private Float readXMapObjectValueFromRectangle(RectangleMapObject mapObject) {
        return mapObject.getProperties().get(X_PROPERTY_KEY, Float.class) + mapObject.getRectangle().width * 0.5f;
    }

    private Float readYMapObjectValueFromRectangle(RectangleMapObject mapObject) {
        return mapObject.getProperties().get(Y_PROPERTY_KEY, Float.class) + mapObject.getRectangle().height * 0.5f;
    }
}
