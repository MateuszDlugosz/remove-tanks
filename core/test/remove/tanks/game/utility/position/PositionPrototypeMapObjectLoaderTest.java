package remove.tanks.game.utility.position;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class PositionPrototypeMapObjectLoaderTest {
    private static final String X_PROPERTY_KEY = "x";
    private static final String Y_PROPERTY_KEY = "y";

    private PositionPrototypeMapObjectLoader positionPrototypeMapObjectLoader;

    @Before
    public void initTestObjects() {
        positionPrototypeMapObjectLoader = new PositionPrototypeMapObjectLoader();
    }

    @Test
    public void when_RectangleMapObjectIsPassed_Then_CreateCorrectPosition() {
        final float X = 10;
        final float Y = 20;
        final float WIDTH = 200;
        final float HEIGHT = 150;

        MapObject mapObject = new RectangleMapObject(X, Y, WIDTH, HEIGHT);
        mapObject.getProperties().put(X_PROPERTY_KEY, X);
        mapObject.getProperties().put(Y_PROPERTY_KEY, Y);
        PositionPrototype prototype = positionPrototypeMapObjectLoader.loadPositionPrototype(mapObject);

        assertEquals(X + WIDTH * 0.5f, prototype.getX(), 0.0001f);
        assertEquals(Y + HEIGHT * 0.5f, prototype.getY(), 0.0001f);
    }

    @Test
    public void when_EllipseMapObjectIsPassed_Then_CreateCorrectPosition() {
        final float X = 10;
        final float Y = 20;
        final float WIDTH = 200;
        final float HEIGHT = 150;

        MapObject mapObject = new EllipseMapObject(X, Y, WIDTH, HEIGHT);
        mapObject.getProperties().put(X_PROPERTY_KEY, X);
        mapObject.getProperties().put(Y_PROPERTY_KEY, Y);
        PositionPrototype prototype = positionPrototypeMapObjectLoader.loadPositionPrototype(mapObject);

        assertEquals(X + WIDTH * 0.5f, prototype.getX(), 0.0001f);
        assertEquals(Y + HEIGHT * 0.5f, prototype.getY(), 0.0001f);
    }

    @Test
    public void when_NotEllipseOrRectangleMapObjectIsPassed_Then_CreateZeroPosition() {
        MapObject polygon = new PolygonMapObject(new float[] {0, 2, 10, 2, 4, 6});
        MapObject polyline = new PolylineMapObject(new float[] {0, 2, 10, 2});

        PositionPrototype polygonPositionPrototype = positionPrototypeMapObjectLoader.loadPositionPrototype(polygon);
        PositionPrototype polylinePositionPrototype = positionPrototypeMapObjectLoader.loadPositionPrototype(polyline);

        assertEquals(0, polygonPositionPrototype.getX(), 0.0001f);
        assertEquals(0, polygonPositionPrototype.getY(), 0.0001f);
        assertEquals(0, polylinePositionPrototype.getX(), 0.0001f);
        assertEquals(0, polylinePositionPrototype.getY(), 0.0001f);
    }

    @Test(expected = PositionPrototypeMapObjectLoadException.class)
    public void when_IncorrectRectangleMapObjectIsPassed_then_ThrowsException() {
        MapObject mapObject = new RectangleMapObject(10, 20, 2, 4);
        PositionPrototype prototype = positionPrototypeMapObjectLoader.loadPositionPrototype(mapObject);
    }

    @Test(expected = PositionPrototypeMapObjectLoadException.class)
    public void when_IncorrectEllipseMapObjectIsPassed_then_ThrowsException() {
        MapObject mapObject = new EllipseMapObject(10, 20, 2, 4);
        PositionPrototype prototype = positionPrototypeMapObjectLoader.loadPositionPrototype(mapObject);
    }
}