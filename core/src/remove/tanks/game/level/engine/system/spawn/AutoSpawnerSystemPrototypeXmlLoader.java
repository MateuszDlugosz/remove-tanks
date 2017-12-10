package remove.tanks.game.level.engine.system.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;
import remove.tanks.game.level.engine.utility.spawn.spawner.SpawnerPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<AutoSpawnerSystemPrototype>
{
    private final SpawnerPrototypeXmlLoader spawnerPrototypeXmlLoader;

    public AutoSpawnerSystemPrototypeXmlLoader(SpawnerPrototypeXmlLoader spawnerPrototypeXmlLoader) {
        this.spawnerPrototypeXmlLoader = spawnerPrototypeXmlLoader;
    }

    @Override
    public AutoSpawnerSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new AutoSpawnerSystemPrototype(
                priority,
                spawnerPrototypeXmlLoader.loadSpawnerPrototypes(
                        element.getChildByName(SpawnerPrototypeXmlLoader.SPAWNERS_ELEMENT)
                )
        );
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.AutoSpawnerSystem;
    }
}
