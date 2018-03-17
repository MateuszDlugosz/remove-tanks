package remove.tanks.game.graphics.effect;

import remove.tanks.game.asset.AssetStorage;

/**
 * @author Mateusz Długosz
 */
public interface SubEffectFactory<T extends Effect, U extends EffectPrefab> {
    T createEffect(U prefab, AssetStorage assetStorage);
    Class<U> getFactoryType();
}
