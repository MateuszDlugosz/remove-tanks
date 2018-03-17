package remove.tanks.game.level.utility.state;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class StateXmlReaderTest {
    private static final String STATE_CORRECT_ELEMENT =
            "<state>Standing</state>";

    private static final String STATE_INCORRECT_ELEMENT =
            "<state>UnknownStateM</state>";

    private static final String STATES_CORRECT_ELEMENT =
            "<states>" +
                    "<state>Standing</state>" +
                    "<state>Moving</state>" +
            "</states>";

    private static final String STATES_INCORRECT_ELEMENT =
            "<states>" +
                    "<state>Standing</state>" +
                    "<state>UnknownState</state>" +
            "</states>";

    private XmlReader xmlReader;
    private StateXmlReader stateXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        stateXmlReader = new StateXmlReader();
    }

    @Test
    public void Should_ReturnState() {
        assertEquals(State.Standing, stateXmlReader.readState(xmlReader.parse(STATE_CORRECT_ELEMENT)));
    }

    @Test(expected = StateXmlReadException.class)
    public void Should_ThrowException_When_StateIsNotInEnum() {
        stateXmlReader.readState(xmlReader.parse(STATE_INCORRECT_ELEMENT));
    }

    @Test
    public void Should_ReturnStates() {
        List<State> states = stateXmlReader.readStates(xmlReader.parse(STATES_CORRECT_ELEMENT));

        assertEquals(2, states.size());
        assertEquals(State.Standing, states.get(0));
        assertEquals(State.Moving, states.get(1));
    }

    @Test(expected = StateXmlReadException.class)
    public void Should_ThrowException_When_AtLeastOneStateIsNotInEnum() {
        stateXmlReader.readStates(xmlReader.parse(STATES_INCORRECT_ELEMENT));
    }
}