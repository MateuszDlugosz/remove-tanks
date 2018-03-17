package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class SpeedComponentFactory implements SubComponentFactory<SpeedComponent, SpeedComponentPrefab> {
    @Override
    public SpeedComponent createComponent(SpeedComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new SpeedComponent(
                    prefab.getSpeed()
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<SpeedComponentPrefab> getFactoryType() {
        return SpeedComponentPrefab.class;
    }
}
