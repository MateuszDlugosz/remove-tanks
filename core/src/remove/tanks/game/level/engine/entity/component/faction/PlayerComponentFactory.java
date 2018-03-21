package remove.tanks.game.level.engine.entity.component.faction;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class PlayerComponentFactory implements SubComponentFactory<PlayerComponent, PlayerComponentPrefab> {
    @Override
    public PlayerComponent createComponent(PlayerComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return PlayerComponent.INSTANCE;
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<PlayerComponentPrefab> getFactoryType() {
        return PlayerComponentPrefab.class;
    }
}
