package remove.tanks.game.audio.music;

import com.badlogic.gdx.audio.Music;
import remove.tanks.game.asset.AssetStorage;

/**
 * @author Mateusz Długosz
 */
public final class MusicFactory {
    public Music createMusic(MusicPrototype prototype, AssetStorage assetStorage) {
        try {
            return assetStorage.getAsset(prototype.getFilename(), Music.class);
        } catch (Exception e) {
            throw new MusicCreateException(prototype, e);
        }
    }
}
