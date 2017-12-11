package remove.tanks.game.level.engine.listener.points;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.ListenerType;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class PointsListenerPrototypeXmlLoader
        implements RegistrableEntityListenerPrototypeXmlLoader<PointsListenerPrototype>
{
    @Override
    public PointsListenerPrototype loadEntityListenerPrototype(XmlReader.Element element, int priority) {
        return new PointsListenerPrototype(priority);
    }

    @Override
    public ListenerType getLoaderType() {
        return ListenerType.PointsListener;
    }
}
