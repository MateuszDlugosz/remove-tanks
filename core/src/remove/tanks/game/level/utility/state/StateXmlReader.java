package remove.tanks.game.level.utility.state;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class StateXmlReader {
    public static final String STATE_ELEMENT = "state";
    public static final String STATES_ELEMENT = "states";

    public List<State> readStates(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(STATE_ELEMENT).toArray())
                .map(this::readState)
                .collect(Collectors.toList());
    }

    public State readState(XmlReader.Element element) {
        try {
            return State.valueOf(element.getText().trim());
        } catch (Exception e) {
            throw new StateXmlReadException(element, e);
        }
    }
}
