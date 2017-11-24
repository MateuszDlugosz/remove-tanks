package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class SpeedModifierComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<SpeedModifierComponentPrototype>
{
    private static final String VALUE_ELEMENT = "value";

    @Override
    public SpeedModifierComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new SpeedModifierComponentPrototype(Float.valueOf(element.getChildByName(VALUE_ELEMENT).getText().trim()));
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.SpeedModifierComponent;
    }
}
