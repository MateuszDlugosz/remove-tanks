package remove.tanks.game.level.engine.entity.component.identity;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class IdentityComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT =
            "<component type=\"IdentityComponent\">" +
                    "<id>TestID</id>" +
            "</component>";

    private static final String COMPONENT_INCORRECT_ELEMENT =
            "<component type=\"IdentityComponent\">" +
            "</component>";

    private XmlReader xmlReader;
    private IdentityComponentPrefabXmlReader identityComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        identityComponentPrefabXmlReader = new IdentityComponentPrefabXmlReader();
    }

    @Test
    public void Should_ReturnIdentityComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        IdentityComponentPrefab prefab = identityComponentPrefabXmlReader.readComponentPrefab(element);

        assertEquals("TestID", prefab.getId());
    }

    @Test(expected = ComponentPrefabXmlReadException.class)
    public void Should_ThrowException_When_ElementIsIncorrectlyFormatted() {
        identityComponentPrefabXmlReader.readComponentPrefab(xmlReader.parse(COMPONENT_INCORRECT_ELEMENT));
    }
}