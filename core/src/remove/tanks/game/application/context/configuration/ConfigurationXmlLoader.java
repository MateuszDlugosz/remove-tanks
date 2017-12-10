package remove.tanks.game.application.context.configuration;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ConfigurationXmlLoader {
    private static final String OPTIONS_ELEMENT = "options";
    private static final String OPTION_ELEMENT = "option";

    private static final String KEY_ATTRIBUTE = "key";

    public static final String COMPONENT_SUPPLIER_PACKAGES_ELEMENT = "componentSupplierPackages";
    public static final String COMPONENT_SUPPLIER_PACKAGE_ELEMENT = "componentSupplierPackage";

    private final XmlReader xmlReader;

    public ConfigurationXmlLoader(XmlReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    public Configuration loadConfiguration(FileHandle fileHandle) {
        try {
            XmlReader.Element element = xmlReader.parse(fileHandle);
            return new Configuration(
                    loadOptions(element),
                    loadComponentSupplierPackages(element)
            );
        } catch (Exception e) {
            throw new ConfigurationXmlLoadException(e);
        }
    }

    private Map<String, String> loadOptions(XmlReader.Element element) {
        return Arrays.stream(element.getChildByName(OPTIONS_ELEMENT)
                .getChildrenByName(OPTION_ELEMENT)
                .toArray())
                .collect(Collectors.toMap(
                        e -> e.getAttribute(KEY_ATTRIBUTE),
                        XmlReader.Element::getText
                ));
    }

    private List<String> loadComponentSupplierPackages(XmlReader.Element element) {
        return Arrays.stream(element.getChildByName(COMPONENT_SUPPLIER_PACKAGES_ELEMENT)
                .getChildrenByName(COMPONENT_SUPPLIER_PACKAGE_ELEMENT)
                .toArray())
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
    }
}
