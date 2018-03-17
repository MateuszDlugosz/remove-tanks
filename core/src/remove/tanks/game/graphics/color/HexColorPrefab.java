package remove.tanks.game.graphics.color;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class HexColorPrefab extends ColorPrefab {
    private final String hexValue;

    public HexColorPrefab(String hexValue) {
        this.hexValue = hexValue;
    }

    public String getHexValue() {
        return hexValue;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("hexValue", hexValue)
                .toString();
    }
}
