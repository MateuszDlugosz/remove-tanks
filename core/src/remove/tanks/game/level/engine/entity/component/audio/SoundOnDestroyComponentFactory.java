package remove.tanks.game.level.engine.entity.component.audio;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.audio.Sound;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.sound.SoundFactory;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class SoundOnDestroyComponentFactory
        implements RegistrableComponentFactory<SoundOnDestroyComponent, SoundOnDestroyComponentPrototype>
{
    private final SoundFactory soundFactory;

    public SoundOnDestroyComponentFactory(SoundFactory soundFactory) {
        this.soundFactory = soundFactory;
    }

    @Override
    public SoundOnDestroyComponent createComponent(SoundOnDestroyComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new SoundOnDestroyComponent(
                    createSounds(prototype, level)
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    private List<Sound> createSounds(SoundOnDestroyComponentPrototype prototype, Level level) {
        return soundFactory.createSounds(
                prototype.getSoundPrototypes(),
                level.getResourceRegistry().getResource(
                        LevelResource.AssetStorage.toString(),
                        AssetStorage.class
                )
        );
    }

    @Override
    public Class<SoundOnDestroyComponentPrototype> getFactoryType() {
        return SoundOnDestroyComponentPrototype.class;
    }
}
