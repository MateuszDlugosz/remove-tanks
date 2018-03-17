package remove.tanks.game.level.engine.entity.component.camera;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;
import remove.tanks.game.utility.surface.position.PositionPrefab;
import remove.tanks.game.utility.surface.position.PositionPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackComponentPrefabXmlReader implements SubComponentPrefabXmlReader<CameraTrackComponentPrefab> {
    private static final String PRIORITY_ELEMENT = "priority";

    private final PositionPrefabXmlReader positionPrefabXmlReader;

    public CameraTrackComponentPrefabXmlReader(PositionPrefabXmlReader positionPrefabXmlReader) {
        this.positionPrefabXmlReader = positionPrefabXmlReader;
    }

    @Override
    public CameraTrackComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new CameraTrackComponentPrefab(
                    readPositionPrefab(element),
                    readPriority(element)
            );
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private PositionPrefab readPositionPrefab(XmlReader.Element element) {
        if (element.getChildByName(PositionPrefabXmlReader.POSITION_ELEMENT) == null) {
            return PositionPrefab.POSITION_PREFAB_ZERO;
        }
        return positionPrefabXmlReader.readPositionPrefab(
                element.getChildByName(PositionPrefabXmlReader.POSITION_ELEMENT)
        );
    }

    private int readPriority(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(PRIORITY_ELEMENT).getText().trim());
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.CameraTrackComponent;
    }
}
