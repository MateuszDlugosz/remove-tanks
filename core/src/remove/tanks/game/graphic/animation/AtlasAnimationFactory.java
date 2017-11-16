package remove.tanks.game.graphic.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class AtlasAnimationFactory implements RegistrableAnimationFactory<AtlasAnimationPrototype> {
    @Override
    public Animation createAnimation(AtlasAnimationPrototype prototype, AssetStorage assetStorage, Scale scale) {
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

    private Array<Sprite> createFrames(AtlasAnimationPrototype prototype, AssetStorage assetStorage, Scale scale) {
        Array<Sprite> frames = new Array<>();
        TextureAtlas atlas = assetStorage.getAsset(prototype.getAtlasFilename(), TextureAtlas.class);
        prototype.getRegionNames().forEach(r -> {
            Sprite sprite = atlas.createSprite(r);
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
    public Class<AtlasAnimationPrototype> getFactoryType() {
        return AtlasAnimationPrototype.class;
    }
}
