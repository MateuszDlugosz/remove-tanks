package remove.tanks.game.level.engine.system.music;

import com.badlogic.gdx.audio.Music;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.music.MusicFactory;
import remove.tanks.game.audio.music.MusicPrefab;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class MusicOnStartSystemFactory implements SubEntitySystemFactory<MusicOnStartSystem, MusicOnStartSystemPrefab> {
    private final MusicFactory musicFactory;

    public MusicOnStartSystemFactory(MusicFactory musicFactory) {
        this.musicFactory = musicFactory;
    }

    @Override
    public MusicOnStartSystem createEntitySystem(MusicOnStartSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new MusicOnStartSystem(
                    prefab.getPriority(),
                    createMusic(prefab.getMusicPrefab(), registry.getResource(
                            ResourceType.AssetStorageResource, AssetStorage.class)),
                    prefab.getMusicChannelName(),
                    registry.getResource(ResourceType.EventBusResource, EventBus.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    private Music createMusic(MusicPrefab prefab, AssetStorage assetStorage) {
        return musicFactory.createMusic(prefab, assetStorage);
    }

    @Override
    public Class<MusicOnStartSystemPrefab> getFactoryType() {
        return MusicOnStartSystemPrefab.class;
    }
}
