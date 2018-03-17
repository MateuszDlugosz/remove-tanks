package remove.tanks.game.graphics.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.animation.AnimationPrefab;
import remove.tanks.game.graphics.animation.AnimationPrefabXmlReader;
import remove.tanks.game.utility.surface.position.PositionPrefab;
import remove.tanks.game.utility.surface.position.PositionPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AnimationViewPrefabXmlReader implements SubViewPrefabXmlReader<AnimationViewPrefab>
{
    private static final String ID_ATTRIBUTE = "id";

    private final PositionPrefabXmlReader positionPrefabXmlReader;
    private final AnimationPrefabXmlReader animationPrefabXmlReader;

    public AnimationViewPrefabXmlReader(
            PositionPrefabXmlReader positionPrefabXmlReader,
            AnimationPrefabXmlReader animationPrefabXmlReader
    ) {
        this.positionPrefabXmlReader = positionPrefabXmlReader;
        this.animationPrefabXmlReader = animationPrefabXmlReader;
    }

    @Override
    public AnimationViewPrefab readViewPrefab(XmlReader.Element element) {
        try {
            return new AnimationViewPrefab(
                    readId(element),
                    readPositionPrefab(element),
                    readAnimationPrefab(element)
            );
        } catch (Exception e) {
            throw new ViewPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE);
    }

    private PositionPrefab readPositionPrefab(XmlReader.Element element) {
        return element.getChildByName(PositionPrefabXmlReader.POSITION_ELEMENT) == null
                ? PositionPrefab.POSITION_PREFAB_ZERO
                : positionPrefabXmlReader.readPositionPrefab(
                element.getChildByName(PositionPrefabXmlReader.POSITION_ELEMENT)
        );
    }

    private AnimationPrefab readAnimationPrefab(XmlReader.Element element) {
        return animationPrefabXmlReader.readAnimationPrefab(
                element.getChildByName(AnimationPrefabXmlReader.ANIMATION_ELEMENT)
        );
    }

    @Override
    public ViewType getReaderType() {
        return ViewType.AnimationView;
    }
}
