package remove.tanks.game.utility.properties;

import org.junit.Test;

/**
 * @author Mateusz Długosz
 */
public class PropertiesTest {
    @Test(expected = NoSuchPropertyException.class)
    public void when_PropertyNotExists_Then_ThrowException() {
        Properties properties = new Properties();
        properties.getString("property-not-exists");
    }
}