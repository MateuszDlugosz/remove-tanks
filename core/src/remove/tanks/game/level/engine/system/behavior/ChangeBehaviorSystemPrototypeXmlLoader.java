package remove.tanks.game.level.engine.system.behavior;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class ChangeBehaviorSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<ChangeBehaviorSystemPrototype>
{
    @Override
    public ChangeBehaviorSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new ChangeBehaviorSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.ChangeBehaviorSystem;
    }
}
