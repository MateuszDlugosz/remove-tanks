package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class ExplosionRenderLayerComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"ExplosionRenderLayerComponent\" />";

    private XmlReader xmlReader;
    private ExplosionRenderLayerComponentPrefabXmlReader explosionRenderLayerComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        explosionRenderLayerComponentPrefabXmlReader = new ExplosionRenderLayerComponentPrefabXmlReader();
    }

    @Test
    public void Should_BeEqual_When_ReadsTwoDifferentComponents() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        ExplosionRenderLayerComponentPrefab prefab0
                = explosionRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);
        ExplosionRenderLayerComponentPrefab prefab1
                = explosionRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);

        assertTrue(prefab0 == prefab1);
    }

    @Test
    public void Should_ReturnExplosionRenderLayerComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);

        assertNotNull(explosionRenderLayerComponentPrefabXmlReader.readComponentPrefab(element));
    }
}