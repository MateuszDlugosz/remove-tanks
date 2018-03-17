package remove.tanks.game.utility.properties;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class PropertiesXmlReader {
    public static final String PROPERTIES_ELEMENT = "properties";

    private static final String PROPERTY_ELEMENT = "property";
    private static final String NAME_ATTRIBUTE = "name";

    public Properties readProperties(XmlReader.Element element) {
        try {
            return new Properties(
                    Arrays.stream(element.getChildrenByName(PROPERTY_ELEMENT).toArray())
                            .collect(Collectors.toMap(
                                    e -> e.getAttribute(NAME_ATTRIBUTE).trim(),
                                    XmlReader.Element::getText
                            ))
            );
        } catch (Exception e) {
            throw new PropertiesXmlReadException(element, e);
        }
    }
}
