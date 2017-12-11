package remove.tanks.game.level.engine.listener.bonus;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.ListenerType;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class BonusPickUpListenerPrototypeXmlLoader
        implements RegistrableEntityListenerPrototypeXmlLoader<BonusPickUpListenerPrototype>
{
    @Override
    public BonusPickUpListenerPrototype loadEntityListenerPrototype(XmlReader.Element element, int priority) {
        return new BonusPickUpListenerPrototype(priority);
    }

    @Override
    public ListenerType getLoaderType() {
        return ListenerType.BonusPickUpListener;
    }
}
