package remove.tanks.game.desktop.display;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class DisplayDimensionResolverXmlReader {
    private static final String DIMENSION_ELEMENT = "dimension";
    private static final String RATIO_ELEMENT = "ratio";
    private static final String TARGET_ELEMENT = "target";
    private static final String WIDTH_ATTRIBUTE = "width";
    private static final String HEIGHT_ATTRIBUTE = "height";

    public DisplayDimensionResolver readDisplayDimensionResolver(File file, Dimension defaultDimension) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(file);
            document.getDocumentElement().normalize();
            Element element = document.getDocumentElement();

            return new DisplayDimensionResolver(
                    defaultDimension,
                    readDimensionMap(element)
            );
        } catch (Exception e) {
            throw new DisplayDimensionResolverXmlReadException(file, e);
        }
    }

    private Map<Double, Dimension> readDimensionMap(Element element) {
        Map<Double, Dimension> dimensionMap = new HashMap<>();
        NodeList nodeList = element.getElementsByTagName(DIMENSION_ELEMENT);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element dimensionElement = (Element) nodeList.item(i);
            double ratioWidth = Double.valueOf(dimensionElement.getElementsByTagName(RATIO_ELEMENT).item(0)
                    .getAttributes().getNamedItem(WIDTH_ATTRIBUTE).getTextContent());
            double ratioHeight = Double.valueOf(dimensionElement.getElementsByTagName(RATIO_ELEMENT).item(0)
                    .getAttributes().getNamedItem(HEIGHT_ATTRIBUTE).getTextContent());

            Dimension dimension = new Dimension();
            dimension.width = Integer.valueOf(dimensionElement.getElementsByTagName(TARGET_ELEMENT).item(0)
                    .getAttributes().getNamedItem(WIDTH_ATTRIBUTE).getTextContent());
            dimension.height = Integer.valueOf(dimensionElement.getElementsByTagName(TARGET_ELEMENT).item(0)
                    .getAttributes().getNamedItem(HEIGHT_ATTRIBUTE).getTextContent());

            dimensionMap.put(ratioWidth / ratioHeight, dimension);
        }
        return dimensionMap;
    }
}
