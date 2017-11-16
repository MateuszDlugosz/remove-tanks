package remove.tanks.game.level.engine.utility.direction;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class DirectionXmlLoader {
    public static final String DIRECTION_ELEMENT = "direction";

    public Direction loadDirection(XmlReader.Element element) {
        try {
            return Direction.valueOf(element.getText().trim());
        } catch (Exception e) {
            throw new DirectionXmlLoadException(element, e);
        }
    }
}
