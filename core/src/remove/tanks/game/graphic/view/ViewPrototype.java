package remove.tanks.game.graphic.view;

import remove.tanks.game.utility.position.PositionPrototype;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public interface ViewPrototype extends Serializable {
    String getId();
    PositionPrototype getPositionPrototype();
}
