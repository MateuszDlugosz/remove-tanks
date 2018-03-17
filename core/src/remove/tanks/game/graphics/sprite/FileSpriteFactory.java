package remove.tanks.game.graphics.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class FileSpriteFactory implements SubSpriteFactory<FileSpritePrefab> {
    @Override
    public Sprite createSprite(FileSpritePrefab prefab, AssetStorage assetStorage, Scale scale) {
        try {
            Sprite sprite = new Sprite(assetStorage.getAsset(prefab.getFilename(), Texture.class));
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
    public Class<FileSpritePrefab> getFactoryType() {
        return FileSpritePrefab.class;
    }
}
