package remove.tanks.game.level.engine.entity.component.state;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.utility.state.State;
import remove.tanks.game.level.utility.state.StateXmlReader;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class StateComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT =
            "<component type=\"StateComponent\">" +
                    "<state>Standing</state>" +
            "</component>";

    private static final String COMPONENT_INCORRECT_ELEMENT =
            "<component type=\"StateComponent\">" +
            "</component>";

    private XmlReader xmlReader;
    private StateComponentPrefabXmlReader stateComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        stateComponentPrefabXmlReader = new StateComponentPrefabXmlReader(
                new StateXmlReader()
        );
    }

    @Test
    public void Should_ReturnStateComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        StateComponentPrefab prefab = stateComponentPrefabXmlReader.readComponentPrefab(element);

        assertEquals(State.Standing, prefab.getState());
    }

    @Test(expected = ComponentPrefabXmlReadException.class)
    public void Should_ThrowException_When_ElementIsIncorrectlyFormatted() {
        stateComponentPrefabXmlReader.readComponentPrefab(xmlReader.parse(COMPONENT_INCORRECT_ELEMENT));
    }
}