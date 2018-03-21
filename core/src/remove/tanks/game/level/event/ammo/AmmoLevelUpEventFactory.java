package remove.tanks.game.level.event.ammo;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AmmoLevelUpEventFactory implements SubEventFactory<AmmoLevelUpEvent, AmmoLevelUpEventPrefab> {
    @Override
    public AmmoLevelUpEvent createEvent(AmmoLevelUpEventPrefab prefab, ResourceRegistry registry) {
        try {
            return AmmoLevelUpEvent.INSTANCE;
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @Override
    public Class<AmmoLevelUpEventPrefab> getFactoryType() {
        return AmmoLevelUpEventPrefab.class;
    }
}
