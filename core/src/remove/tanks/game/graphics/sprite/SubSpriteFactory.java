package remove.tanks.game.graphics.sprite;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public interface SubSpriteFactory<T extends SpritePrefab> {
    Sprite createSprite(T prefab, AssetStorage assetStorage, Scale scale);
    Class<T> getFactoryType();
}
