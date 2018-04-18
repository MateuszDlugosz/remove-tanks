package remove.tanks.game.application.context.configuration;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class ConfigurationXmlReader {
    private static final String OPTIONS_ELEMENT = "options";
    private static final String OPTION_ELEMENT = "option";
    private static final String NAME_ATTRIBUTE = "name";

    public Configuration readConfiguration(File file) {
        try {
            Element element = getRootElement(file);
            Element optionsElement = (Element) element.getElementsByTagName(OPTIONS_ELEMENT).item(0);
            NodeList optionsElements = optionsElement.getElementsByTagName(OPTION_ELEMENT);
            Map<String, String> options = new HashMap<>();

            for (int i = 0; i < optionsElements.getLength(); i++) {
                options.put(
                        optionsElements.item(i).getAttributes().getNamedItem(NAME_ATTRIBUTE).getTextContent().trim(),
                        optionsElements.item(i).getTextContent().trim()
                );
            }

            return new Configuration(options);
        } catch (Exception e) {
            throw new ConfigurationXmlReadException(file, e);
        }
    }

    private Element getRootElement(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.normalizeDocument();

        return doc.getDocumentElement();
    }
}
