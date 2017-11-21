package remove.tanks.game.level.engine.entity.component.audio;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.audio.Sound;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.sound.SoundFactory;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class SoundOnSpawnComponentFactory
        implements RegistrableComponentFactory<SoundOnSpawnComponent, SoundOnSpawnComponentPrototype>
{
    private final SoundFactory soundFactory;

    public SoundOnSpawnComponentFactory(SoundFactory soundFactory) {
        this.soundFactory = soundFactory;
    }

    @Override
    public SoundOnSpawnComponent createComponent(SoundOnSpawnComponentPrototype prototype, Level level, Entity entity) {
        return new SoundOnSpawnComponent(
                createSounds(prototype, level)
        );
    }

    private List<Sound> createSounds(SoundOnSpawnComponentPrototype prototype, Level level) {
        return soundFactory.createSounds(
                prototype.getSoundPrototypes(),
                level.getResourceRegistry().getResource(
                        LevelResource.AssetStorage.toString(),
                        AssetStorage.class
                )
        );
    }

    @Override
    public Class<SoundOnSpawnComponentPrototype> getFactoryType() {
        return SoundOnSpawnComponentPrototype.class;
    }
}
