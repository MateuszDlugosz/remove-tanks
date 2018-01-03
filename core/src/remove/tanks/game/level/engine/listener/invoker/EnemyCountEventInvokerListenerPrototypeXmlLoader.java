package remove.tanks.game.level.engine.listener.invoker;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.EntityListenerPrototypeXmlLoadException;
import remove.tanks.game.level.engine.listener.ListenerType;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerPrototypeXmlLoader;
import remove.tanks.game.level.event.EventPrototype;
import remove.tanks.game.level.event.EventPrototypeXmlLoader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EnemyCountEventInvokerListenerPrototypeXmlLoader
        implements RegistrableEntityListenerPrototypeXmlLoader<EnemyCountEventInvokerListenerPrototype>
{
    private static final String GROUP_ELEMENT = "group";
    private static final String LIMIT_ATTRIBUTE = "limit";

    private final EventPrototypeXmlLoader eventPrototypeXmlLoader;

    public EnemyCountEventInvokerListenerPrototypeXmlLoader(EventPrototypeXmlLoader eventPrototypeXmlLoader) {
        this.eventPrototypeXmlLoader = eventPrototypeXmlLoader;
    }

    @Override
    public EnemyCountEventInvokerListenerPrototype loadEntityListenerPrototype(XmlReader.Element element, int priority) {
        try {
            return new EnemyCountEventInvokerListenerPrototype(
                    priority,
                    loadEventPrototypes(element)
            );
        } catch (Exception e) {
            throw new EntityListenerPrototypeXmlLoadException(element, e);
        }
    }

    private Map<Integer, List<EventPrototype>> loadEventPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(GROUP_ELEMENT).toArray())
                .collect(Collectors.toMap(
                        e -> Integer.valueOf(e.getAttribute(LIMIT_ATTRIBUTE)),
                        eventPrototypeXmlLoader::loadEventPrototypes
                ));
    }

    @Override
    public ListenerType getLoaderType() {
        return ListenerType.EnemyCountEventInvokerListener;
    }
}
