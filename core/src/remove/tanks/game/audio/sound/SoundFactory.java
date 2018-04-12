package remove.tanks.game.audio.sound;

import com.badlogic.gdx.audio.Sound;
import remove.tanks.game.asset.AssetStorage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SoundFactory {
    public Sound createSound(SoundPrefab prefab, AssetStorage assetStorage) {
        try {
            return assetStorage.getAsset(prefab.getFilename(), Sound.class);
        } catch (Exception e) {
            throw new SoundCreateException(prefab, e);
        }
    }
}
