package remove.tanks.game.level.engine.entity.component.audio;

import com.google.common.base.MoreObjects;
import remove.tanks.game.audio.sound.SoundPrototype;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class SoundOnSpawnComponentPrototype implements ComponentPrototype {
    private final List<SoundPrototype> soundPrototypes;

    public SoundOnSpawnComponentPrototype(List<SoundPrototype> soundPrototypes) {
        this.soundPrototypes = soundPrototypes;
    }

    public List<SoundPrototype> getSoundPrototypes() {
        return soundPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("soundPrototypes", soundPrototypes)
                .toString();
    }
}
