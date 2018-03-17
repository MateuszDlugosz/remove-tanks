package remove.tanks.game.level.event.entity.ammo;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AmmoLevelUpEntityEventFactory implements SubEntityEventFactory<AmmoLevelUpEntityEvent, AmmoLevelUpEntityEventPrefab> {
    @Override
    public AmmoLevelUpEntityEvent createEntityEvent(AmmoLevelUpEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new AmmoLevelUpEntityEvent(entity);
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<AmmoLevelUpEntityEventPrefab> getFactoryType() {
        return AmmoLevelUpEntityEventPrefab.class;
    }
}
