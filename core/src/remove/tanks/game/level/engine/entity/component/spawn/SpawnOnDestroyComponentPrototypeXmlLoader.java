package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.utility.spawn.entry.SpawnEntryPrototype;
import remove.tanks.game.level.engine.utility.spawn.entry.SpawnEntryPrototypeXmlLoader;

import java.util.List;

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
        try {
            return new SpawnOnDestroyComponentPrototype(
                    loadSpawnEntries(element)
            );
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    private List<SpawnEntryPrototype> loadSpawnEntries(XmlReader.Element element) {
        return spawnEntryPrototypeXmlLoader.loadSpawnEntries(
                element.getChildByName(SpawnEntryPrototypeXmlLoader.SPAWN_ENTRIES_ELEMENT)
                        .getChildrenByName(SpawnEntryPrototypeXmlLoader.SPAWN_ENTRY_ELEMENT)
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.SpawnOnDestroyComponent;
    }
}
