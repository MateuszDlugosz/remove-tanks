package remove.tanks.game.level.engine.system.state.victory;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class NoEnemiesVictorySystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<NoEnemiesVictorySystemPrefab> {
    private static final String DELAY_ELEMENT = "delay";

    @Override
    public NoEnemiesVictorySystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new NoEnemiesVictorySystemPrefab(priority, readDelay(element));
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    private float readDelay(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(DELAY_ELEMENT).getText().trim());
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.NoEnemiesVictorySystem;
    }
}
