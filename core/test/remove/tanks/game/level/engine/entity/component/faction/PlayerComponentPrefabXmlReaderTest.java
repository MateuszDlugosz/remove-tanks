package remove.tanks.game.level.engine.entity.component.faction;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class PlayerComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"PlayerComponent\" />";

    private XmlReader xmlReader;
    private PlayerComponentPrefabXmlReader playerComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        playerComponentPrefabXmlReader = new PlayerComponentPrefabXmlReader();
    }

    @Test
    public void Should_ReturnPlayerComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        PlayerComponentPrefab prefab = playerComponentPrefabXmlReader.readComponentPrefab(element);

        assertEquals(prefab.getClass(), prefab.getClass());
    }
}