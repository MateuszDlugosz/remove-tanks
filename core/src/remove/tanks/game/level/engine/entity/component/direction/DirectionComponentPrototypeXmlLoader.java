package remove.tanks.game.level.engine.entity.component.direction;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.utility.direction.Direction;
import remove.tanks.game.level.engine.utility.direction.DirectionXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class DirectionComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<DirectionComponentPrototype>
{
    private final DirectionXmlLoader directionXmlLoader;

    public DirectionComponentPrototypeXmlLoader(DirectionXmlLoader directionXmlLoader) {
        this.directionXmlLoader = directionXmlLoader;
    }

    @Override
    public DirectionComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new DirectionComponentPrototype(
                    loadDirection(element)
            );
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    private Direction loadDirection(XmlReader.Element element) {
        return directionXmlLoader.loadDirection(
                element.getChildByName(DirectionXmlLoader.DIRECTION_ELEMENT));
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.DirectionComponent;
    }
}
