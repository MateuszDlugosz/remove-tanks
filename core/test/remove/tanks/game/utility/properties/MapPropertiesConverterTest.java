package remove.tanks.game.utility.properties;

import com.badlogic.gdx.maps.MapProperties;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class MapPropertiesConverterTest {
    private MapPropertiesConverter mapPropertiesConverter;

    @Before
    public void initTestObjects() {
        mapPropertiesConverter = new MapPropertiesConverter();
    }

    @Test
    public void Should_ReturnProperties_When_GivenMapProperties() {
        MapProperties mapProperties = new MapProperties();
        mapProperties.put("prop-0", "val-0");
        mapProperties.put("prop-1", "val-1");
        mapProperties.put("prop-2", "val-2");
        Properties properties = mapPropertiesConverter.convertProperties(mapProperties);

        assertEquals("val-0", properties.getString("prop-0"));
        assertEquals("val-1", properties.getString("prop-1"));
        assertEquals("val-2", properties.getString("prop-2"));
    }
}
