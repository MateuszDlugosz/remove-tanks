package remove.tanks.game.level.engine.entity.component.audio;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.audio.Sound;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class SoundOnSpawnComponent implements Component {
    public static final ComponentMapper<SoundOnSpawnComponent> MAPPER
            = ComponentMapper.getFor(SoundOnSpawnComponent.class);

    private final List<Sound> sounds;

    public SoundOnSpawnComponent(List<Sound> sounds) {
        this.sounds = sounds;
    }

    public List<Sound> getSounds() {
        return sounds;
    }
}
