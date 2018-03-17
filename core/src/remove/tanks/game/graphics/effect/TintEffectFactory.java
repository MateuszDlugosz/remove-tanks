package remove.tanks.game.graphics.effect;

import com.badlogic.gdx.graphics.Color;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.color.ColorFactory;

/**
 * @author Mateusz Długosz
 */
public final class TintEffectFactory implements SubEffectFactory<TintEffect, TintEffectPrefab> {
    private final ColorFactory colorFactory;

    public TintEffectFactory(ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }

    @Override
    public TintEffect createEffect(TintEffectPrefab prefab, AssetStorage assetStorage) {
        try {
            return new TintEffect(createColor(prefab));
        } catch (Exception e) {
            throw new EffectCreateException(prefab, e);
        }
    }

    private Color createColor(TintEffectPrefab prefab) {
        return colorFactory.createColor(prefab.getColorPrefab());
    }

    @Override
    public Class<TintEffectPrefab> getFactoryType() {
        return TintEffectPrefab.class;
    }
}
