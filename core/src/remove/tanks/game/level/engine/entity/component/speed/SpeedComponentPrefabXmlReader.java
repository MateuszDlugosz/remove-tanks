package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class SpeedComponentPrefabXmlReader implements SubComponentPrefabXmlReader<SpeedComponentPrefab> {
    private static final String SPEED_ELEMENT = "speed";

    @Override
    public SpeedComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new SpeedComponentPrefab(
                    readSpeed(element)
            );
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private float readSpeed(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(SPEED_ELEMENT).getText().trim());
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.SpeedComponent;
    }
}
