package remove.tanks.game.level.engine.system.direction;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class RandomDirectionSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<RandomDirectionSystemPrototype>
{
    @Override
    public RandomDirectionSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return new RandomDirectionSystemPrototype(priority);
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.RandomDirectionSystem;
    }
}
