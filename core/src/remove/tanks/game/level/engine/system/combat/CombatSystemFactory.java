package remove.tanks.game.level.engine.system.combat;

import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.effect.Effect;
import remove.tanks.game.graphics.effect.EffectFactory;
import remove.tanks.game.graphics.effect.EffectPrefab;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class CombatSystemFactory implements SubEntitySystemFactory<CombatSystem, CombatSystemPrefab> {
    private final EffectFactory effectFactory;

    public CombatSystemFactory(EffectFactory effectFactory) {
        this.effectFactory = effectFactory;
    }

    @Override
    public CombatSystem createEntitySystem(CombatSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new CombatSystem(
                    prefab.getPriority(),
                    createHitEffect(
                            prefab.getHitEffectPrefab(),
                            registry.getResource(ResourceType.AssetStorageResource, AssetStorage.class)
                    ),
                    prefab.getHitTime()
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    private Effect createHitEffect(EffectPrefab effectPrefab, AssetStorage assetStorage) {
        return effectFactory.createEffect(effectPrefab, assetStorage);
    }

    @Override
    public Class<CombatSystemPrefab> getFactoryType() {
        return CombatSystemPrefab.class;
    }
}
