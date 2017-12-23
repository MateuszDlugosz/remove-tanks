package remove.tanks.game.audio.sound;

import com.badlogic.gdx.audio.Sound;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;
import remove.tanks.game.asset.AssetManagerFactory;
import remove.tanks.game.asset.AssetPrototype;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.asset.AssetStorageFactory;
import remove.tanks.game.asset.parameter.ParametersFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class SoundFactoryTest extends LibGDXTest {
    private AssetStorageFactory assetStorageFactory;
    private SoundFactory soundFactory;

    @Before
    public void initTestObjects() {
        assetStorageFactory = new AssetStorageFactory(
                new ParametersFactory(),
                new AssetManagerFactory(
                        new HashMap<>()
                )
        );
        soundFactory = new SoundFactory();
    }

    @Test
    public void when_SoundExistsInAssetStorage_Then_LoadSound() {
        List<AssetPrototype> assetPrototypes = new ArrayList<>();
        assetPrototypes.add(new AssetPrototype("testId0", Sound.class,
                "audio/sound/test-sound-0.ogg", null));
        assetPrototypes.add(new AssetPrototype("testId1", Sound.class,
                "audio/sound/test-sound-1.ogg", null));
        AssetStorage assetStorage = assetStorageFactory.createAssetStorage(assetPrototypes);

        SoundPrototype soundPrototype0 = new SoundPrototype("testId0");
        SoundPrototype soundPrototype1 = new SoundPrototype("testId1");

        Sound sound0 = soundFactory.createSound(soundPrototype0, assetStorage);
        Sound sound1 = soundFactory.createSound(soundPrototype1, assetStorage);

        assertEquals(sound0, assetStorage.getAsset("testId0", Sound.class));
        assertEquals(sound1, assetStorage.getAsset("testId1", Sound.class));
    }

    @Test(expected = SoundCreateException.class)
    public void when_SoundNotExistsInAssetStorage_Then_ThrowException() {
        AssetStorage assetStorage = assetStorageFactory.createAssetStorage(new ArrayList<>());
        SoundPrototype prototype = new SoundPrototype("textFilename");
        soundFactory.createSound(prototype, assetStorage);
    }

    @Test
    public void when_SoundsExistsInAssetStorage_Then_LoadSounds() {
        List<AssetPrototype> assetPrototypes = new ArrayList<>();
        assetPrototypes.add(new AssetPrototype("testId0", Sound.class,
                "audio/sound/test-sound-0.ogg", null));
        assetPrototypes.add(new AssetPrototype("testId1", Sound.class,
                "audio/sound/test-sound-1.ogg", null));
        AssetStorage assetStorage = assetStorageFactory.createAssetStorage(assetPrototypes);

        List<SoundPrototype> soundPrototypes = new ArrayList<>();
        soundPrototypes.add(new SoundPrototype("testId0"));
        soundPrototypes.add(new SoundPrototype("testId1"));

        List<Sound> sounds = soundFactory.createSounds(soundPrototypes, assetStorage);

        assertEquals(sounds.get(0), assetStorage.getAsset("testId0", Sound.class));
        assertEquals(sounds.get(1), assetStorage.getAsset("testId1", Sound.class));
    }

    @Test(expected = SoundCreateException.class)
    public void when_SoundsNotExistsInAssetStorage_Then_ThrowException() {
        AssetStorage assetStorage = assetStorageFactory.createAssetStorage(new ArrayList<>());
        List<SoundPrototype> soundPrototypes = new ArrayList<>();
        soundPrototypes.add(new SoundPrototype("testFilename0"));
        soundPrototypes.add(new SoundPrototype("testFilename1"));
        soundFactory.createSounds(soundPrototypes, assetStorage);
    }
}