package remove.tanks.game.level.engine.system;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public abstract class RegistrableEntitySystemPrototypeXmlLoader<T extends EntitySystemPrototype> {
    private static final String PRIORITY_ATTRIBUTE = "priority";

    public final T loadEntitySystemPrototype(XmlReader.Element element) {
        return loadEntitySystemPrototype(element, loadPriority(element));
    }

    protected abstract T loadEntitySystemPrototype(XmlReader.Element element, int priority);

    private int loadPriority(XmlReader.Element element) {
        return Integer.valueOf(element.getAttribute(PRIORITY_ATTRIBUTE).trim());
    }

    public abstract SystemType getLoaderType();
}
