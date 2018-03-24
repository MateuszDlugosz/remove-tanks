package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class ObstacleRenderLayerComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"GroundRenderLayerComponent\" />";

    private XmlReader xmlReader;
    private GroundRenderLayerComponentPrefabXmlReader obstacleRenderLayerComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        obstacleRenderLayerComponentPrefabXmlReader = new GroundRenderLayerComponentPrefabXmlReader();
    }

    @Test
    public void Should_BeEqual_When_ReadsTwoDifferentComponents() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        GroundRenderLayerComponentPrefab prefab0
                = obstacleRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);
        GroundRenderLayerComponentPrefab prefab1
                = obstacleRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);

        assertTrue(prefab0 == prefab1);
    }

    @Test
    public void Should_ReturnGroundRenderLayerComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);

        assertNotNull(obstacleRenderLayerComponentPrefabXmlReader.readComponentPrefab(element));
    }
}