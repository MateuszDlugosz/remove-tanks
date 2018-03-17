package remove.tanks.game.graphics.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class FileAnimationFactory implements SubAnimationFactory<FileAnimationPrefab> {
    @Override
    public Animation createAnimation(FileAnimationPrefab prefab, AssetStorage assetStorage, Scale scale) {
        try {
            return new Animation(
                    prefab.getFrameDuration(),
                    createFrames(prefab, assetStorage, scale),
                    prefab.getPlayMode()
            );
        } catch (Exception e) {
            throw new AnimationCreateException(prefab, e);
        }
    }

    private Array<Sprite> createFrames(FileAnimationPrefab prefab, AssetStorage assetStorage, Scale scale) {
        Array<Sprite> frames = new Array<>();
        prefab.getFilenames().forEach(f -> {
            Sprite sprite = new Sprite(assetStorage.getAsset(f, Texture.class));
            sprite.setSize(
                    scale.scaleValue(sprite.getWidth()),
                    scale.scaleValue(sprite.getHeight())
            );
            sprite.flip(prefab.getFlipX(), prefab.getFlipY());
            frames.add(sprite);
        });
        return frames;
    }

    @Override
    public Class<FileAnimationPrefab> getFactoryType() {
        return FileAnimationPrefab.class;
    }
}
