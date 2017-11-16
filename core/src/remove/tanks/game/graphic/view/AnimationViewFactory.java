package remove.tanks.game.graphic.view;

import com.badlogic.gdx.graphics.g2d.Animation;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphic.animation.AnimationFactory;
import remove.tanks.game.graphic.animation.AnimationPrototype;
import remove.tanks.game.utility.position.Position;
import remove.tanks.game.utility.position.PositionFactory;
import remove.tanks.game.utility.position.PositionPrototype;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class AnimationViewFactory implements RegistrableViewFactory<AnimationView, AnimationViewPrototype> {
    private final PositionFactory positionFactory;
    private final AnimationFactory animationFactory;

    public AnimationViewFactory(PositionFactory positionFactory, AnimationFactory animationFactory) {
        this.positionFactory = positionFactory;
        this.animationFactory = animationFactory;
    }

    @Override
    public AnimationView createView(AnimationViewPrototype prototype, AssetStorage assetStorage, Scale scale) {
        try {
            return new AnimationView(
                    prototype.getId(),
                    createPosition(prototype, scale),
                    createAnimation(prototype, assetStorage, scale)
            );
        } catch (Exception e) {
            throw new ViewCreateException(prototype, e);
        }
    }

    private Position createPosition(AnimationViewPrototype prototype, Scale scale) {
        return positionFactory.createPosition(prototype.getPositionPrototype(), scale);
    }

    private Animation createAnimation(AnimationViewPrototype prototype, AssetStorage assetStorage, Scale scale) {
        return animationFactory.createAnimation(prototype.getAnimationPrototype(), assetStorage, scale);
    }

    @Override
    public Class<AnimationViewPrototype> getFactoryType() {
        return AnimationViewPrototype.class;
    }
}
