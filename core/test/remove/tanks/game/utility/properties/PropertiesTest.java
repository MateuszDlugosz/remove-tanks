package remove.tanks.game.utility.properties;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class PropertiesTest {
    @Test(expected = NoSuchPropertyException.class)
    public void Should_ThrowException_When_PropertyKeyIsNotExists() {
        Properties properties = new Properties();
        properties.getString("property-not-exists");
    }

    @Test
    public void Should_MergeProperties_When_GivenAnotherProperties() {
        Properties properties0 = new Properties();
        properties0.putString("property_0", "value_0");
        properties0.putString("property_1", "value_1");

        Properties properties1 = new Properties();
        properties1.putString("property_2", "value_2");
        properties1.putString("property_3", "value_3");

        properties0.merge(properties1);

        assertEquals("value_0", properties0.getString("property_0"));
        assertEquals("value_1", properties0.getString("property_1"));
        assertEquals("value_2", properties0.getString("property_2"));
        assertEquals("value_3", properties0.getString("property_3"));
    }

    @Test
    public void Should_ReturnSetOfPropertiesKeys() {
        Properties properties = new Properties();
        properties.putString("prop0", "val0");
        properties.putString("prop1", "val1");
        properties.putString("prop2", "val2");

        assertTrue(properties.getKeys().contains("prop0"));
        assertTrue(properties.getKeys().contains("prop1"));
        assertTrue(properties.getKeys().contains("prop2"));
    }

    @Test
    public void Should_ReturnAssignedString() {
        Properties properties = new Properties();
        properties.putString("string", "string");

        assertEquals("string", properties.getString("string"));
    }

    @Test
    public void Should_ReturnAssignedFloat() {
        Properties properties = new Properties();
        properties.putFloat("float", 1.0239f);

        assertEquals(1.0239f, properties.getFloat("float"), 0.001f);
    }

    @Test
    public void Should_ReturnAssignedShort() {
        Properties properties = new Properties();
        properties.putShort("short", (short) 1000);

        assertEquals((short) 1000, properties.getShort("short"));
    }

    @Test
    public void Should_ReturnAssignedInt() {
        Properties properties = new Properties();
        properties.putInt("int", 10);

        assertEquals(10, properties.getInt("int"), 0.001f);
    }

    @Test
    public void Should_ReturnAssignedBoolean() {
        Properties properties = new Properties();
        properties.putBoolean("true", true);
        properties.putBoolean("false", false);

        assertTrue(properties.getBoolean("true"));
        assertFalse(properties.getBoolean("false"));
    }

    @Test
    public void Should_ReturnAssignedLong() {
        Properties properties = new Properties();
        properties.putLong("long", 1000L);

        assertEquals(1000L, properties.getLong("long"));
    }

    @Test
    public void Should_ReturnAssignedDouble() {
        Properties properties = new Properties();
        properties.putDouble("double", 9120D);

        assertEquals(9120D, properties.getDouble("double"), 0.001f);
    }

    @Test
    public void Should_ReturnFormattedStringRepresentation() {
        Properties properties = new Properties();
        properties.putString("string", "string");

        assertEquals("Properties{properties={string=string}}", properties.toString());
    }
}
