package remove.tanks.game.level.engine.entity.component.actor;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ActorComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<ActorComponentPrototype>
{
    @Override
    public ActorComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new ActorComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.ActorComponent;
    }
}
