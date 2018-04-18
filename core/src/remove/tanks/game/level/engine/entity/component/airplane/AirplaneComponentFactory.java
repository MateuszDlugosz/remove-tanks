package remove.tanks.game.level.engine.entity.component.airplane;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneComponentFactory implements SubComponentFactory<AirplaneComponent, AirplaneComponentPrefab> {
    @Override
    public AirplaneComponent createComponent(AirplaneComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return AirplaneComponent.INSTANCE;
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<AirplaneComponentPrefab> getFactoryType() {
        return AirplaneComponentPrefab.class;
    }
}
