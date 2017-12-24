package remove.tanks.game.level.engine;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.EntityListenerPrototype;
import remove.tanks.game.level.engine.listener.EntityListenerPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.EntitySystemPrototype;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class EnginePrototypeXmlLoader {
    public static final String ENGINE_ELEMENT = "engine";

    private final EntitySystemPrototypeXmlLoader entitySystemPrototypeXmlLoader;
    private final EntityListenerPrototypeXmlLoader entityListenerPrototypeXmlLoader;

    public EnginePrototypeXmlLoader(
            EntitySystemPrototypeXmlLoader entitySystemPrototypeXmlLoader,
            EntityListenerPrototypeXmlLoader entityListenerPrototypeXmlLoader
    ) {
        this.entitySystemPrototypeXmlLoader = entitySystemPrototypeXmlLoader;
        this.entityListenerPrototypeXmlLoader = entityListenerPrototypeXmlLoader;
    }

    public EnginePrototype loadEnginePrototype(XmlReader.Element element) {
        try {
            return new EnginePrototype(
                    loadEntitySystemPrototypes(element),
                    loadEntityListenerPrototypes(element)
            );
        } catch (Exception e) {
            throw new EnginePrototypeXmlLoadException(element, e);
        }
    }

    private List<EntitySystemPrototype> loadEntitySystemPrototypes(XmlReader.Element element) {
        return entitySystemPrototypeXmlLoader.loadEntitySystemPrototypes(
                element.getChildByName(EntitySystemPrototypeXmlLoader.SYSTEMS_ELEMENT)
                        .getChildrenByName(EntitySystemPrototypeXmlLoader.SYSTEM_ELEMENT)
        );
    }

    private List<EntityListenerPrototype> loadEntityListenerPrototypes(XmlReader.Element element) {
        return entityListenerPrototypeXmlLoader.loadEntityListenersPrototypes(
                element.getChildByName(EntityListenerPrototypeXmlLoader.LISTENERS_ELEMENT)
                        .getChildrenByName(EntityListenerPrototypeXmlLoader.LISTENER_ELEMENT)
        );
    }
}
