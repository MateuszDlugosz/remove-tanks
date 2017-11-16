package remove.tanks.game.level.engine.system.shoot;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class RandomShootSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<RandomShootSystemPrototype>
{
    @Override
    protected RandomShootSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new RandomShootSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.RandomShootSystem;
    }
}
