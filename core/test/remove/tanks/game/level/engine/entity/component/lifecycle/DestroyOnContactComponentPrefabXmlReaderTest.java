package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class DestroyOnContactComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"DestroyOnContactComponent\" />";

    private XmlReader xmlReader;
    private DestroyOnContactComponentPrefabXmlReader destroyOnContactComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        destroyOnContactComponentPrefabXmlReader = new DestroyOnContactComponentPrefabXmlReader();
    }

    @Test
    public void Should_BeEqual_When_ReadsTwoDifferentComponents() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        DestroyOnContactComponentPrefab prefab0 = destroyOnContactComponentPrefabXmlReader.readComponentPrefab(element);
        DestroyOnContactComponentPrefab prefab1 = destroyOnContactComponentPrefabXmlReader.readComponentPrefab(element);

        assertTrue(prefab0 == prefab1);
    }

    @Test
    public void Should_ReturnDestroyOnContactComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);

        assertNotNull(destroyOnContactComponentPrefabXmlReader.readComponentPrefab(element));
    }
}