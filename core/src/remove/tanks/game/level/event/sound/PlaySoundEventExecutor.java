package remove.tanks.game.level.event.sound;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class PlaySoundEventExecutor implements SubEventExecutor<PlaySoundEvent> {
    @Override
    public void executeEvent(PlaySoundEvent event, ResourceRegistry registry) {
        try {
            registry.getResource(ResourceType.GlobalEventBusResource, EventBus.class)
                    .post(new remove.tanks.game.audio.sound.event.PlaySoundEvent(
                            event.getSoundChannelName(), event.getSound()
                    ));
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<PlaySoundEvent> getExecutorType() {
        return PlaySoundEvent.class;
    }
}
