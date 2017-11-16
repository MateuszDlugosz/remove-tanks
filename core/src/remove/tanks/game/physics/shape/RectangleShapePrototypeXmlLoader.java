package remove.tanks.game.physics.shape;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.utility.position.PositionPrototype;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class RectangleShapePrototypeXmlLoader
        implements RegistrableShapePrototypeXmlLoader<RectangleShapePrototype>
{
    private static final String WIDTH_ELEMENT = "width";
    private static final String HEIGHT_ELEMENT = "height";

    private final PositionPrototypeXmlLoader positionPrototypeXmlLoader;

    public RectangleShapePrototypeXmlLoader(PositionPrototypeXmlLoader positionPrototypeXmlLoader) {
        this.positionPrototypeXmlLoader = positionPrototypeXmlLoader;
    }

    @Override
    public RectangleShapePrototype loadShapePrototype(XmlReader.Element element) {
        try {
            return new RectangleShapePrototype(
                    loadPositionPrototype(element),
                    loadWidth(element),
                    loadHeight(element)
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

    private float loadWidth(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(WIDTH_ELEMENT).getText());
    }

    private float loadHeight(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(HEIGHT_ELEMENT).getText());
    }

    @Override
    public ShapeType getLoaderType() {
        return ShapeType.RectangleShape;
    }
}
