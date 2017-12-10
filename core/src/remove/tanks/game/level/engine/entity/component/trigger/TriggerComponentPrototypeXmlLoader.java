package remove.tanks.game.level.engine.entity.component.trigger;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.level.event.EventPrototype;
import remove.tanks.game.level.event.EventPrototypeXmlLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class TriggerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<TriggerComponentPrototype>
{
    private static final String CREATE_EVENTS_ELEMENT = "createEvents";
    private static final String DESTROY_EVENTS_ELEMENT = "destroyEvents";

    private final EventPrototypeXmlLoader eventPrototypeXmlLoader;

    public TriggerComponentPrototypeXmlLoader(EventPrototypeXmlLoader eventPrototypeXmlLoader) {
        this.eventPrototypeXmlLoader = eventPrototypeXmlLoader;
    }

    @Override
    public TriggerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new TriggerComponentPrototype(
                loadCreateEventPrototypes(element),
                loadDestroyEventPrototypes(element)
        );
    }

    private List<EventPrototype> loadCreateEventPrototypes(XmlReader.Element element) {
        if (element.getChildByName(CREATE_EVENTS_ELEMENT) != null) {
            return eventPrototypeXmlLoader.loadEventPrototypes(
                    element.getChildByName(CREATE_EVENTS_ELEMENT)
            );
        } else {
            return new ArrayList<>();
        }
    }

    private List<EventPrototype> loadDestroyEventPrototypes(XmlReader.Element element) {
        if (element.getChildByName(DESTROY_EVENTS_ELEMENT) != null) {
            return eventPrototypeXmlLoader.loadEventPrototypes(
                    element.getChildByName(DESTROY_EVENTS_ELEMENT)
            );
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.TriggerComponent;
    }
}
