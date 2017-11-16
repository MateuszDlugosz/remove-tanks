package remove.tanks.game.graphic.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class FileAnimationFactory implements RegistrableAnimationFactory<FileAnimationPrototype> {
    @Override
    public Animation createAnimation(FileAnimationPrototype prototype, AssetStorage assetStorage, Scale scale) {
        try {
            return new Animation(
                    prototype.getFrameDuration(),
                    createFrames(prototype, assetStorage, scale),
                    prototype.getPlayMode()
            );
        } catch (Exception e) {
            throw new AnimationCreateException(prototype, e);
        }
    }

    private Array<Sprite> createFrames(FileAnimationPrototype prototype, AssetStorage assetStorage, Scale scale) {
        Array<Sprite> frames = new Array<>();
        prototype.getFilenames().forEach(f -> {
            Sprite sprite = new Sprite(assetStorage.getAsset(f, Texture.class));
            sprite.setSize(
                    scale.scaleValue(sprite.getWidth()),
                    scale.scaleValue(sprite.getHeight())
            );
            sprite.flip(prototype.getFlipX(), prototype.getFlipY());
            frames.add(sprite);
        });
        return frames;
    }

    @Override
    public Class<FileAnimationPrototype> getFactoryType() {
        return FileAnimationPrototype.class;
    }
}
