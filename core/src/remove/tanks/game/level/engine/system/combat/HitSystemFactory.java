package remove.tanks.game.level.engine.system.combat;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class HitSystemFactory implements SubEntitySystemFactory<HitSystem, HitSystemPrefab> {
    @Override
    public HitSystem createEntitySystem(HitSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new HitSystem(prefab.getPriority());
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<HitSystemPrefab> getFactoryType() {
        return HitSystemPrefab.class;
    }
}
