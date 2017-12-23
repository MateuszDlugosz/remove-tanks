package remove.tanks.game.application.context;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;
import remove.tanks.game.application.context.component.provider.ComponentProviderNotFoundException;
import remove.tanks.game.application.context.configuration.Configuration;
import remove.tanks.game.application.context.configuration.ConfigurationXmlLoader;

import java.util.logging.LogManager;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class ApplicationContextTest extends LibGDXTest {
    private static final String CONFIGURATION_TEST_FILE
            = "application/configuration/configuration-correct.xml";

    private Configuration configuration;

    @Before
    public void initTestObjects() {
        configuration = new ConfigurationXmlLoader(new XmlReader()).loadConfiguration(
                Gdx.files.internal(CONFIGURATION_TEST_FILE));
        LogManager.getLogManager().reset();
    }

    @Test
    public void when_InScanPackageAreComponents_Then_ContextCorrectlyInitializeThey() {
        ApplicationContext context = new ApplicationContext(configuration);

        assertEquals("test-value", context.getComponent("StringTest"));
        assertEquals(10, context.getComponent("IntegerTest"));
    }

    @Test(expected = ComponentProviderNotFoundException.class)
    public void when_InScanPackageAreNotComponents_Then_GetThrowException() {
        ApplicationContext context = new ApplicationContext(configuration);
        context.getComponent("UnknownComponent");
    }
}