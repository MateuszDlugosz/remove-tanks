package remove.tanks.game.utility.properties;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class PropertiesXmlReaderTest {
    private static final String PROPERTIES_0_CORRECT_PREFAB =
            "<properties>" +
                    "<property name=\"property-string\">value</property>" +
                    "<property name=\"property-integer\">1</property>" +
                    "<property name=\"property-float\">0.11</property>" +
                    "<property name=\"property-long\">1001</property>" +
                    "<property name=\"property-short\">9090</property>" +
                    "<property name=\"property-boolean\">true</property>" +
            "</properties>";

    private static final String PROPERTIES_1_CORRECT_PREFAB =
            "<properties>" +
                    "<property name=\"property-1\">val-1</property>" +
            "</properties>";

    private static final String PROPERTIES_2_CORRECT_PREFAB =
            "<properties>" +
                    "<property name=\"property-2\">val-2</property>" +
            "</properties>";

    private static final String PROPERTIES_3_INCORRECT_PREFAB =
            "<properties>" +
                    "<property>value</property>" +
            "</properties>";

    private XmlReader xmlReader;
    private PropertiesXmlReader propertiesXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        propertiesXmlReader = new PropertiesXmlReader();
    }

    @Test
    public void Should_ReturnProperties_When_GivenCorrectlyFormattedElement() {
        XmlReader.Element element = xmlReader.parse(PROPERTIES_0_CORRECT_PREFAB);
        Properties properties = propertiesXmlReader.readProperties(element);

        assertEquals("value", properties.getString("property-string"));
        assertEquals(1, properties.getInt("property-integer"));
        assertEquals(0.11f, properties.getFloat("property-float"), 0.001f);
        assertEquals(1001, properties.getLong("property-long"));
        assertEquals(9090, properties.getShort("property-short"));
        assertTrue(properties.getBoolean("property-boolean"));
    }

    @Test
    public void Should_ReturnPropertiesWithAllKeysAndValues_When_MergeTwoProperties() {
        Properties properties1 = propertiesXmlReader.readProperties(
                xmlReader.parse(PROPERTIES_1_CORRECT_PREFAB));
        Properties properties2 = propertiesXmlReader.readProperties(
                xmlReader.parse(PROPERTIES_2_CORRECT_PREFAB));
        properties1.merge(properties2);

        assertEquals(2, properties1.getKeys().size());
        assertEquals("val-1", properties1.getString("property-1"));
        assertEquals("val-2", properties1.getString("property-2"));
    }

    @Test(expected = PropertiesXmlReadException.class)
    public void Should_ThrowException_When_GivenElementIsIncorrectlyFormatted() {
        propertiesXmlReader.readProperties(xmlReader.parse(PROPERTIES_3_INCORRECT_PREFAB));
    }
}