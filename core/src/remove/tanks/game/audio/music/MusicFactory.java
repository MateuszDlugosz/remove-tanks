package remove.tanks.game.audio.music;

import com.badlogic.gdx.audio.Music;
import remove.tanks.game.asset.AssetStorage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class MusicFactory {
    public List<Music> createMusics(List<MusicPrefab> prefabs, AssetStorage assetStorage) {
        return prefabs.stream()
                .map(p -> createMusic(p, assetStorage))
                .collect(Collectors.toList());
    }

    public Music createMusic(MusicPrefab prefab, AssetStorage assetStorage) {
        try {
            return assetStorage.getAsset(prefab.getFilename(), Music.class);
        } catch (Exception e) {
            throw new MusicCreateException(prefab, e);
        }
    }
}
