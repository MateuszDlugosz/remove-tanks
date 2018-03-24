package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class BombRenderLayerComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"BombRenderLayerComponent\" />";

    private XmlReader xmlReader;
    private BombRenderLayerComponentPrefabXmlReader bombRenderLayerComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        bombRenderLayerComponentPrefabXmlReader = new BombRenderLayerComponentPrefabXmlReader();
    }

    @Test
    public void Should_BeEqual_When_ReadsTwoDifferentComponents() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        BombRenderLayerComponentPrefab prefab0
                = bombRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);
        BombRenderLayerComponentPrefab prefab1
                = bombRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);

        assertTrue(prefab0 == prefab1);
    }

    @Test
    public void Should_ReturnBombRenderLayerComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);

        assertNotNull(bombRenderLayerComponentPrefabXmlReader.readComponentPrefab(element));
    }
}