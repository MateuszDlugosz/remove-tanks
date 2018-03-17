package remove.tanks.game.level.engine.system.combat;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class HealthSystemFactory implements SubEntitySystemFactory<HealthSystem, HealthSystemPrefab> {
    @Override
    public HealthSystem createEntitySystem(HealthSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new HealthSystem(prefab.getPriority());
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<HealthSystemPrefab> getFactoryType() {
        return HealthSystemPrefab.class;
    }
}
