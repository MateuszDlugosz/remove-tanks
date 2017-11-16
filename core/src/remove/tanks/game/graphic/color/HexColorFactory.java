package remove.tanks.game.graphic.color;

import com.badlogic.gdx.graphics.Color;

/**
 * @author Mateusz Długosz
 */
public final class HexColorFactory implements RegistrableColorFactory<HexColorPrototype> {
    @Override
    public Color createColor(HexColorPrototype prototype) {
        try {
            return Color.valueOf(prototype.getHexValue());
        } catch (Exception e) {
            throw new ColorCreateException(prototype, e);
        }
    }

    @Override
    public Class<HexColorPrototype> getFactoryType() {
        return HexColorPrototype.class;
    }
}
