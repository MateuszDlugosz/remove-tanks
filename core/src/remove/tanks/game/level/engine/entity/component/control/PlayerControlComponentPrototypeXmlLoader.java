package remove.tanks.game.level.engine.entity.component.control;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class PlayerControlComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<PlayerControlComponentPrototype>
{
    private static final String SHOOT_DELAY_ELEMENT = "shootDelay";

    @Override
    public PlayerControlComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new PlayerControlComponentPrototype(
                    loadShootDelay(element)
            );
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    private float loadShootDelay(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(SHOOT_DELAY_ELEMENT).getText().trim());
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.PlayerControlComponent;
    }
}
