package remove.tanks.game.graphic.sprite;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableSpriteFactory<T extends SpritePrototype> {
    Sprite createSprite(T prototype, AssetStorage assetStorage, Scale scale);
    Class<T> getFactoryType();
}
