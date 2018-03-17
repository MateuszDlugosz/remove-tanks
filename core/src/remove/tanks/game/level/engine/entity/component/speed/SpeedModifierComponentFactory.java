package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class SpeedModifierComponentFactory implements SubComponentFactory<SpeedModifierComponent, SpeedModifierComponentPrefab> {
    @Override
    public SpeedModifierComponent createComponent(SpeedModifierComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new SpeedModifierComponent(prefab.getSpeedModifier());
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<SpeedModifierComponentPrefab> getFactoryType() {
        return SpeedModifierComponentPrefab.class;
    }
}
