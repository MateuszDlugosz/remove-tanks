package remove.tanks.game.application.context.configuration;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class ConfigurationXmlLoaderTest  extends LibGDXTest {
    private static final String CONFIGURATION_CORRECT_FILE
            = "application/configuration/configuration-correct.xml";
    private static final String CONFIGURATION_INCORRECT_FILE
            = "application/configuration/configuration-incorrect.xml";

    private XmlReader xmlReader;
    private ConfigurationXmlLoader configurationXmlLoader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        configurationXmlLoader = new ConfigurationXmlLoader(xmlReader);
    }

    @Test
    public void when_ConfigurationFileHasCorrectFormat_Then_LoadConfiguration() {
        Configuration configuration =
                configurationXmlLoader.loadConfiguration(Gdx.files.internal(CONFIGURATION_CORRECT_FILE));

        assertEquals("value-0", configuration.getOption("option-0"));
        assertEquals("value-1", configuration.getOption("option-1"));
        assertEquals(1, configuration.getComponentSupplierPackages().size());
        assertEquals("remove.tanks.game.application.test",
                configuration.getComponentSupplierPackages().get(0));
    }

    @Test(expected = ConfigurationXmlLoadException.class)
    public void when_ConfigurationFileHasIncorrectFormat_Then_ThrowException() {
        configurationXmlLoader.loadConfiguration(Gdx.files.internal(CONFIGURATION_INCORRECT_FILE));
    }
}