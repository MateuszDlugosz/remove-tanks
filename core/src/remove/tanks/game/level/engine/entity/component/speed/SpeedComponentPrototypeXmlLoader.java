package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class SpeedComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<SpeedComponentPrototype>
{
    private static final String SPEED_ELEMENT = "speed";

    @Override
    public SpeedComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new SpeedComponentPrototype(
                Float.valueOf(
                        element.getChildByName(SPEED_ELEMENT).getText().trim()
                )
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.SpeedComponent;
    }
}
