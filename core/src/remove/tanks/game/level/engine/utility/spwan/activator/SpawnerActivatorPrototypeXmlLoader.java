package remove.tanks.game.level.engine.utility.spwan.activator;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.utility.letter.NATOLetter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SpawnerActivatorPrototypeXmlLoader {
    public static final String SPAWNER_ACTIVATOR_ELEMENT = "spawnerActivator";
    public static final String SPAWNER_ACTIVATORS_ELEMENT = "spawnerActivators";

    private static final String LETTER_ELEMENT = "letter";
    private static final String DELAY_ELEMENT = "delay";

    public List<SpawnerActivatorPrototype> loadSpawnerActivatorPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(SPAWNER_ACTIVATOR_ELEMENT).toArray())
                .map(this::loadSpawnerActivatorPrototype)
                .collect(Collectors.toList());
    }

    public SpawnerActivatorPrototype loadSpawnerActivatorPrototype(XmlReader.Element element) {
        try {
            return new SpawnerActivatorPrototype(
                    NATOLetter.valueOf(element.getChildByName(LETTER_ELEMENT).getText().trim()),
                    Float.valueOf(element.getChildByName(DELAY_ELEMENT).getText().trim())
            );
        } catch (Exception e) {
            throw new SpawnActivatorPrototypeXmlLoadException(element, e);
        }
    }
}
