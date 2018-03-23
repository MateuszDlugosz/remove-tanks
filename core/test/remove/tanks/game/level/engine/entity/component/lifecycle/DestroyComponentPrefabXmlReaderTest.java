package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class DestroyComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"DestroyComponent\" />";

    private XmlReader xmlReader;
    private DestroyComponentPrefabXmlReader destroyComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        destroyComponentPrefabXmlReader = new DestroyComponentPrefabXmlReader();
    }

    @Test
    public void Should_BeEqual_When_ReadsTwoDifferentComponents() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        DestroyComponentPrefab prefab0 = destroyComponentPrefabXmlReader.readComponentPrefab(element);
        DestroyComponentPrefab prefab1 = destroyComponentPrefabXmlReader.readComponentPrefab(element);

        assertTrue(prefab0 == prefab1);
    }

    @Test
    public void Should_ReturnDestroyComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);

        assertNotNull(destroyComponentPrefabXmlReader.readComponentPrefab(element));
    }
}