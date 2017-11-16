package remove.tanks.game.level.engine.system.direction;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class RandomDirectionSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<RandomDirectionSystemPrototype>
{
    @Override
    protected RandomDirectionSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new RandomDirectionSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.RandomDirectionSystem;
    }
}
