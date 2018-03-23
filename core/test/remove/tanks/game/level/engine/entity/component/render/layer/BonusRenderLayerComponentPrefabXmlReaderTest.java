package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class BonusRenderLayerComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"BonusRenderLayerComponent\" />";

    private XmlReader xmlReader;
    private BonusRenderLayerComponentPrefabXmlReader bonusRenderLayerComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        bonusRenderLayerComponentPrefabXmlReader = new BonusRenderLayerComponentPrefabXmlReader();
    }

    @Test
    public void Should_BeEqual_When_ReadsTwoDifferentComponents() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        BonusRenderLayerComponentPrefab prefab0
                = bonusRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);
        BonusRenderLayerComponentPrefab prefab1
                = bonusRenderLayerComponentPrefabXmlReader.readComponentPrefab(element);

        assertTrue(prefab0 == prefab1);
    }

    @Test
    public void Should_ReturnBonusRenderLayerComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);

        assertNotNull(bonusRenderLayerComponentPrefabXmlReader.readComponentPrefab(element));
    }
}