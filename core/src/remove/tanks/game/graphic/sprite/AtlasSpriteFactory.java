package remove.tanks.game.graphic.sprite;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class AtlasSpriteFactory implements RegistrableSpriteFactory<AtlasSpritePrototype> {
    @Override
    public Sprite createSprite(AtlasSpritePrototype prototype, AssetStorage assetStorage, Scale scale) {
        try {
            Sprite sprite = new Sprite(assetStorage.getAsset(
                    prototype.getAtlasFilename(), TextureAtlas.class).findRegion(prototype.getRegionName()
            ));
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
    public Class<AtlasSpritePrototype> getFactoryType() {
        return AtlasSpritePrototype.class;
    }
}
