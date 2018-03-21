package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class SpeedModifierComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT =
            "<component type=\"SpeedModifierComponent\">" +
                    "<speedModifier>0.1</speed>" +
            "</component>";

    private static final String COMPONENT_INCORRECT_ELEMENT =
            "<component type=\"SpeedComponent\">" +
            "</component>";

    private XmlReader xmlReader;
    private SpeedModifierComponentPrefabXmlReader speedModifierComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        speedModifierComponentPrefabXmlReader = new SpeedModifierComponentPrefabXmlReader();
    }

    @Test
    public void Should_ReturnSpeedModifierComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        SpeedModifierComponentPrefab prefab = speedModifierComponentPrefabXmlReader.readComponentPrefab(element);

        assertEquals(0.1f, prefab.getSpeedModifier(), 0.001f);
    }

    @Test(expected = ComponentPrefabXmlReadException.class)
    public void Should_ThrowException_When_ElementIsIncorrectlyFormatted() {
        speedModifierComponentPrefabXmlReader.readComponentPrefab(xmlReader.parse(COMPONENT_INCORRECT_ELEMENT));
    }
}