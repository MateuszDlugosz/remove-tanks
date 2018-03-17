package remove.tanks.game.level.event;

import com.google.common.eventbus.Subscribe;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public abstract class EventPrefab extends Prefab {
    @Subscribe
    public abstract String toString();
}
