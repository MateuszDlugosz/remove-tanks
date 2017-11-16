package remove.tanks.game.level.engine.listener;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public abstract class RegistrableEntityListenerPrototypeXmlLoader<T extends EntityListenerPrototype> {
    private static final String PRIORITY_ATTRIBUTE = "priority";

    public final T loadEntityListenerPrototype(XmlReader.Element element) {
        return loadEntityListenerPrototype(element, loadPriority(element));
    }

    protected abstract T loadEntityListenerPrototype(XmlReader.Element element, int priority);

    private int loadPriority(XmlReader.Element element) {
        return Integer.valueOf(element.getAttribute(PRIORITY_ATTRIBUTE).trim());
    }

    public abstract ListenerType getLoaderType();
}
