package remove.tanks.game.graphic.color;

import com.badlogic.gdx.graphics.Color;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableColorFactory<T extends ColorPrototype> {
    Color createColor(T prototype);
    Class<T> getFactoryType();
}
