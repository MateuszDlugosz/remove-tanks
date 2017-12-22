package remove.tanks.game.level.engine.system.hud.stages.state;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.constant.LevelState;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class StateBarPrototypeXmlLoader {
    public static final String STATE_BAR_ELEMENT = "stateBar";

    private static final String DISPLAYABLE_STATES_ELEMENT = "displayableStates";
    private static final String DISPLAYABLE_STATE_ELEMENT = "displayableState";

    public StateBarPrototype loadStateBarPrototype(XmlReader.Element element) {
        try {
            return new StateBarPrototype(
                    loadDisplayableStates(element)
            );
        } catch (Exception e) {
            throw new StateBarPrototypeXmlLoadException(element, e);
        }
    }

    private List<LevelState> loadDisplayableStates(XmlReader.Element element) {
        return Arrays.stream(element.getChildByName(DISPLAYABLE_STATES_ELEMENT)
                .getChildrenByName(DISPLAYABLE_STATE_ELEMENT).toArray())
                .map(e -> LevelState.valueOf(e.getText().trim()))
                .collect(Collectors.toList());
    }
}
