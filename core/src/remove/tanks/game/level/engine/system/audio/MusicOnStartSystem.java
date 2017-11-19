package remove.tanks.game.level.engine.system.audio;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.audio.Music;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.audio.music.event.PlayMusicEvent;

/**
 * @author Mateusz Długosz
 */
public final class MusicOnStartSystem extends EntitySystem {
    private final EventBus eventBus;
    private final Music music;

    public MusicOnStartSystem(int priority, EventBus eventBus, Music music) {
        super(priority);
        this.eventBus = eventBus;
        this.music = music;
    }

    @Override
    public void update(float deltaTime) {
        eventBus.post(new PlayMusicEvent(music));
        getEngine().removeSystem(this);
    }
}
