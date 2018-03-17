package remove.tanks.game.utility.surface.boundary;

import remove.tanks.game.utility.scale.Scale;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class BoundaryFactory {
    public List<Boundary> createBoundaries(List<BoundaryPrefab> prefabs, Scale scale) {
        return prefabs.stream()
                .map(p -> createBoundary(p, scale))
                .collect(Collectors.toList());
    }

    public Boundary createBoundary(BoundaryPrefab prefab, Scale scale) {
        try {
            return new Boundary(
                    prepareValue(prefab.getMinX(), scale),
                    prepareValue(prefab.getMaxX(), scale),
                    prepareValue(prefab.getMinY(), scale),
                    prepareValue(prefab.getMaxY(), scale)
            );
        } catch (Exception e) {
            throw new BoundaryCreateException(prefab, e);
        }
    }

    private float prepareValue(float value, Scale scale) {
        return scale.scaleValue(value);
    }
}
