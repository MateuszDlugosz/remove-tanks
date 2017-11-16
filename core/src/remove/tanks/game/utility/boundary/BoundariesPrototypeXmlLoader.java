package remove.tanks.game.utility.boundary;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class BoundariesPrototypeXmlLoader {
    public static final String BOUNDARIES_ELEMENT = "boundaries";

    private static final String MIN_X_ELEMENT = "minX";
    private static final String MAX_X_ELEMENT = "maxX";
    private static final String MIN_Y_ELEMENT = "minY";
    private static final String MAX_Y_ELEMENT = "maxY";

    public BoundariesPrototype loadBoundariesPrototype(XmlReader.Element element) {
        try {
            return new BoundariesPrototype(
                    Float.valueOf(element.getChildByName(MIN_X_ELEMENT).getText().trim()),
                    Float.valueOf(element.getChildByName(MAX_X_ELEMENT).getText().trim()),
                    Float.valueOf(element.getChildByName(MIN_Y_ELEMENT).getText().trim()),
                    Float.valueOf(element.getChildByName(MAX_Y_ELEMENT).getText().trim())
            );
        } catch (Exception e) {
            throw new BoundariesPrototypeXmlLoadException(element, e);
        }
    }
}
