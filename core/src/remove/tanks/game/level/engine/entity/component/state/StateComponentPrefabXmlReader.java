package remove.tanks.game.level.engine.entity.component.state;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;
import remove.tanks.game.level.utility.state.State;
import remove.tanks.game.level.utility.state.StateXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class StateComponentPrefabXmlReader implements SubComponentPrefabXmlReader<StateComponentPrefab> {
    private final StateXmlReader stateXmlReader;

    public StateComponentPrefabXmlReader(StateXmlReader stateXmlReader) {
        this.stateXmlReader = stateXmlReader;
    }

    @Override
    public StateComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new StateComponentPrefab(readState(element));
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private State readState(XmlReader.Element element) {
        return stateXmlReader.readState(element.getChildByName(StateXmlReader.STATE_ELEMENT));
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.StateComponent;
    }
}
