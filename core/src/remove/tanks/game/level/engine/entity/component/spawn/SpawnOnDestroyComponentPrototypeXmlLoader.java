package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.utility.spawn.entry.SpawnEntryPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class SpawnOnDestroyComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<SpawnOnDestroyComponentPrototype>
{
    private final SpawnEntryPrototypeXmlLoader spawnEntryPrototypeXmlLoader;

    public SpawnOnDestroyComponentPrototypeXmlLoader(SpawnEntryPrototypeXmlLoader spawnEntryPrototypeXmlLoader) {
        this.spawnEntryPrototypeXmlLoader = spawnEntryPrototypeXmlLoader;
    }

    @Override
    public SpawnOnDestroyComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new SpawnOnDestroyComponentPrototype(
                spawnEntryPrototypeXmlLoader.loadSpawnEntries(
                        element.getChildByName(SpawnEntryPrototypeXmlLoader.SPAWN_ENTRIES_ELEMENT)
                                .getChildrenByName(SpawnEntryPrototypeXmlLoader.SPAWN_ENTRY_ELEMENT)
                )
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.SpawnOnDestroyComponent;
    }
}
