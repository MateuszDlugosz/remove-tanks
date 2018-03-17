package remove.tanks.game.level.engine.entity.component.direction;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;
import remove.tanks.game.level.utility.direction.Direction;
import remove.tanks.game.level.utility.direction.DirectionXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class DirectionComponentPrefabXmlReader implements SubComponentPrefabXmlReader<DirectionComponentPrefab> {
    private final DirectionXmlReader directionXmlReader;

    public DirectionComponentPrefabXmlReader(DirectionXmlReader directionXmlReader) {
        this.directionXmlReader = directionXmlReader;
    }

    @Override
    public DirectionComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new DirectionComponentPrefab(
                    readDirection(element)
            );
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private Direction readDirection(XmlReader.Element element) {
        return directionXmlReader.readDirection(
                element.getChildByName(DirectionXmlReader.DIRECTION_ELEMENT));
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.DirectionComponent;
    }
}
