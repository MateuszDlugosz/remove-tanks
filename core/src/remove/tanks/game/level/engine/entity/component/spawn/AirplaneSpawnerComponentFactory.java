package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneSpawnerComponentFactory implements SubComponentFactory<AirplaneSpawnerComponent, AirplaneSpawnerComponentPrefab> {
    @Override
    public AirplaneSpawnerComponent createComponent(AirplaneSpawnerComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new AirplaneSpawnerComponent(prefab.getEntityPrefabCode());
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<AirplaneSpawnerComponentPrefab> getFactoryType() {
        return AirplaneSpawnerComponentPrefab.class;
    }
}
