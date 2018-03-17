package remove.tanks.game.level.event.entity.music;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.audio.Music;
import remove.tanks.game.audio.music.MusicChannelName;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class PlayMusicEntityEvent implements EntityEvent {
    private final Entity entity;
    private final Music music;
    private final MusicChannelName musicChannelName;

    public PlayMusicEntityEvent(Entity entity, Music music, MusicChannelName musicChannelName) {
        this.entity = entity;
        this.music = music;
        this.musicChannelName = musicChannelName;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    public Music getMusic() {
        return music;
    }

    public MusicChannelName getMusicChannelName() {
        return musicChannelName;
    }
}
