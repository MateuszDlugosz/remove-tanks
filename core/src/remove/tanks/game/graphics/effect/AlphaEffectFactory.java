package remove.tanks.game.graphics.effect;

import com.badlogic.gdx.math.MathUtils;
import remove.tanks.game.asset.AssetStorage;

/**
 * @author Mateusz Długosz
 */
public final class AlphaEffectFactory implements SubEffectFactory<AlphaEffect, AlphaEffectPrefab> {
    private static final float MIN_ALPHA_VALUE = 0;
    private static final float MAX_ALPHA_VALUE = 255f;

    @Override
    public AlphaEffect createEffect(AlphaEffectPrefab prefab, AssetStorage assetStorage) {
        try {
            return new AlphaEffect(createAlphaValue(prefab));
        } catch (Exception e) {
            throw new EffectCreateException(prefab, e);
        }
    }

    private float createAlphaValue(AlphaEffectPrefab prefab) {
        return MathUtils.clamp(
                prefab.getAlphaValue(),
                MIN_ALPHA_VALUE,
                MAX_ALPHA_VALUE
        ) / MAX_ALPHA_VALUE;
    }

    @Override
    public Class<AlphaEffectPrefab> getFactoryType() {
        return AlphaEffectPrefab.class;
    }
}
