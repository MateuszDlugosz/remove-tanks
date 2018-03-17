package remove.tanks.game.level.engine.entity.component;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.utils.XmlReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ComponentPrefabMapObjectReader {
    public static final String PREFAB_COMPONENTS_PROPERTY = "prefab.components";

    private final XmlReader xmlReader;
    private final ComponentPrefabXmlReader componentPrefabXmlReader;

    public ComponentPrefabMapObjectReader(
            XmlReader xmlReader,
            ComponentPrefabXmlReader componentPrefabXmlReader
    ) {
        this.xmlReader = xmlReader;
        this.componentPrefabXmlReader = componentPrefabXmlReader;
    }

    public List<ComponentPrefab> readComponentPrefabs(MapObject mapObject) {
        if (mapObject.getProperties().get(PREFAB_COMPONENTS_PROPERTY) == null) {
            return new ArrayList<>();
        }
        return readComponentPrefabs(mapObject.getProperties().get(PREFAB_COMPONENTS_PROPERTY, String.class).trim());
    }

    private List<ComponentPrefab> readComponentPrefabs(String prefabsXml) {
        return new ArrayList<>(componentPrefabXmlReader.readComponentsPrefabs(
                xmlReader.parse(prefabsXml.replaceAll("&lt", "<").replaceAll("&gt", ">"))
        ));
    }
}
