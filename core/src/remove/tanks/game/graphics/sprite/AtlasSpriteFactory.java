package remove.tanks.game.graphics.sprite;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class AtlasSpriteFactory implements SubSpriteFactory<AtlasSpritePrefab> {
    @Override
    public Sprite createSprite(AtlasSpritePrefab prefab, AssetStorage assetStorage, Scale scale) {
        try {
            Sprite sprite = new Sprite(assetStorage.getAsset(
                    prefab.getAtlasFilename(), TextureAtlas.class).findRegion(prefab.getRegionName()
            ));
            sprite.setSize(
                    scale.scaleValue(sprite.getWidth()),
                    scale.scaleValue(sprite.getHeight())
            );
            sprite.flip(prefab.getFlipX(), prefab.getFlipY());
            return sprite;
        } catch (Exception e) {
            throw new SpriteCreateException(prefab, e);
        }
    }

    @Override
    public Class<AtlasSpritePrefab> getFactoryType() {
        return AtlasSpritePrefab.class;
    }
}
