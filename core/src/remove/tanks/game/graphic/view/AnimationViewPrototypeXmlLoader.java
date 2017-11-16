package remove.tanks.game.graphic.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphic.animation.AnimationPrototype;
import remove.tanks.game.graphic.animation.AnimationPrototypeXmlLoader;
import remove.tanks.game.utility.position.PositionPrototype;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class AnimationViewPrototypeXmlLoader
        implements RegistrableViewPrototypeXmlLoader<AnimationViewPrototype>
{
    private static final String ID_ATTRIBUTE = "id";

    private final PositionPrototypeXmlLoader positionPrototypeXmlLoader;
    private final AnimationPrototypeXmlLoader animationPrototypeXmlLoader;

    public AnimationViewPrototypeXmlLoader(
            PositionPrototypeXmlLoader positionPrototypeXmlLoader,
            AnimationPrototypeXmlLoader animationPrototypeXmlLoader
    ) {
        this.positionPrototypeXmlLoader = positionPrototypeXmlLoader;
        this.animationPrototypeXmlLoader = animationPrototypeXmlLoader;
    }

    @Override
    public AnimationViewPrototype loadViewPrototype(XmlReader.Element element) {
        try {
            return new AnimationViewPrototype(
                    loadId(element),
                    loadPositionPrototype(element),
                    loadAnimationPrototype(element)
            );
        } catch (Exception e) {
            throw new ViewPrototypeXmlLoadException(element, e);
        }
    }

    private String loadId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE);
    }

    private PositionPrototype loadPositionPrototype(XmlReader.Element element) {
        return element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT) == null
                ? new PositionPrototype(0,0)
                : positionPrototypeXmlLoader.loadPositionPrototype(
                element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT)
        );
    }

    private AnimationPrototype loadAnimationPrototype(XmlReader.Element element) {
        return animationPrototypeXmlLoader.loadAnimationPrototype(
                element.getChildByName(AnimationPrototypeXmlLoader.ANIMATION_ELEMENT)
        );
    }

    @Override
    public ViewType getLoaderType() {
        return ViewType.AnimationView;
    }
}
