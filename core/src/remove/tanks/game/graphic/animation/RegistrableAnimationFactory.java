package remove.tanks.game.graphic.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableAnimationFactory<T extends AnimationPrototype> {
    Animation createAnimation(T prototype, AssetStorage assetStorage, Scale scale);
    Class<T> getFactoryType();
}
