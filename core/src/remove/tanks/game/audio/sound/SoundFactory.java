package remove.tanks.game.audio.sound;

import com.badlogic.gdx.audio.Sound;
import remove.tanks.game.asset.AssetStorage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SoundFactory {
    public List<Sound> createSounds(List<SoundPrototype> prototypes, AssetStorage assetStorage) {
        return prototypes.stream()
                .map(p -> createSound(p, assetStorage))
                .collect(Collectors.toList());
    }

    public Sound createSound(SoundPrototype prototype, AssetStorage assetStorage) {
        try {
            return assetStorage.getAsset(prototype.getFilename(), Sound.class);
        } catch (Exception e) {
            throw new SoundCreateException(prototype, e);
        }
    }
}
