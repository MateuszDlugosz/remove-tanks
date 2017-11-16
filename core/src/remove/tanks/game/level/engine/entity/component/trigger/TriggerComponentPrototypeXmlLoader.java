package remove.tanks.game.level.engine.entity.component.trigger;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.utility.letter.NATOLetter;

/**
 * @author Mateusz Długosz
 */
public final class TriggerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<TriggerComponentPrototype>
{
    private static final String LETTER_ELEMENT = "letter";

    @Override
    public TriggerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new TriggerComponentPrototype(
                NATOLetter.valueOf(element.getChildByName(LETTER_ELEMENT).getText().trim())
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.TriggerComponent;
    }
}
