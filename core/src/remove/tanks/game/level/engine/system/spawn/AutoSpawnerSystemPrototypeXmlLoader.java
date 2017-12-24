package remove.tanks.game.level.engine.system.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;
import remove.tanks.game.level.engine.utility.spawn.spawner.SpawnerPrototype;
import remove.tanks.game.level.engine.utility.spawn.spawner.SpawnerPrototypeXmlLoader;

import java.util.List;

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
        try {
            return new AutoSpawnerSystemPrototype(
                    priority,
                    loadSpawnerPrototypes(element)
            );
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    private List<SpawnerPrototype> loadSpawnerPrototypes(XmlReader.Element element) {
        return spawnerPrototypeXmlLoader.loadSpawnerPrototypes(
                element.getChildByName(SpawnerPrototypeXmlLoader.SPAWNERS_ELEMENT)
        );
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.AutoSpawnerSystem;
    }
}
