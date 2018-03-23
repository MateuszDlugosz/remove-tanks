package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class AirplaneRenderLayerComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"AirplaneRenderLayerComponent\" />";

    private XmlReader xmlReader;
    private AirplaneRenderLayerComponentPrefabXmlReader airplaneRenderLayerComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        airplaneRenderLayerComponentPrefabXmlReader = new AirplaneRenderLayerComponentPrefabXmlReader();
    }

    @Test
    public void Should_BeEqual_When_ReadsTwoDifferentComponents() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        AirplaneRenderLayerComponentPrefab prefab0
                = airplaneRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);
        AirplaneRenderLayerComponentPrefab prefab1
                = airplaneRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);

        assertTrue(prefab0 == prefab1);
    }

    @Test
    public void Should_ReturnAirplaneRenderLayerComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);

        assertNotNull(airplaneRenderLayerComponentPrefabXmlReader.readComponentPrefab(element));
    }
}