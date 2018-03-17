package remove.tanks.game.level.engine.entity.component.direction;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class DirectionComponentFactory implements SubComponentFactory<DirectionComponent, DirectionComponentPrefab> {
    @Override
    public DirectionComponent createComponent(DirectionComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new DirectionComponent(prefab.getDirection());
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<DirectionComponentPrefab> getFactoryType() {
        return DirectionComponentPrefab.class;
    }
}
