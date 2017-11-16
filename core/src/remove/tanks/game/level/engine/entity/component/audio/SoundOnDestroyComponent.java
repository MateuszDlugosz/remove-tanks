package remove.tanks.game.level.engine.entity.component.audio;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.audio.Sound;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class SoundOnDestroyComponent implements Component {
    public static final ComponentMapper<SoundOnDestroyComponent> MAPPER
            = ComponentMapper.getFor(SoundOnDestroyComponent.class);

    private final List<Sound> sounds;

    public SoundOnDestroyComponent(List<Sound> sounds) {
        this.sounds = sounds;
    }

    public List<Sound> getSounds() {
        return sounds;
    }
}
