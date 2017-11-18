package remove.tanks.game.utility.properties;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class PropertiesTest {
    private Properties properties;

    @Before
    public void initTestObjects() {
        properties = new Properties();
        properties.putBoolean("test.boolean", true);
        properties.putFloat("test.float", 0.5f);
        properties.putInt("test.int", 19);
        properties.putLong("test.long", 10L);
        properties.putShort("test.short", (short) 4);
        properties.putString("test.string", "test string");
    }
}