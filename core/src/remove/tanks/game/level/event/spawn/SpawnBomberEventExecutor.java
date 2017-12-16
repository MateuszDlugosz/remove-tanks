package remove.tanks.game.level.event.spawn;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.spawn.BombersSpawnerComponent;
import remove.tanks.game.level.event.RegistrableEventExecutor;

/**
 * @author Mateusz Długosz
 */
public final class SpawnBomberEventExecutor
        implements RegistrableEventExecutor<SpawnBomberEvent>
{
    @Override
    public void executeEvent(SpawnBomberEvent event, Level level) {
        Entity spawner = level.getResourceRegistry().getResource(LevelResource.Engine.toString(), Engine.class)
                .getEntitiesFor(EntityFamily.BombersSpawnerFamily.getFamily()).random();
        if (spawner != null) {
            PhysicsComponent pc = PhysicsComponent.MAPPER.get(spawner);
            level.getResourceRegistry().getResource(LevelResource.EventBus.toString(), EventBus.class)
                    .post(new SpawnEntityEvent(
                            BombersSpawnerComponent.MAPPER.get(spawner).getPrototype(),
                            pc.getPosition()
                    ));
        }
    }

    @Override
    public Class<SpawnBomberEvent> getExecutorType() {
        return SpawnBomberEvent.class;
    }
}
