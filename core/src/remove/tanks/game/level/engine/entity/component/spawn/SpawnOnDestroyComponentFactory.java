package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.level.engine.utility.spawn.entry.SpawnEntry;
import remove.tanks.game.level.engine.utility.spawn.entry.SpawnEntryFactory;
import remove.tanks.game.level.engine.utility.spawn.entry.SpawnEntryPrototype;
import remove.tanks.game.utility.scale.Scale;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class SpawnOnDestroyComponentFactory
        implements RegistrableComponentFactory<SpawnOnDestroyComponent, SpawnOnDestroyComponentPrototype>
{
    private final SpawnEntryFactory spawnEntryFactory;

    public SpawnOnDestroyComponentFactory(SpawnEntryFactory spawnEntryFactory) {
        this.spawnEntryFactory = spawnEntryFactory;
    }

    @Override
    public SpawnOnDestroyComponent createComponent(SpawnOnDestroyComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new SpawnOnDestroyComponent(
                    createSpawnEntries(
                            prototype.getSpawnEntryPrototypes(),
                            level.getResourceRegistry().getResource(
                                    LevelResource.WorldScale.toString(), Scale.class)
                    )
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    private List<SpawnEntry> createSpawnEntries(List<SpawnEntryPrototype> prototypes, Scale scale) {
        return spawnEntryFactory.createSpawnEntries(prototypes, scale);
    }

    @Override
    public Class<SpawnOnDestroyComponentPrototype> getFactoryType() {
        return SpawnOnDestroyComponentPrototype.class;
    }
}
