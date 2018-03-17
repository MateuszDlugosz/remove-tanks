package remove.tanks.game.level.event.entity.airplane;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.utils.ImmutableArray;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.spawn.AirplaneSpawnerComponent;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.event.create.CreateEvent;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.level.utility.create.CreateEntry;

/**
 * @author Mateusz Długosz
 */
public final class SpawnAirplaneEntityEventExecutor implements SubEventExecutor<SpawnAirplaneEntityEvent> {
    @Override
    public void executeEvent(SpawnAirplaneEntityEvent event, ResourceRegistry registry) {
        try {
            ImmutableArray<Entity> spawners = registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getEntitiesFor(EntityFamily.AirplaneSpawnerFamily.getFamily());
            if (spawners.size() > 0) {
                Entity spawner = spawners.random();
                registry.getResource(ResourceType.EventBusResource, EventBus.class)
                        .post(new CreateEvent(Lists.newArrayList(new CreateEntry(
                                AirplaneSpawnerComponent.MAPPER.get(spawner).getEntityPrefabCode(),
                                PhysicsComponent.MAPPER.get(spawner).getPosition()
                        ))));
            }
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<SpawnAirplaneEntityEvent> getExecutorType() {
        return SpawnAirplaneEntityEvent.class;
    }
}
