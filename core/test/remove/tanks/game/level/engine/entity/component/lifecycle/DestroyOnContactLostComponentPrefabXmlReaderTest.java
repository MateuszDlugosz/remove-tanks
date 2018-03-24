package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class DestroyOnContactLostComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"DestroyOnContactLostComponent\" />";

    private XmlReader xmlReader;
    private DestroyOnContactLostComponentPrefabXmlReader destroyOnContactLostComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        destroyOnContactLostComponentPrefabXmlReader = new DestroyOnContactLostComponentPrefabXmlReader();
    }

    @Test
    public void Should_BeEqual_When_ReadsTwoDifferentComponents() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        DestroyOnContactLostComponentPrefab prefab0 = destroyOnContactLostComponentPrefabXmlReader.readComponentPrefab(element);
        DestroyOnContactLostComponentPrefab prefab1 = destroyOnContactLostComponentPrefabXmlReader.readComponentPrefab(element);

        assertTrue(prefab0 == prefab1);
    }

    @Test
    public void Should_ReturnDestroyOnContactLostComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);

        assertNotNull(destroyOnContactLostComponentPrefabXmlReader.readComponentPrefab(element));
    }
}