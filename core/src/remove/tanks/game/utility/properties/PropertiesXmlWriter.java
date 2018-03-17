package remove.tanks.game.utility.properties;

import com.badlogic.gdx.utils.XmlWriter;

import java.io.StringWriter;

/**
 * @author Mateusz Długosz
 */
public final class PropertiesXmlWriter {
    private static final String PROPERTIES_ELEMENT = "properties";
    private static final String PROPERTY_ELEMENT = "property";
    private static final String NAME_ATTRIBUTE = "name";

    public String writeProperties(Properties properties) {
        try {
            StringWriter stringWriter = new StringWriter();
            XmlWriter xmlWriter = new XmlWriter(stringWriter);

            xmlWriter.element(PROPERTIES_ELEMENT);
                for (String key : properties.getKeys()) {
                    xmlWriter.element(PROPERTY_ELEMENT);
                    xmlWriter.attribute(NAME_ATTRIBUTE, key);
                    xmlWriter.text(properties.getString(key));
                    xmlWriter.pop();
                }
            xmlWriter.pop();
            xmlWriter.close();

            return stringWriter.toString();
        } catch (Exception e) {
            throw new PropertiesXmlWriteException(e);
        }
    }
}
