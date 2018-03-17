package remove.tanks.game.level.utility.create;

import remove.tanks.game.utility.scale.Scale;
import remove.tanks.game.utility.surface.position.Position;
import remove.tanks.game.utility.surface.position.PositionFactory;
import remove.tanks.game.utility.surface.position.PositionPrefab;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class CreateEntryFactory {
    private final PositionFactory positionFactory;

    public CreateEntryFactory(PositionFactory positionFactory) {
        this.positionFactory = positionFactory;
    }

    public List<CreateEntry> createCreateEntries(List<CreateEntryPrefab> prefabs, Scale scale) {
        return prefabs.stream()
                .map(p -> createCreateEntry(p, scale))
                .collect(Collectors.toList());
    }

    public CreateEntry createCreateEntry(CreateEntryPrefab prefab, Scale scale) {
        try {
            return new CreateEntry(
                    prefab.getPrefabCode(),
                    createPosition(prefab.getPositionPrefab(), scale)
            );
        } catch (Exception e) {
            throw new CreateEntryCreateException(prefab, e);
        }
    }

    private Position createPosition(PositionPrefab positionPrefab, Scale scale) {
        return positionFactory.createPosition(positionPrefab, scale);
    }
}
