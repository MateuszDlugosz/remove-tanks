package remove.tanks.game.level.engine.system.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;
import remove.tanks.game.level.engine.utility.spwan.spawner.SpawnerPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<AutoSpawnerSystemPrototype>
{
    private final SpawnerPrototypeXmlLoader spawnerPrototypeXmlLoader;

    public AutoSpawnerSystemPrototypeXmlLoader(SpawnerPrototypeXmlLoader spawnerPrototypeXmlLoader) {
        this.spawnerPrototypeXmlLoader = spawnerPrototypeXmlLoader;
    }

    @Override
    protected AutoSpawnerSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new AutoSpawnerSystemPrototype(
                spawnerPrototypeXmlLoader.loadSpawnerPrototypes(
                        element.getChildByName(SpawnerPrototypeXmlLoader.SPAWNERS_ELEMENT)
                ),
                priority
        );
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.AutoSpawnerSystem;
    }
}
