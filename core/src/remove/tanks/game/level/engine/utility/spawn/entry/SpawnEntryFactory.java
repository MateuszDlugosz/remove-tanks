package remove.tanks.game.level.engine.utility.spawn.entry;

import remove.tanks.game.utility.position.Position;
import remove.tanks.game.utility.position.PositionFactory;
import remove.tanks.game.utility.position.PositionPrototype;
import remove.tanks.game.utility.scale.Scale;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SpawnEntryFactory {
    private final PositionFactory positionFactory;

    public SpawnEntryFactory(PositionFactory positionFactory) {
        this.positionFactory = positionFactory;
    }

    public List<SpawnEntry> createSpawnEntries(List<SpawnEntryPrototype> prototypes, Scale scale) {
        return prototypes.stream()
                .map(p -> createSpawnEntry(p, scale))
                .collect(Collectors.toList());
    }

    public SpawnEntry createSpawnEntry(SpawnEntryPrototype prototype, Scale scale) {
        try {
            return new SpawnEntry(
                    createPosition(prototype.getPositionPrototype(), scale),
                    prototype.getPrototypeCode()
            );
        } catch (Exception e) {
            throw new SpawnEntryCreateException(prototype, e);
        }
    }

    private Position createPosition(PositionPrototype prototype, Scale scale) {
        return positionFactory.createPosition(prototype, scale);
    }
}
