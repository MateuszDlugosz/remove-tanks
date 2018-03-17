package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class RandomShootComponentPrefabXmlReader implements SubComponentPrefabXmlReader<RandomShootComponentPrefab> {
    private static final String MIN_SHOOT_FREQUENCY_ELEMENT = "minShootFrequency";
    private static final String MAX_SHOOT_FREQUENCY_ELEMENT = "maxShootFrequency";

    @Override
    public RandomShootComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new RandomShootComponentPrefab(
                    readMinShootFrequency(element),
                    readMaxShootFrequency(element)
            );
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private float readMinShootFrequency(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MIN_SHOOT_FREQUENCY_ELEMENT).getText().trim());
    }

    private float readMaxShootFrequency(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MAX_SHOOT_FREQUENCY_ELEMENT).getText().trim());
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.RandomShootComponent;
    }
}
