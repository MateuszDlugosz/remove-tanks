package remove.tanks.game.utility.properties;

import com.badlogic.gdx.maps.MapProperties;

import java.util.Iterator;

/**
 * @author Mateusz Długosz
 */
public final class MapPropertiesConverter {
    public Properties convertProperties(MapProperties mapProperties) {
        Properties properties = new Properties();
        Iterator<String> iterator = mapProperties.getKeys();
        while (iterator.hasNext()) {
            String propertyKey = iterator.next();
            properties.putString(propertyKey, String.valueOf(mapProperties.get(propertyKey)));
        }
        return properties;
    }
}
