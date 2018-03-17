package remove.tanks.game.level.event.sound;

import com.badlogic.gdx.audio.Sound;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.sound.SoundFactory;
import remove.tanks.game.audio.sound.SoundPrefab;
import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class PlaySoundEvenFactory implements SubEventFactory<PlaySoundEvent, PlaySoundEventPrefab> {
    private final SoundFactory soundFactory;

    public PlaySoundEvenFactory(SoundFactory soundFactory) {
        this.soundFactory = soundFactory;
    }

    @Override
    public PlaySoundEvent createEvent(PlaySoundEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new PlaySoundEvent(
                    createSound(
                            prefab.getSoundPrefab(),
                            registry.getResource(ResourceType.AssetStorageResource, AssetStorage.class)
                    ),
                    prefab.getSoundChannelName()
            );
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    private Sound createSound(SoundPrefab prefab, AssetStorage assetStorage) {
        return soundFactory.createSound(prefab, assetStorage);
    }

    @Override
    public Class<PlaySoundEventPrefab> getFactoryType() {
        return PlaySoundEventPrefab.class;
    }
}
