package remove.tanks.game.level.engine.entity.component.trigger;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.level.event.EventPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class TriggerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<TriggerComponentPrototype>
{
    private final EventPrototypeXmlLoader eventPrototypeXmlLoader;

    public TriggerComponentPrototypeXmlLoader(EventPrototypeXmlLoader eventPrototypeXmlLoader) {
        this.eventPrototypeXmlLoader = eventPrototypeXmlLoader;
    }

    @Override
    public TriggerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new TriggerComponentPrototype(
                eventPrototypeXmlLoader.loadEventPrototypes(
                        element.getChildByName(EventPrototypeXmlLoader.EVENTS_ELEMENT)
                )
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.TriggerComponent;
    }
}
