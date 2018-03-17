package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.effect.Effect;
import remove.tanks.game.graphics.effect.EffectFactory;
import remove.tanks.game.graphics.effect.EffectPrefab;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class HitComponentFactory implements SubComponentFactory<HitComponent, HitComponentPrefab> {
    private final EffectFactory effectFactory;

    public HitComponentFactory(EffectFactory effectFactory) {
        this.effectFactory = effectFactory;
    }

    @Override
    public HitComponent createComponent(HitComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new HitComponent(
                    createEffect(
                            prefab.getEffectPrefab(),
                            registry.getResource(ResourceType.AssetStorageResource, AssetStorage.class)
                    ),
                    createTimer(prefab.getHitTime())
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    private Effect createEffect(EffectPrefab effectPrefab, AssetStorage assetStorage) {
        return effectFactory.createEffect(effectPrefab, assetStorage);
    }

    private Timer createTimer(float time) {
        return new Timer(time);
    }

    @Override
    public Class<HitComponentPrefab> getFactoryType() {
        return null;
    }
}
