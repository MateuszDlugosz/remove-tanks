package remove.tanks.game.level.engine.system.music;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.audio.Music;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.audio.music.MusicChannelName;
import remove.tanks.game.level.event.music.PlayMusicEvent;

/**
 * @author Mateusz Długosz
 */
public final class MusicOnStartSystem extends EntitySystem {
    private final Music music;
    private final MusicChannelName musicChannelName;
    private final EventBus eventBus;

    public MusicOnStartSystem(int priority, Music music, MusicChannelName musicChannelName, EventBus eventBus) {
        super(priority);
        this.music = music;
        this.musicChannelName = musicChannelName;
        this.eventBus = eventBus;
    }

    @Override
    public void update(float deltaTime) {
        eventBus.post(new PlayMusicEvent(music, musicChannelName));
        getEngine().removeSystem(this);
    }
}
