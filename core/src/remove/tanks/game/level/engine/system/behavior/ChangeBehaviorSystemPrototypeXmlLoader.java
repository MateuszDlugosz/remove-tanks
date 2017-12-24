package remove.tanks.game.level.engine.system.behavior;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
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
        try {
            return new ChangeBehaviorSystemPrototype(priority);
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.ChangeBehaviorSystem;
    }
}
