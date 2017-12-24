package remove.tanks.game.audio.music;

import com.badlogic.gdx.audio.Music;
import remove.tanks.game.asset.AssetStorage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class MusicFactory {
    public List<Music> createMusics(List<MusicPrototype> prototypes, AssetStorage assetStorage) {
        return prototypes.stream()
                .map(p -> createMusic(p, assetStorage))
                .collect(Collectors.toList());
    }

    public Music createMusic(MusicPrototype prototype, AssetStorage assetStorage) {
        try {
            return assetStorage.getAsset(prototype.getFilename(), Music.class);
        } catch (Exception e) {
            throw new MusicCreateException(prototype, e);
        }
    }
}
