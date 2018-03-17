package remove.tanks.game.graphics.effect;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.color.ColorPrefab;

/**
 * @author Mateusz Długosz
 */
public final class TintEffectPrefab extends EffectPrefab {
    private final ColorPrefab colorPrefab;

    public TintEffectPrefab(ColorPrefab colorPrefab) {
        this.colorPrefab = colorPrefab;
    }

    public ColorPrefab getColorPrefab() {
        return colorPrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("colorPrefab", colorPrefab)
                .toString();
    }
}
