package remove.tanks.game.utility.surface.position;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class PositionPrefabMapObjectReaderTest {
    private static final String X_PROPERTY_KEY = "x";
    private static final String Y_PROPERTY_KEY = "y";

    private PositionPrefabMapObjectReader positionPrefabMapObjectReader;

    @Before
    public void initTestObjects() {
        positionPrefabMapObjectReader = new PositionPrefabMapObjectReader();
    }

    @Test
    public void Should_ReturnPositionPrefab_When_GivenRectangleMapObject() {
        final float X = 10;
        final float Y = 20;
        final float WIDTH = 200;
        final float HEIGHT = 150;

        MapObject mapObject = new RectangleMapObject(X, Y, WIDTH, HEIGHT);
        mapObject.getProperties().put(X_PROPERTY_KEY, X);
        mapObject.getProperties().put(Y_PROPERTY_KEY, Y);
        PositionPrefab prefab = positionPrefabMapObjectReader.readPositionPrefab(mapObject);

        assertEquals(X + WIDTH * 0.5f, prefab.getX(), 0.0001f);
        assertEquals(Y + HEIGHT * 0.5f, prefab.getY(), 0.0001f);
    }

    @Test
    public void Should_ReturnPositionPrefab_When_GivenEllipseMapObject() {
        final float X = 10;
        final float Y = 20;
        final float WIDTH = 200;
        final float HEIGHT = 150;

        MapObject mapObject = new EllipseMapObject(X, Y, WIDTH, HEIGHT);
        mapObject.getProperties().put(X_PROPERTY_KEY, X);
        mapObject.getProperties().put(Y_PROPERTY_KEY, Y);
        PositionPrefab prefab = positionPrefabMapObjectReader.readPositionPrefab(mapObject);

        assertEquals(X + WIDTH * 0.5f, prefab.getX(), 0.0001f);
        assertEquals(Y + HEIGHT * 0.5f, prefab.getY(), 0.0001f);
    }

    @Test
    public void Should_ReturnPositionPrefab_When_GivenPolygonOrPolylineMapObject() {
        MapObject polygon = new PolygonMapObject(new float[] {0, 2, 10, 2, 4, 6});
        MapObject polyline = new PolylineMapObject(new float[] {0, 2, 10, 2});

        PositionPrefab polygonPositionPrefab = positionPrefabMapObjectReader.readPositionPrefab(polygon);
        PositionPrefab polylinePositionPrefab = positionPrefabMapObjectReader.readPositionPrefab(polyline);

        assertEquals(0, polygonPositionPrefab.getX(), 0.0001f);
        assertEquals(0, polygonPositionPrefab.getY(), 0.0001f);
        assertEquals(0, polylinePositionPrefab.getX(), 0.0001f);
        assertEquals(0, polylinePositionPrefab.getY(), 0.0001f);
    }

    @Test
    public void Should_ReturnPositionPrefabs_When_GivenListOfAllTypesMapObjects() {
        final float X = 10;
        final float Y = 20;
        final float WIDTH = 200;
        final float HEIGHT = 150;

        RectangleMapObject rectangleMapObject = new RectangleMapObject(X, Y, WIDTH, HEIGHT);
        rectangleMapObject.getProperties().put(X_PROPERTY_KEY, X);
        rectangleMapObject.getProperties().put(Y_PROPERTY_KEY, Y);

        EllipseMapObject ellipseMapObject = new EllipseMapObject(X, Y, WIDTH, HEIGHT);
        ellipseMapObject.getProperties().put(X_PROPERTY_KEY, X);
        ellipseMapObject.getProperties().put(Y_PROPERTY_KEY, Y);

        List<MapObject> mapObjects = new ArrayList<>();
        mapObjects.add(new PolygonMapObject(new float[] {0, 2, 10, 2, 4, 6}));
        mapObjects.add(new PolylineMapObject(new float[] {0, 2, 10, 2}));
        mapObjects.add(ellipseMapObject);
        mapObjects.add(rectangleMapObject);

        List<PositionPrefab> prefabs = positionPrefabMapObjectReader.readPositionPrefabs(mapObjects);

        assertEquals(0, prefabs.get(0).getX(), 0.001f);
        assertEquals(0, prefabs.get(0).getY(), 0.001f);

        assertEquals(0, prefabs.get(1).getX(), 0.001f);
        assertEquals(0, prefabs.get(1).getY(), 0.001f);

        assertEquals(X + WIDTH * 0.5f, prefabs.get(2).getX(), 0.0001f);
        assertEquals(Y + HEIGHT * 0.5f, prefabs.get(2).getY(), 0.0001f);

        assertEquals(X + WIDTH * 0.5f, prefabs.get(3).getX(), 0.0001f);
        assertEquals(Y + HEIGHT * 0.5f, prefabs.get(3).getY(), 0.0001f);
    }

    @Test(expected = PositionPrefabMapObjectReadException.class)
    public void Should_ThrowException_When_GivenIncorrectRectangleMapObject() {
        MapObject mapObject = new RectangleMapObject(10, 20, 2, 4);
        positionPrefabMapObjectReader.readPositionPrefab(mapObject);
    }

    @Test(expected = PositionPrefabMapObjectReadException.class)
    public void Should_ThrowException_When_GivenIncorrectEllipseMapObject() {
        MapObject mapObject = new EllipseMapObject(10, 20, 2, 4);
        positionPrefabMapObjectReader.readPositionPrefab(mapObject);
    }

    @Test
    public void Should_ThrowException_When_GivenUnknownMapObject() {
        MapObject mapObject = new UnknownMapObject();
        positionPrefabMapObjectReader.readPositionPrefab(mapObject);
    }

    private class UnknownMapObject extends MapObject {}
}