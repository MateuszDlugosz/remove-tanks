package remove.tanks.game.level.engine.entity;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class EntityPrefabCodeXmlReaderTest {
    private static final String ENTITY_PREFAB_CODE_CORRECT_ELEMENT =
            "<entityPrefabCode>TestPrefabCode</entityPrefabCode>";

    private static final String ENTITY_PREFAB_CODES_CORRECT_ELEMENT =
            "<entityPrefabCodes>" +
                    "<entityPrefabCode>Test0</entityPrefabCode>" +
                    "<entityPrefabCode>Test1</entityPrefabCode>" +
            "</entityPrefabCodes>";

    private static final String ENTITY_PREFAB_CODES_INCORRECT_ELEMENT =
            "<entityPrefabCodes>" +
                    "<entityPrefabCode></entityPrefabCode>" +
                    "<entityPrefabCode />" +
            "</entityPrefabCodes>";

    private XmlReader xmlReader;
    private EntityPrefabCodeXmlReader entityPrefabCodeXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        entityPrefabCodeXmlReader = new EntityPrefabCodeXmlReader();
    }

    @Test
    public void Should_ReturnPrefabCode() {
        assertEquals("TestPrefabCode", entityPrefabCodeXmlReader
                .readEntityPrefabCode(xmlReader.parse(ENTITY_PREFAB_CODE_CORRECT_ELEMENT)));
    }

    @Test
    public void Should_ReturnPrefabCodes() {
        List<String> entityPrefabCodes = entityPrefabCodeXmlReader
                .readEntityPrefabCodes(xmlReader.parse(ENTITY_PREFAB_CODES_CORRECT_ELEMENT));

        assertEquals(2, entityPrefabCodes.size());
        assertEquals("Test0", entityPrefabCodes.get(0));
        assertEquals("Test1", entityPrefabCodes.get(1));
    }

    @Test(expected = EntityPrefabCodeXmlReadException.class)
    public void Should_ThrowsException_When_ElementIsIncorrect() {
        entityPrefabCodeXmlReader.readEntityPrefabCodes(xmlReader.parse(ENTITY_PREFAB_CODES_INCORRECT_ELEMENT));
    }
}