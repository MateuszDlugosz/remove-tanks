package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class CloudRenderLayerComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"CloudRenderLayerComponent\" />";

    private XmlReader xmlReader;
    private CloudRenderLayerComponentPrefabXmlReader cloudRenderLayerComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        cloudRenderLayerComponentPrefabXmlReader = new CloudRenderLayerComponentPrefabXmlReader();
    }

    @Test
    public void Should_BeEqual_When_ReadsTwoDifferentComponents() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        CloudRenderLayerComponentPrefab prefab0
                = cloudRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);
        CloudRenderLayerComponentPrefab prefab1
                = cloudRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);

        assertTrue(prefab0 == prefab1);
    }

    @Test
    public void Should_ReturnCloudRenderLayerComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);

        assertNotNull(cloudRenderLayerComponentPrefabXmlReader.readComponentPrefab(element));
    }
}