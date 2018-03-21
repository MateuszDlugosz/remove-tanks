package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class RespawnComponentFactory implements SubComponentFactory<RespawnComponent, RespawnComponentPrefab> {
    @Override
    public RespawnComponent createComponent(RespawnComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return RespawnComponent.INSTANCE;
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<RespawnComponentPrefab> getFactoryType() {
        return RespawnComponentPrefab.class;
    }
}
