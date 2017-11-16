package remove.tanks.game.utility.position;

import remove.tanks.game.utility.scale.Scale;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class PositionFactory {
    public List<Position> createPositions(List<PositionPrototype> prototypes, Scale scale) {
        return prototypes.stream()
                .map(p -> createPosition(p, scale))
                .collect(Collectors.toList());
    }

    public Position createPosition(PositionPrototype prototype, Scale scale) {
        try {
            return new Position(
                    scale.scaleValue(prototype.getX()),
                    scale.scaleValue(prototype.getY())
            );
        } catch (Exception e) {
            throw new PositionCreateException(prototype, e);
        }
    }
}
