package remove.tanks.game.application.context.configuration;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class ConfigurationTest {
    @Test
    public void Should_ReturnAssignedValues_When_ConfigurationIsInitializedFromMap() {
        Map<String, String> options = new HashMap<>();
        options.put("option.a", "OptionA");
        options.put("option.b", "OptionB");
        options.put("option.c", "OptionC");

        Configuration configuration = new Configuration(options);

        assertEquals("OptionA", configuration.getOption("option.a"));
        assertEquals("OptionB", configuration.getOption("option.b"));
        assertEquals("OptionC", configuration.getOption("option.c"));
        assertTrue(configuration.hasOption("option.a"));
        assertFalse(configuration.hasOption("option.d"));
    }

    @Test(expected = OptionNotFoundException.class)
    public void Should_ThrowException_When_GivenConfigurationOptionIsNotExists() {
        Map<String, String> options = new HashMap<>();
        Configuration configuration = new Configuration(options);
        configuration.getOption("unknown.option");
    }
}
