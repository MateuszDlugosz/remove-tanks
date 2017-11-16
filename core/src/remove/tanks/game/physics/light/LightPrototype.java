package remove.tanks.game.physics.light;

import remove.tanks.game.graphic.color.ColorPrototype;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public interface LightPrototype extends Serializable {
    ColorPrototype getColorPrototype();
    boolean getXRay();
}
