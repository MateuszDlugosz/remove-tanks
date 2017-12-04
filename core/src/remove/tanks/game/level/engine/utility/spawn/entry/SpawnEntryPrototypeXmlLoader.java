package remove.tanks.game.level.engine.utility.spawn.entry;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.utility.position.PositionPrototype;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SpawnEntryPrototypeXmlLoader {
    public static final String SPAWN_ENTRIES_ELEMENT = "spawnEntries";
    public static final String SPAWN_ENTRY_ELEMENT = "spawnEntry";

    private static final String PROTOTYPE_CODE_ELEMENT = "prototypeCode";

    private final PositionPrototypeXmlLoader positionPrototypeXmlLoader;

    public SpawnEntryPrototypeXmlLoader(PositionPrototypeXmlLoader positionPrototypeXmlLoader) {
        this.positionPrototypeXmlLoader = positionPrototypeXmlLoader;
    }

    public List<SpawnEntryPrototype> loadSpawnEntries(Array<XmlReader.Element> elements) {
        return Arrays.stream(elements.toArray())
                .map(this::loadSpawnEntry)
                .collect(Collectors.toList());
    }

    public SpawnEntryPrototype loadSpawnEntry(XmlReader.Element element) {
        try {
            return new SpawnEntryPrototype(
                    loadSpawnEntryPositionPrototype(element),
                    element.getChildByName(PROTOTYPE_CODE_ELEMENT).getText().trim()
            );
        } catch (Exception e) {
            throw new SpawnEntryPrototypeXmlLoadException(element, e);
        }
    }

    private PositionPrototype loadSpawnEntryPositionPrototype(XmlReader.Element element) {
        return element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT) == null
                ? new PositionPrototype(0,0)
                : positionPrototypeXmlLoader.loadPositionPrototype(
                element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT)
        );
    }
}
