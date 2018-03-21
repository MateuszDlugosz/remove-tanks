package remove.tanks.game.level.engine.entity.component.faction;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class EnemyComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT = "<component type=\"EnemyComponent\" />";

    private XmlReader xmlReader;
    private EnemyComponentPrefabXmlReader enemyComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        enemyComponentPrefabXmlReader = new EnemyComponentPrefabXmlReader();
    }

    @Test
    public void Should_ReturnEnemyComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        EnemyComponentPrefab prefab = enemyComponentPrefabXmlReader.readComponentPrefab(element);

        assertEquals(prefab.getClass(), prefab.getClass());
    }
}