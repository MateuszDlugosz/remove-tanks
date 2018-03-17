package remove.tanks.game.level.engine.entity;

import com.badlogic.gdx.maps.MapObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class EntityPrefabCodeMapObjectReaderTest {
    private EntityPrefabCodeMapObjectReader entityPrefabCodeMapObjectReader;

    @Before
    public void initTestObjects() {
        entityPrefabCodeMapObjectReader = new EntityPrefabCodeMapObjectReader();
    }

    @Test
    public void Should_ReturnPrefabCode() {
        MapObject mapObject = new MapObject();
        mapObject.getProperties().put(EntityPrefabCodeMapObjectReader.PREFAB_CODE_PROPERTY, "TestCode");

        assertEquals("TestCode", entityPrefabCodeMapObjectReader.readEntityPrefabCode(mapObject));
    }
}