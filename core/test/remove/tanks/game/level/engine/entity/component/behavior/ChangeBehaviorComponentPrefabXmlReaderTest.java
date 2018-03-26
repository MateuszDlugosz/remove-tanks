package remove.tanks.game.level.engine.entity.component.behavior;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.combat.AutoShootComponentPrefab;
import remove.tanks.game.level.engine.entity.component.combat.AutoShootComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.combat.ProtectionComponentPrefab;
import remove.tanks.game.level.engine.entity.component.combat.ProtectionComponentPrefabXmlReader;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class ChangeBehaviorComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT =
            "<component type=\"ChangeBehaviorComponent\">" +
                    "<components>" +
                        "<component type=\"AutoShootComponent\" />" +
                        "<component type=\"ProtectionComponent\" />" +
                    "</components>" +
            "</component>";

    private static final String COMPONENT_INCORRECT_ELEMENT =
            "<component type=\"ChangeBehaviorComponent\">" +
                    "<components>" +
                        "<component type=\"UnknownComponent\" />" +
                    "</components>" +
            "</component>";

    private XmlReader xmlReader;
    private ChangeBehaviorComponentPrefabXmlReader changeBehaviorComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        changeBehaviorComponentPrefabXmlReader = new ChangeBehaviorComponentPrefabXmlReader(
                new ComponentPrefabXmlReader(
                        new SubComponentPrefabXmlReader[] {
                                new AutoShootComponentPrefabXmlReader(),
                                new ProtectionComponentPrefabXmlReader()
                        }
                )
        );
    }

    @Test
    public void Should_ReturnContainsTwoComponentPrefabs_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        ChangeBehaviorComponentPrefab prefab = changeBehaviorComponentPrefabXmlReader.readComponentPrefab(element);

        assertEquals(2, prefab.getComponentPrefabs().size());
        assertEquals(AutoShootComponentPrefab.class, prefab.getComponentPrefabs().get(0).getClass());
        assertEquals(ProtectionComponentPrefab.class, prefab.getComponentPrefabs().get(1).getClass());
    }

    @Test(expected = ComponentPrefabXmlReadException.class)
    public void Should_ThrowException_When_ElementContainsUnknownComponentType() {
        changeBehaviorComponentPrefabXmlReader.readComponentPrefab(
                xmlReader.parse(COMPONENT_INCORRECT_ELEMENT)
        );
    }
}