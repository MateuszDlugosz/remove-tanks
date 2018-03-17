package remove.tanks.game.graphics.view;

import com.badlogic.gdx.graphics.g2d.Animation;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.animation.AnimationFactory;
import remove.tanks.game.utility.scale.Scale;
import remove.tanks.game.utility.surface.position.Position;
import remove.tanks.game.utility.surface.position.PositionFactory;

/**
 * @author Mateusz Długosz
 */
public final class AnimationViewFactory implements SubViewFactory<AnimationView, AnimationViewPrefab> {
    private final PositionFactory positionFactory;
    private final AnimationFactory animationFactory;

    public AnimationViewFactory(PositionFactory positionFactory, AnimationFactory animationFactory) {
        this.positionFactory = positionFactory;
        this.animationFactory = animationFactory;
    }

    @Override
    public AnimationView createView(AnimationViewPrefab prefab, AssetStorage assetStorage, Scale scale) {
        try {
            return new AnimationView(
                    prefab.getId(),
                    createPosition(prefab, scale),
                    createAnimation(prefab, assetStorage, scale)
            );
        } catch (Exception e) {
            throw new ViewCreateException(prefab, e);
        }
    }

    private Position createPosition(AnimationViewPrefab prefab, Scale scale) {
        return positionFactory.createPosition(prefab.getPositionPrefab(), scale);
    }

    private Animation createAnimation(AnimationViewPrefab prefab, AssetStorage assetStorage, Scale scale) {
        return animationFactory.createAnimation(prefab.getAnimationPrefab(), assetStorage, scale);
    }

    @Override
    public Class<AnimationViewPrefab> getFactoryType() {
        return AnimationViewPrefab.class;
    }
}
