package remove.tanks.game.utility.properties;

import org.junit.Test;

/**
 * @author Mateusz Długosz
 */
public class PropertyExistsValidatorTest {
    @Test(expected = NoSuchPropertiesKeysValidationException.class)
    public void Should_ThrowException_When_GivenPropertiesObjectHasNotRequiredProperties() {
        Properties properties = new Properties();
        new PropertyExistsValidator(new String[] {"property"}).validateProperties(properties);
    }

    @Test
    public void Should_NotThrowException_When_GivenPropertiesObjectHasNotRequiredProperties() {
        Properties properties = new Properties();
        properties.putString("property", "value");

        new PropertyExistsValidator(new String[] {"property"}).validateProperties(properties);
    }
}