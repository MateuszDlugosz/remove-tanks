package remove.tanks.game.level.event.entity.music;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.audio.Music;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.music.MusicFactory;
import remove.tanks.game.audio.music.MusicPrefab;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class PlayMusicEntityEventFactory implements SubEntityEventFactory<PlayMusicEntityEvent, PlayMusicEntityEventPrefab> {
    private final MusicFactory musicFactory;

    public PlayMusicEntityEventFactory(MusicFactory musicFactory) {
        this.musicFactory = musicFactory;
    }

    @Override
    public PlayMusicEntityEvent createEntityEvent(PlayMusicEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new PlayMusicEntityEvent(
                    entity,
                    createMusic(
                            prefab.getMusicPrefab(),
                            registry.getResource(ResourceType.AssetStorageResource, AssetStorage.class)
                    ),
                    prefab.getMusicChannelName()
            );
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    private Music createMusic(MusicPrefab prefab, AssetStorage assetStorage) {
        return musicFactory.createMusic(prefab, assetStorage);
    }

    @Override
    public Class<PlayMusicEntityEventPrefab> getFactoryType() {
        return PlayMusicEntityEventPrefab.class;
    }
}
