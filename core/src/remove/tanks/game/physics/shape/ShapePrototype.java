package remove.tanks.game.physics.shape;

import remove.tanks.game.utility.position.PositionPrototype;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public interface ShapePrototype extends Serializable {
    PositionPrototype getPositionPrototype();
}
