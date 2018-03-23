package remove.tanks.game.level.engine.entity.component.move;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class AutoMoveComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"AutoMoveComponent\" />";

    private XmlReader xmlReader;
    private AutoMoveComponentPrefabXmlReader autoMoveComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        autoMoveComponentPrefabXmlReader = new AutoMoveComponentPrefabXmlReader();
    }

    @Test
    public void Should_BeEqual_When_ReadsTwoDifferentComponents() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        AutoMoveComponentPrefab prefab0 = autoMoveComponentPrefabXmlReader.readComponentPrefab(element);
        AutoMoveComponentPrefab prefab1 = autoMoveComponentPrefabXmlReader.readComponentPrefab(element);

        assertTrue(prefab0 == prefab1);
    }

    @Test
    public void Should_ReturnAutoMoveComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);

        assertNotNull(autoMoveComponentPrefabXmlReader.readComponentPrefab(element));
    }
}