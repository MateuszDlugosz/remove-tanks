package remove.tanks.game.level.engine.system.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class RandomSpawnSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<RandomSpawnSystemPrototype>
{
    @Override
    public RandomSpawnSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return new RandomSpawnSystemPrototype(priority);
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.RandomSpawnSystem;
    }
}
