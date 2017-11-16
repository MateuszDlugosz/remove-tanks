package remove.tanks.game.level.engine.system.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;
import remove.tanks.game.level.engine.utility.spwan.activator.SpawnerActivatorPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ChainSpawnerActivateSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<ChainSpawnerActivateSystemPrototype>
{
    private final SpawnerActivatorPrototypeXmlLoader spawnerActivatorPrototypeXmlLoader;

    public ChainSpawnerActivateSystemPrototypeXmlLoader(
            SpawnerActivatorPrototypeXmlLoader spawnerActivatorPrototypeXmlLoader
    ) {
        this.spawnerActivatorPrototypeXmlLoader = spawnerActivatorPrototypeXmlLoader;
    }

    @Override
    protected ChainSpawnerActivateSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new ChainSpawnerActivateSystemPrototype(
                spawnerActivatorPrototypeXmlLoader.loadSpawnerActivatorPrototypes(
                        element.getChildByName(SpawnerActivatorPrototypeXmlLoader.SPAWNER_ACTIVATORS_ELEMENT)
                ),
                priority
        );
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.ChainSpawnerActivateSystem;
    }
}
