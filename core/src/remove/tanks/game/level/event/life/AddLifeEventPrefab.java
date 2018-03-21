package remove.tanks.game.level.event.life;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class AddLifeEventPrefab extends EventPrefab {
    public static final AddLifeEventPrefab INSTANCE = new AddLifeEventPrefab();

    private AddLifeEventPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
