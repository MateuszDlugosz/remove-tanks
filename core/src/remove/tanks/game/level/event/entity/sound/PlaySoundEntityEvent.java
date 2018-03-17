package remove.tanks.game.level.event.entity.sound;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.audio.Sound;
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class PlaySoundEntityEvent implements EntityEvent {
    private final Entity entity;
    private final Sound sound;
    private final SoundChannelName soundChannelName;

    public PlaySoundEntityEvent(Entity entity, Sound sound, SoundChannelName soundChannelName) {
        this.entity = entity;
        this.sound = sound;
        this.soundChannelName = soundChannelName;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    public Sound getSound() {
        return sound;
    }

    public SoundChannelName getSoundChannelName() {
        return soundChannelName;
    }
}
