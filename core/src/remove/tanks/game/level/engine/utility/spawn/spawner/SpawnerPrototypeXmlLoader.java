package remove.tanks.game.level.engine.utility.spawn.spawner;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SpawnerPrototypeXmlLoader {
    public static final String SPAWNER_ELEMENT = "spawner";
    public static final String SPAWNERS_ELEMENT = "spawners";

    private static final String ID_ATTRIBUTE = "id";
    private static final String ACTIVE_ELEMENT = "active";
    private static final String LIMIT_ELEMENT = "limit";
    private static final String FREQUENCY_ELEMENT = "frequency";
    private static final String PROTOTYPE_CODES_ELEMENT = "prototypeCodes";
    private static final String PROTOTYPE_CODE_ELEMENT = "prototypeCode";

    public List<SpawnerPrototype> loadSpawnerPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(SPAWNER_ELEMENT).toArray())
                .map(this::loadSpawnerPrototype)
                .collect(Collectors.toList());
    }

    public SpawnerPrototype loadSpawnerPrototype(XmlReader.Element element) {
        try {
            return new SpawnerPrototype(
                    element.getAttribute(ID_ATTRIBUTE).trim(),
                    Boolean.valueOf(element.getChildByName(ACTIVE_ELEMENT).getText().trim()),
                    Integer.valueOf(element.getChildByName(LIMIT_ELEMENT).getText().trim()),
                    Float.valueOf(element.getChildByName(FREQUENCY_ELEMENT).getText().trim()),
                    Arrays.stream(element.getChildByName(PROTOTYPE_CODES_ELEMENT)
                            .getChildrenByName(PROTOTYPE_CODE_ELEMENT).toArray())
                            .map(e -> e.getText().trim())
                            .collect(Collectors.toList())
            );
        } catch (Exception e) {
            throw new SpawnerPrototypeXmlLoadException(element, e);
        }
    }
}
