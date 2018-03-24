package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class VehicleRenderLayerComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"VehicleRenderLayerComponent\" />";

    private XmlReader xmlReader;
    private VehicleRenderLayerComponentPrefabXmlReader vehicleRenderLayerComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        vehicleRenderLayerComponentPrefabXmlReader = new VehicleRenderLayerComponentPrefabXmlReader();
    }

    @Test
    public void Should_BeEqual_When_ReadsTwoDifferentComponents() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        VehicleRenderLayerComponentPrefab prefab0
                = vehicleRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);
        VehicleRenderLayerComponentPrefab prefab1
                = vehicleRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);

        assertTrue(prefab0 == prefab1);
    }

    @Test
    public void Should_ReturnVehicleRenderLayerComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);

        assertNotNull(vehicleRenderLayerComponentPrefabXmlReader.readComponentPrefab(element));
    }
}