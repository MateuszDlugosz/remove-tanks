package remove.tanks.game.physics.shape;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.utility.position.PositionPrototype;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class CircleShapePrototypeXmlLoader implements RegistrableShapePrototypeXmlLoader<CircleShapePrototype> {
    private static final String RADIUS_ELEMENT = "radius";

    private final PositionPrototypeXmlLoader positionPrototypeXmlLoader;

    public CircleShapePrototypeXmlLoader(PositionPrototypeXmlLoader positionPrototypeXmlLoader) {
        this.positionPrototypeXmlLoader = positionPrototypeXmlLoader;
    }

    @Override
    public CircleShapePrototype loadShapePrototype(XmlReader.Element element) {
        try {
            return new CircleShapePrototype(
                    loadPositionPrototype(element),
                    loadRadius(element)
            );
        } catch (Exception e) {
            throw new ShapePrototypeXmlLoadException(element, e);
        }
    }

    private PositionPrototype loadPositionPrototype(XmlReader.Element element) {
        return element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT) == null
                ? new PositionPrototype(0,0)
                : positionPrototypeXmlLoader.loadPositionPrototype(
                element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT)
        );
    }

    private float loadRadius(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(RADIUS_ELEMENT).getText());
    }

    @Override
    public ShapeType getLoaderType() {
        return ShapeType.CircleShape;
    }
}
