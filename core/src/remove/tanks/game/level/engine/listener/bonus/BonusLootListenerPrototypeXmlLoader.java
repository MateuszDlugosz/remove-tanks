package remove.tanks.game.level.engine.listener.bonus;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.EntityListenerPrototypeXmlLoadException;
import remove.tanks.game.level.engine.listener.ListenerType;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerPrototypeXmlLoader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class BonusLootListenerPrototypeXmlLoader
        implements RegistrableEntityListenerPrototypeXmlLoader<BonusLootListenerPrototype>
{
    private static final String CHANCE_ELEMENT = "chance";
    private static final String PROTOTYPE_CODES_ELEMENT = "prototypeCodes";
    private static final String PROTOTYPE_CODE_ELEMENT = "prototypeCode";

    @Override
    public BonusLootListenerPrototype loadEntityListenerPrototype(XmlReader.Element element, int priority) {
        try {
            return new BonusLootListenerPrototype(
                    priority,
                    loadChance(element),
                    loadPrototypeCodes(element)
            );
        } catch (Exception e) {
            throw new EntityListenerPrototypeXmlLoadException(element, e);
        }
    }

    private int loadChance(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(CHANCE_ELEMENT).getText().trim());
    }

    private List<String> loadPrototypeCodes(XmlReader.Element element) {
        return Arrays.stream(element.getChildByName(PROTOTYPE_CODES_ELEMENT)
                .getChildrenByName(PROTOTYPE_CODE_ELEMENT).toArray())
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
    }

    @Override
    public ListenerType getLoaderType() {
        return ListenerType.BonusLootListener;
    }
}
