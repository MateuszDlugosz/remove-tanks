package remove.tanks.game.level.event.entity.music;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.audio.music.event.PlayMusicEvent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.surface.boundary.Boundary;

/**
 * @author Mateusz Długosz
 */
public final class PlayMusicEntityEventExecutor implements SubEventExecutor<PlayMusicEntityEvent> {
    @Override
    public void executeEvent(PlayMusicEntityEvent event, ResourceRegistry registry) {
        try {
            if (registry.getResource(ResourceType.TiledMapBoundaryResource, Boundary.class)
                    .isInBoundary(PhysicsComponent.MAPPER.get(event.getEntity()).getPosition()))
            {
                registry.getResource(ResourceType.GlobalEventBusResource, EventBus.class)
                        .post(new PlayMusicEvent(event.getMusicChannelName(), event.getMusic()));
            }
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<PlayMusicEntityEvent> getExecutorType() {
        return PlayMusicEntityEvent.class;
    }
}
