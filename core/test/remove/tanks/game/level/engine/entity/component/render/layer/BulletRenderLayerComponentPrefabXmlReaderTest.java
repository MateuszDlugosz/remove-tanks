package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class BulletRenderLayerComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"BulletRenderLayerComponent\" />";

    private XmlReader xmlReader;
    private BulletRenderLayerComponentPrefabXmlReader bulletRenderLayerComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        bulletRenderLayerComponentPrefabXmlReader = new BulletRenderLayerComponentPrefabXmlReader();
    }

    @Test
    public void Should_BeEqual_When_ReadsTwoDifferentComponents() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        BulletRenderLayerComponentPrefab prefab0
                = bulletRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);
        BulletRenderLayerComponentPrefab prefab1
                = bulletRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);

        assertTrue(prefab0 == prefab1);
    }

    @Test
    public void Should_ReturnBulletRenderLayerComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);

        assertNotNull(bulletRenderLayerComponentPrefabXmlReader.readComponentPrefab(element));
    }
}