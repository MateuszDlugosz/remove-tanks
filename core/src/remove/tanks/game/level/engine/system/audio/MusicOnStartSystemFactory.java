package remove.tanks.game.level.engine.system.audio;

import com.badlogic.gdx.audio.Music;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.music.MusicFactory;
import remove.tanks.game.audio.music.MusicPrototype;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class MusicOnStartSystemFactory
        implements RegistrableEntitySystemFactory<MusicOnStartSystem, MusicOnStartSystemPrototype>
{
    private final MusicFactory musicFactory;

    public MusicOnStartSystemFactory(MusicFactory musicFactory) {
        this.musicFactory = musicFactory;
    }

    @Override
    public MusicOnStartSystem createEntitySystem(MusicOnStartSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new MusicOnStartSystem(
                    prototype.getPriority(),
                    resourceRegistry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                    createMusic(
                            prototype.getMusicPrototype(),
                            resourceRegistry.getResource(
                                    LevelResource.AssetStorage.toString(), AssetStorage.class)
                    )
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    private Music createMusic(MusicPrototype prototype, AssetStorage assetStorage) {
        return musicFactory.createMusic(prototype, assetStorage);
    }

    @Override
    public Class<MusicOnStartSystemPrototype> getFactoryType() {
        return MusicOnStartSystemPrototype.class;
    }
}
