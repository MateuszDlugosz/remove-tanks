package remove.tanks.game.utility.boundary;

import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class BoundariesFactory {
    public Boundaries createBoundaries(BoundariesPrototype prototype, Scale scale) {
        try {
            return new Boundaries(
                    scale.scaleValue(prototype.getMinX()),
                    scale.scaleValue(prototype.getMaxX()),
                    scale.scaleValue(prototype.getMinY()),
                    scale.scaleValue(prototype.getMaxY())
            );
        } catch (Exception e) {
            throw new BoundariesCreateException(prototype, e);
        }
    }
}
