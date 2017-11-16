package remove.tanks.game.utility.position;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class PositionPrototypeXmlLoader {
    public static final String POSITION_ELEMENT = "position";
    public static final String POSITIONS_ELEMENT = "positions";

    private static final String X_ELEMENT = "x";
    private static final String Y_ELEMENT = "y";

    public List<PositionPrototype> loadPositionPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(POSITION_ELEMENT).toArray())
                .map(this::loadPositionPrototype)
                .collect(Collectors.toList());
    }

    public PositionPrototype loadPositionPrototype(XmlReader.Element element) {
        try {
            return new PositionPrototype(
                    Float.valueOf(element.getChildByName(X_ELEMENT).getText().trim()),
                    Float.valueOf(element.getChildByName(Y_ELEMENT).getText().trim())
            );
        } catch (Exception e) {
            throw new PositionPrototypeXmlLoadException(element, e);
        }
    }
}
