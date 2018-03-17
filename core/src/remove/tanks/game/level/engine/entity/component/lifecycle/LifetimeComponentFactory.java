package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class LifetimeComponentFactory implements SubComponentFactory<LifetimeComponent, LifetimeComponentPrefab> {
    @Override
    public LifetimeComponent createComponent(LifetimeComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new LifetimeComponent(createTimer(prefab.getLifetime()));
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    private Timer createTimer(float lifetime) {
        return new Timer(lifetime);
    }

    @Override
    public Class<LifetimeComponentPrefab> getFactoryType() {
        return LifetimeComponentPrefab.class;
    }
}
