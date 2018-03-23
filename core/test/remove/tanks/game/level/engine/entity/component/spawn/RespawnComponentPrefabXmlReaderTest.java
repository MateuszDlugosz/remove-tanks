package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class RespawnComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"RespawnComponent\" />";

    private XmlReader xmlReader;
    private RespawnComponentPrefabXmlReader respawnRenderLayerComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        respawnRenderLayerComponentPrefabXmlReader = new RespawnComponentPrefabXmlReader();
    }

    @Test
    public void Should_BeEqual_When_ReadsTwoDifferentComponents() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        RespawnComponentPrefab prefab0
                = respawnRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);
        RespawnComponentPrefab prefab1
                = respawnRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);

        assertTrue(prefab0 == prefab1);
    }

    @Test
    public void Should_ReturnRespawnComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);

        assertNotNull(respawnRenderLayerComponentPrefabXmlReader.readComponentPrefab(element));
    }
}