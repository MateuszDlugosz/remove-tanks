package remove.tanks.game.level.engine.listener.bonus;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.ListenerType;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerPrototypeXmlLoader;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class BonusLootListenerPrototypeXmlLoader
        extends RegistrableEntityListenerPrototypeXmlLoader<BonusLootListenerPrototype>
{
    private static final String CHANCE_ELEMENT = "chance";
    private static final String PROTOTYPE_CODES_ELEMENT = "prototypeCodes";
    private static final String PROTOTYPE_CODE_ELEMENT = "prototypeCode";

    @Override
    protected BonusLootListenerPrototype loadEntityListenerPrototype(XmlReader.Element element, int priority) {
        return new BonusLootListenerPrototype(
                priority,
                Integer.valueOf(element.getChildByName(CHANCE_ELEMENT).getText().trim()),
                Arrays.stream(element.getChildByName(PROTOTYPE_CODES_ELEMENT)
                        .getChildrenByName(PROTOTYPE_CODE_ELEMENT).toArray())
                        .map(e -> e.getText().trim())
                        .collect(Collectors.toList())
        );
    }

    @Override
    public ListenerType getLoaderType() {
        return ListenerType.BonusLootListener;
    }
}
