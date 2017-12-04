package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.utility.spawn.entry.SpawnEntryPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class RandomSpawnComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<RandomSpawnComponentPrototype>
{
    private static final String MIN_SPAWN_FREQUENCY_ELEMENT = "minSpawnFrequency";
    private static final String MAX_SPAWN_FREQUENCY_ELEMENT = "maxSpawnFrequency";

    private final SpawnEntryPrototypeXmlLoader spawnEntryPrototypeXmlLoader;

    public RandomSpawnComponentPrototypeXmlLoader(SpawnEntryPrototypeXmlLoader spawnEntryPrototypeXmlLoader) {
        this.spawnEntryPrototypeXmlLoader = spawnEntryPrototypeXmlLoader;
    }

    @Override
    public RandomSpawnComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new RandomSpawnComponentPrototype(
                Float.valueOf(element.getChildByName(MIN_SPAWN_FREQUENCY_ELEMENT).getText().trim()),
                Float.valueOf(element.getChildByName(MAX_SPAWN_FREQUENCY_ELEMENT).getText().trim()),
                spawnEntryPrototypeXmlLoader.loadSpawnEntries(
                        element.getChildByName(SpawnEntryPrototypeXmlLoader.SPAWN_ENTRIES_ELEMENT)
                                .getChildrenByName(SpawnEntryPrototypeXmlLoader.SPAWN_ENTRY_ELEMENT)
                )
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.RandomSpawnComponent;
    }
}
