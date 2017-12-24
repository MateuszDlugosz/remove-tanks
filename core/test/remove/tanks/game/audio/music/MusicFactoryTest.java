package remove.tanks.game.audio.music;

import com.badlogic.gdx.audio.Music;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;
import remove.tanks.game.asset.AssetManagerFactory;
import remove.tanks.game.asset.AssetPrototype;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.asset.AssetStorageFactory;
import remove.tanks.game.asset.parameter.ParametersFactory;
import remove.tanks.game.asset.parameter.ParticleEffectParametersFactory;
import remove.tanks.game.asset.parameter.RegistrableParametersFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class MusicFactoryTest extends LibGDXTest {
    private AssetStorageFactory assetStorageFactory;
    private MusicFactory musicFactory;

    @Before
    public void initTestObjects() {
        assetStorageFactory = new AssetStorageFactory(
                new ParametersFactory(
                        new RegistrableParametersFactory[] {
                                new ParticleEffectParametersFactory()
                        }
                ),
                new AssetManagerFactory(
                        new HashMap<>()
                )
        );
        musicFactory = new MusicFactory();
    }

    @Test
    public void when_MusicExistsInAssetStorage_Then_LoadMusic() {
        List<AssetPrototype> assetPrototypes = new ArrayList<>();
        assetPrototypes.add(new AssetPrototype("testId0", Music.class,
                "audio/music/test-music-0.ogg", null));
        assetPrototypes.add(new AssetPrototype("testId1", Music.class,
                "audio/music/test-music-1.ogg", null));
        AssetStorage assetStorage = assetStorageFactory.createAssetStorage(assetPrototypes);

        MusicPrototype musicPrototype0 = new MusicPrototype("testId0");
        MusicPrototype musicPrototype1 = new MusicPrototype("testId1");

        Music music0 = musicFactory.createMusic(musicPrototype0, assetStorage);
        Music music1 = musicFactory.createMusic(musicPrototype1, assetStorage);

        assertEquals(music0, assetStorage.getAsset("testId0", Music.class));
        assertEquals(music1, assetStorage.getAsset("testId1", Music.class));
    }

    @Test(expected = MusicCreateException.class)
    public void when_MusicNotExistsInAssetStorage_Then_ThrowException() {
        AssetStorage assetStorage = assetStorageFactory.createAssetStorage(new ArrayList<>());
        MusicPrototype musicPrototype = new MusicPrototype("testFilename");
        musicFactory.createMusic(musicPrototype, assetStorage);
    }

    @Test
    public void when_MusicsExistsInAssetStorage_Then_LoadMusics() {
        List<AssetPrototype> assetPrototypes = new ArrayList<>();
        assetPrototypes.add(new AssetPrototype("testId0", Music.class,
                "audio/music/test-music-0.ogg", null));
        assetPrototypes.add(new AssetPrototype("testId1", Music.class,
                "audio/music/test-music-1.ogg", null));
        AssetStorage assetStorage = assetStorageFactory.createAssetStorage(assetPrototypes);

        List<MusicPrototype> musicPrototypes = new ArrayList<>();
        musicPrototypes.add(new MusicPrototype("testId0"));
        musicPrototypes.add(new MusicPrototype("testId1"));

        List<Music> musics = musicFactory.createMusics(musicPrototypes, assetStorage);

        assertEquals(musics.get(0), assetStorage.getAsset("testId0", Music.class));
        assertEquals(musics.get(1), assetStorage.getAsset("testId1", Music.class));
    }

    @Test(expected = MusicCreateException.class)
    public void when_MusicsNotExistsInAssetStorage_Then_ThrowException() {
        AssetStorage assetStorage = assetStorageFactory.createAssetStorage(new ArrayList<>());
        List<MusicPrototype> musicPrototypes = new ArrayList<>();
        musicPrototypes.add(new MusicPrototype("testFilename0"));
        musicPrototypes.add(new MusicPrototype("testFilename1"));
        musicFactory.createMusics(musicPrototypes, assetStorage);
    }
}