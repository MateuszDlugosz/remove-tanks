package remove.tanks.game.graphic.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class FileSpriteFactory implements RegistrableSpriteFactory<FileSpritePrototype> {
    @Override
    public Sprite createSprite(FileSpritePrototype prototype, AssetStorage assetStorage, Scale scale) {
        try {
            Sprite sprite = new Sprite(assetStorage.getAsset(prototype.getFilename(), Texture.class));
            sprite.setSize(
                    scale.scaleValue(sprite.getWidth()),
                    scale.scaleValue(sprite.getHeight())
            );
            sprite.flip(prototype.getFlipX(), prototype.getFlipY());
            return sprite;
        } catch (Exception e) {
            throw new SpriteCreateException(prototype, e);
        }
    }

    @Override
    public Class<FileSpritePrototype> getFactoryType() {
        return FileSpritePrototype.class;
    }
}
