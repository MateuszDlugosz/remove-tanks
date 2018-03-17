package remove.tanks.game.level.resource.configuration;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.properties.PropertiesXmlReader;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ResourceConfigurationsXmlReader {
    public static final String RESOURCE_CONFIGURATIONS_ELEMENT = "resourceConfigurations";
    public static final String RESOURCE_CONFIGURATION_ELEMENT = "resourceConfiguration";

    private static final String RESOURCE_TYPE_ATTRIBUTE = "resourceType";

    private final PropertiesXmlReader propertiesXmlReader;

    public ResourceConfigurationsXmlReader(PropertiesXmlReader propertiesXmlReader) {
        this.propertiesXmlReader = propertiesXmlReader;
    }

    public ResourceConfigurations readResourceConfiguration(XmlReader.Element element) {
        try {
            return new ResourceConfigurations(readResourceProperties(element));
        } catch (Exception e) {
            throw new ResourceConfigurationsXmlReadException(element, e);
        }
    }

    private Map<ResourceType, Properties> readResourceProperties(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(RESOURCE_CONFIGURATION_ELEMENT).toArray())
                .collect(Collectors.toMap(this::readResourceType, this::readProperties));
    }

    private ResourceType readResourceType(XmlReader.Element element) {
        return ResourceType.valueOf(element.getAttribute(RESOURCE_TYPE_ATTRIBUTE));
    }

    private Properties readProperties(XmlReader.Element element) {
        return propertiesXmlReader.readProperties(element.getChildByName(PropertiesXmlReader.PROPERTIES_ELEMENT));
    }
}
