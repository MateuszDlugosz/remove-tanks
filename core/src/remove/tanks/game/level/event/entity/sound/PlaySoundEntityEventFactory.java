package remove.tanks.game.level.event.entity.sound;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.audio.Sound;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.sound.SoundFactory;
import remove.tanks.game.audio.sound.SoundPrefab;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class PlaySoundEntityEventFactory implements SubEntityEventFactory<PlaySoundEntityEvent, PlaySoundEntityEventPrefab> {
    private final SoundFactory soundFactory;

    public PlaySoundEntityEventFactory(SoundFactory soundFactory) {
        this.soundFactory = soundFactory;
    }

    @Override
    public PlaySoundEntityEvent createEntityEvent(PlaySoundEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new PlaySoundEntityEvent(
                    entity,
                    createSound(
                            prefab.getSoundPrefab(),
                            registry.getResource(ResourceType.AssetStorageResource, AssetStorage.class)
                    ),
                    prefab.getSoundChannelName()
            );
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    private Sound createSound(SoundPrefab soundPrefab, AssetStorage assetStorage) {
        return soundFactory.createSound(soundPrefab, assetStorage);
    }

    @Override
    public Class<PlaySoundEntityEventPrefab> getFactoryType() {
        return PlaySoundEntityEventPrefab.class;
    }
}
