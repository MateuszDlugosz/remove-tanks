package remove.tanks.game.graphics.color;

import com.badlogic.gdx.graphics.Color;

/**
 * @author Mateusz Długosz
 */
public final class HexColorFactory implements SubColorFactory<HexColorPrefab> {
    @Override
    public Color createColor(HexColorPrefab prefab) {
        try {
            return Color.valueOf(prefab.getHexValue());
        } catch (Exception e) {
            throw new ColorCreateException(prefab, e);
        }
    }

    @Override
    public Class<HexColorPrefab> getFactoryType() {
        return HexColorPrefab.class;
    }
}
