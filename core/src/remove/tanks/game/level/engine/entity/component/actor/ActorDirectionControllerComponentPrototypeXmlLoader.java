package remove.tanks.game.level.engine.entity.component.actor;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.utility.direction.Direction;

/**
 * @author Mateusz Długosz
 */
public final class ActorDirectionControllerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<ActorDirectionControllerComponentPrototype>
{
    private final static String NEW_DIRECTION_ELEMENT = "newDirection";

    @Override
    public ActorDirectionControllerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new ActorDirectionControllerComponentPrototype(
                Direction.valueOf(element.getChildByName(NEW_DIRECTION_ELEMENT).getText().trim())
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.ActorDirectionControllerComponent;
    }
}
