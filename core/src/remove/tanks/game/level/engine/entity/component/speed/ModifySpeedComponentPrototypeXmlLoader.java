package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ModifySpeedComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<ModifySpeedComponentPrototype>
{
    private static final String VALUE_ELEEMNT = "value";

    @Override
    public ModifySpeedComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new ModifySpeedComponentPrototype(Float.valueOf(element.getChildByName(VALUE_ELEEMNT).getText().trim()));
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.ModifySpeedComponent;
    }
}
