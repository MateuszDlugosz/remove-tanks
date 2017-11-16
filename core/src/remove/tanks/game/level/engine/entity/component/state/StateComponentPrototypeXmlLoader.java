package remove.tanks.game.level.engine.entity.component.state;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class StateComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<StateComponentPrototype>
{
    private static final String STATE_ELEMENT = "state";

    @Override
    public StateComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new StateComponentPrototype(
                element.getChildByName(STATE_ELEMENT).getText().trim()
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.StateComponent;
    }
}
