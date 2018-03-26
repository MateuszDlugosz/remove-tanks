package remove.tanks.game.level.engine.entity.component.bonus;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class LeaveBonusComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT_DEFAULTS =
            "<component type=\"LeaveBonusComponent\" />";

    private static final String COMPONENT_CORRECT_ELEMENT =
            "<component type=\"LeaveBonusComponent\">" +
                    "<chanceModifier>1.5</chanceModifier>" +
            "</component>";

    private static final String COMPONENT_INCORRECT_ELEMENT =
            "<component type=\"LeaveBonusComponent\">" +
                    "<chanceModifier>incorrect_value</chanceModifier>" +
            "</component>";

    private XmlReader xmlReader;
    private LeaveBonusComponentPrefabXmlReader leaveBonusComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        leaveBonusComponentPrefabXmlReader = new LeaveBonusComponentPrefabXmlReader();
    }

    @Test
    public void Should_ReadComponentPrefabWithDefaultValue_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT_DEFAULTS);
        LeaveBonusComponentPrefab prefab = leaveBonusComponentPrefabXmlReader.readComponentPrefab(element);

        assertEquals(0, prefab.getChanceModifier(), 0.001f);
    }

    @Test
    public void Should_ReadComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        LeaveBonusComponentPrefab prefab = leaveBonusComponentPrefabXmlReader.readComponentPrefab(element);

        assertEquals(1.5f, prefab.getChanceModifier(), 0.001f);
    }

    @Test(expected = ComponentPrefabXmlReadException.class)
    public void Should_ThrowException_When_ElementIsIncorrectlyFormatted() {
        leaveBonusComponentPrefabXmlReader.readComponentPrefab(
                xmlReader.parse(COMPONENT_INCORRECT_ELEMENT)
        );
    }
}