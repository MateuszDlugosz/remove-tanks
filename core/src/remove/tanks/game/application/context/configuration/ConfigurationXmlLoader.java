package remove.tanks.game.application.context.configuration;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ConfigurationXmlLoader {
    public static final String OPTIONS_ELEMENT = "options";
    public static final String OPTION_ELEMENT = "option";

    public static final String KEY_ATTRIBUTE = "key";

    public static final String COMPONENT_SUPPLIER_PACKAGES_ELEMENT = "componentSupplierPackages";
    public static final String COMPONENT_SUPPLIER_PACKAGE_ELEMENT = "componentSupplierPackage";

    private final XmlReader xmlReader;

    public ConfigurationXmlLoader(XmlReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    public Configuration loadConfiguration(FileHandle fileHandle) {
        try {
            XmlReader.Element rootElement = xmlReader.parse(fileHandle);
            return new Configuration(
                    Arrays.stream(rootElement.getChildByName(OPTIONS_ELEMENT)
                            .getChildrenByName(OPTION_ELEMENT)
                            .toArray())
                            .collect(Collectors.toMap(
                                    e -> e.getAttribute(KEY_ATTRIBUTE),
                                    XmlReader.Element::getText
                            )),
                    Arrays.stream(rootElement.getChildByName(COMPONENT_SUPPLIER_PACKAGES_ELEMENT)
                            .getChildrenByName(COMPONENT_SUPPLIER_PACKAGE_ELEMENT)
                            .toArray())
                            .map(e -> e.getText().trim())
                            .collect(Collectors.toList())
            );
        } catch (IOException e) {
            throw new ConfigurationXmlLoadException(e);
        }
    }
}
