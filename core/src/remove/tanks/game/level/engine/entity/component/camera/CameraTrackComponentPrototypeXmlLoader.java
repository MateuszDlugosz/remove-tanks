package remove.tanks.game.level.engine.entity.component.camera;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.utility.position.PositionPrototype;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<CameraTrackComponentPrototype>
{
    private static final String PRIORITY_ELEMENT = "priority";

    private final PositionPrototypeXmlLoader positionPrototypeXmlLoader;

    public CameraTrackComponentPrototypeXmlLoader(PositionPrototypeXmlLoader positionPrototypeXmlLoader) {
        this.positionPrototypeXmlLoader = positionPrototypeXmlLoader;
    }

    @Override
    public CameraTrackComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new CameraTrackComponentPrototype(
                loadPositionPrototype(element),
                loadPriority(element)
        );
    }

    private PositionPrototype loadPositionPrototype(XmlReader.Element element) {
        return positionPrototypeXmlLoader.loadPositionPrototype(
                element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT)
        );
    }

    private int loadPriority(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(PRIORITY_ELEMENT).getText().trim());
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.CameraTrackComponent;
    }
}
