package remove.tanks.game.level.engine.system.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class RandomSpawnSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<RandomSpawnSystemPrototype>
{
    @Override
    protected RandomSpawnSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new RandomSpawnSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.RandomSpawnSystem;
    }
}
