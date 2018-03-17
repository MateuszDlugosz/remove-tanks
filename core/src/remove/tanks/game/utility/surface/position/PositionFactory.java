package remove.tanks.game.utility.surface.position;

import remove.tanks.game.utility.scale.Scale;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class PositionFactory {
    public List<Position> createPositions(List<PositionPrefab> prefabs, Scale scale) {
        return prefabs.stream()
                .map(p -> createPosition(p, scale))
                .collect(Collectors.toList());
    }

    public Position createPosition(PositionPrefab prefab, Scale scale) {
        try {
            return new Position(
                    scale.scaleValue(prefab.getX()),
                    scale.scaleValue(prefab.getY())
            );
        } catch (Exception e) {
            throw new PositionCreateException(prefab, e);
        }
    }
}
