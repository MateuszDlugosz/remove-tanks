package remove.tanks.game.level.event.music;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class PlayMusicEventExecutor implements SubEventExecutor<PlayMusicEvent> {
    @Override
    public void executeEvent(PlayMusicEvent event, ResourceRegistry registry) {
        try {
            registry.getResource(ResourceType.GlobalEventBusResource, EventBus.class)
                    .post(new remove.tanks.game.audio.music.event.PlayMusicEvent(
                            event.getMusicChannelName(),
                            event.getMusic()
                    ));
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<PlayMusicEvent> getExecutorType() {
        return PlayMusicEvent.class;
    }
}
