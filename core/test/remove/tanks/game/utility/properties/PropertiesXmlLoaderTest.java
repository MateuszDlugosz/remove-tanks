package remove.tanks.game.utility.properties;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class PropertiesXmlLoaderTest extends LibGDXTest {
    private static final String CORRECT_PROPERTIES_FILE_0
            = "utility/properties/properties-correct-0.xml";
    private static final String CORRECT_PROPERTIES_FILE_1
            = "utility/properties/properties-correct-1.xml";
    private static final String CORRECT_PROPERTIES_FILE_2
            = "utility/properties/properties-correct-2.xml";
    private static final String INCORRECT_PROPERTIES_FILE
            = "utility/properties/properties-incorrect.xml";

    private XmlReader xmlReader;
    private PropertiesXmlLoader propertiesXmlLoader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        propertiesXmlLoader = new PropertiesXmlLoader();
    }

    @Test
    public void when_ElementIsCorrectlyFormatted_Then_LoadProperties() {
        XmlReader.Element element = xmlReader.parse(Gdx.files.internal(CORRECT_PROPERTIES_FILE_0));
        Properties properties = propertiesXmlLoader.loadProperties(element);

        assertEquals("value", properties.getString("property-string"));
        assertEquals(1, properties.getInt("property-integer"));
        assertEquals(0.11f, properties.getFloat("property-float"), 0.001f);
        assertEquals(1001, properties.getLong("property-long"));
        assertEquals(9090, properties.getShort("property-short"));
        assertTrue(properties.getBoolean("property-boolean"));
    }

    @Test
    public void when_MergeTwoProperties_Then_PropertiesHasAllKeysAndValues() {
        Properties properties1 = propertiesXmlLoader.loadProperties(
                xmlReader.parse(Gdx.files.internal(CORRECT_PROPERTIES_FILE_1)));
        Properties properties2 = propertiesXmlLoader.loadProperties(
                xmlReader.parse(Gdx.files.internal(CORRECT_PROPERTIES_FILE_2)));
        properties1.merge(properties2);

        assertEquals(2, properties1.getKeys().size());
        assertEquals("val-1", properties1.getString("property-1"));
        assertEquals("val-2", properties1.getString("property-2"));
    }

    @Test(expected = PropertiesXmlLoadException.class)
    public void when_ElementIsIncorrectlyFormatted_Then_ThrowException() {
        Properties properties = propertiesXmlLoader.loadProperties(
                xmlReader.parse(Gdx.files.internal(INCORRECT_PROPERTIES_FILE)));
    }
}