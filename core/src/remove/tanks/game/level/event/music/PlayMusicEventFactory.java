package remove.tanks.game.level.event.music;

import com.badlogic.gdx.audio.Music;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.music.MusicFactory;
import remove.tanks.game.audio.music.MusicPrefab;
import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class PlayMusicEventFactory implements SubEventFactory<PlayMusicEvent, PlayMusicEventPrefab> {
    private final MusicFactory musicFactory;

    public PlayMusicEventFactory(MusicFactory musicFactory) {
        this.musicFactory = musicFactory;
    }

    @Override
    public PlayMusicEvent createEvent(PlayMusicEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new PlayMusicEvent(
                    createMusic(
                            prefab.getMusicPrefab(),
                            registry.getResource(ResourceType.AssetStorageResource, AssetStorage.class)
                    ),
                    prefab.getMusicChannelName()
            );
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    private Music createMusic(MusicPrefab prefab, AssetStorage assetStorage) {
        return musicFactory.createMusic(prefab, assetStorage);
    }

    @Override
    public Class<PlayMusicEventPrefab> getFactoryType() {
        return PlayMusicEventPrefab.class;
    }
}
