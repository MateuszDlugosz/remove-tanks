package remove.tanks.game.utility.properties;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class PropertyExistsValidatorTest {
    @Test(expected = NoSuchPropertiesKeysValidationException.class)
    public void when_PropertiesHaveNotRequiredKeys_Then_ThrowException() {
        Properties properties = new Properties();
        PropertyExistsValidator validator = new PropertyExistsValidator(
                new String[] {
                        "sample-property-key"
                }
        );
        validator.validateProperties(properties);
    }
}