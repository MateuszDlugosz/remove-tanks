package remove.tanks.game.graphics.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public interface SubAnimationFactory<T extends AnimationPrefab> {
    Animation createAnimation(T prefab, AssetStorage assetStorage, Scale scale);
    Class<T> getFactoryType();
}
