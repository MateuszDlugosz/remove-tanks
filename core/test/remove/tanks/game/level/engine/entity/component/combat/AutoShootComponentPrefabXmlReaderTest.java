package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class AutoShootComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"AutoShootComponent\" />";

    private XmlReader xmlReader;
    private AutoShootComponentPrefabXmlReader autoShootComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        autoShootComponentPrefabXmlReader = new AutoShootComponentPrefabXmlReader();
    }

    @Test
    public void Should_BeEqual_When_ReadsTwoDifferentComponents() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        AutoShootComponentPrefab prefab0 = autoShootComponentPrefabXmlReader.readComponentPrefab(element);
        AutoShootComponentPrefab prefab1 = autoShootComponentPrefabXmlReader.readComponentPrefab(element);

        assertTrue(prefab0 == prefab1);
    }

    @Test
    public void Should_ReturnAutoShootComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);

        assertNotNull(autoShootComponentPrefabXmlReader.readComponentPrefab(element));
    }
}
