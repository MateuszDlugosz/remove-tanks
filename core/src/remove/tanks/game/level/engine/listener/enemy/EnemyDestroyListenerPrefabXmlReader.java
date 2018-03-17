package remove.tanks.game.level.engine.listener.enemy;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.EntityListenerPrefabXmlReadException;
import remove.tanks.game.level.engine.listener.ListenerType;
import remove.tanks.game.level.engine.listener.SubEntityListenerPrefabXmlReader;
import remove.tanks.game.level.event.EventPrefab;
import remove.tanks.game.level.event.EventPrefabXmlReader;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EnemyDestroyListenerPrefabXmlReader implements SubEntityListenerPrefabXmlReader<EnemyDestroyListenerPrefab> {
    private static final String EVENT_THRESHOLDS_ELEMENT = "eventThresholds";
    private static final String EVENT_THRESHOLD_ELEMENT = "eventThreshold";

    private static final String COUNT_ATTRIBUTE = "count";

    private final EventPrefabXmlReader eventPrefabXmlReader;

    public EnemyDestroyListenerPrefabXmlReader(EventPrefabXmlReader eventPrefabXmlReader) {
        this.eventPrefabXmlReader = eventPrefabXmlReader;
    }

    @Override
    public EnemyDestroyListenerPrefab readEntityListenerPrefab(XmlReader.Element element, int priority) {
        try {
            return new EnemyDestroyListenerPrefab(
                    priority,
                    readEventThresholds(element)
            );
        } catch (Exception e) {
            throw new EntityListenerPrefabXmlReadException(element, e);
        }
    }

    private Map<Integer, List<EventPrefab>> readEventThresholds(XmlReader.Element element) {
        return Optional.ofNullable(element.getChildByName(EVENT_THRESHOLDS_ELEMENT))
                .map(e -> Arrays.stream(e.getChildrenByName(EVENT_THRESHOLD_ELEMENT).toArray())
                            .collect(Collectors.toMap(
                                    el -> Integer.valueOf(el.getAttribute(COUNT_ATTRIBUTE)),
                                    el -> eventPrefabXmlReader.readEventPrefabs(el.getChildByName(EventPrefabXmlReader.EVENTS_ELEMENT))
                            ))
                )
        .orElse(new HashMap<>());
    }

    @Override
    public ListenerType getReaderType() {
        return ListenerType.EnemyDestroyListener;
    }
}
