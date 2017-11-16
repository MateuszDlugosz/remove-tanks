package remove.tanks.game.level.engine.entity.component.shoot;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class RandomShootComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<RandomShootComponentPrototype>
{
    private static final String MIN_SHOOT_FREQUENCY_ELEMENT = "minShootFrequency";
    private static final String MAX_SHOOT_FREQUENCY_ELEMENT = "maxShootFrequency";

    @Override
    public RandomShootComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new RandomShootComponentPrototype(
                Float.valueOf(element.getChildByName(MIN_SHOOT_FREQUENCY_ELEMENT).getText().trim()),
                Float.valueOf(element.getChildByName(MAX_SHOOT_FREQUENCY_ELEMENT).getText().trim())
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.RandomShootComponent;
    }
}
