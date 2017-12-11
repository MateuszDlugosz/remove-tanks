package remove.tanks.game.level.engine.system.time;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;
import remove.tanks.game.level.engine.system.time.timeline.TimelinePrototype;
import remove.tanks.game.level.engine.system.time.timeline.TimelinePrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class TimelineSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<TimelineSystemPrototype>
{
    private final TimelinePrototypeXmlLoader timelinePrototypeXmlLoader;

    public TimelineSystemPrototypeXmlLoader(TimelinePrototypeXmlLoader timelinePrototypeXmlLoader) {
        this.timelinePrototypeXmlLoader = timelinePrototypeXmlLoader;
    }

    @Override
    public TimelineSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new TimelineSystemPrototype(
                priority,
                loadTimelinePrototype(element)
        );
    }

    private TimelinePrototype loadTimelinePrototype(XmlReader.Element element) {
        return timelinePrototypeXmlLoader.loadTimelinePrototype(
                element.getChildByName(TimelinePrototypeXmlLoader.TIMELINE_ELEMENT)
        );
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.TimelineSystem;
    }
}
