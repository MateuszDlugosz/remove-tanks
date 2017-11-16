package remove.tanks.game.graphic.color;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class HexColorPrototype implements ColorPrototype {
    private final String hexValue;

    public HexColorPrototype(String hexValue) {
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
