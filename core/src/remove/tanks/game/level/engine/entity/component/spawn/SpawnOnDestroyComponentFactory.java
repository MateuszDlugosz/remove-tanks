package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.level.engine.utility.spawn.entry.SpawnEntryFactory;
import remove.tanks.game.utility.scale.Scale;

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
        return new SpawnOnDestroyComponent(
                spawnEntryFactory.createSpawnEntries(
                        prototype.getSpawnEntryPrototypes(),
                        level.getResourceRegistry().getResource(LevelResource.WorldScale.toString(), Scale.class)
                )
        );
    }

    @Override
    public Class<SpawnOnDestroyComponentPrototype> getFactoryType() {
        return SpawnOnDestroyComponentPrototype.class;
    }
}
