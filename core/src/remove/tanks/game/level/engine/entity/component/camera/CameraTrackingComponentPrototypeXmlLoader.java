package remove.tanks.game.level.engine.entity.component.camera;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackingComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<CameraTrackingComponentPrototype>
{
    private final PositionPrototypeXmlLoader positionPrototypeXmlLoader;

    public CameraTrackingComponentPrototypeXmlLoader(PositionPrototypeXmlLoader positionPrototypeXmlLoader) {
        this.positionPrototypeXmlLoader = positionPrototypeXmlLoader;
    }

    @Override
    public CameraTrackingComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new CameraTrackingComponentPrototype(
                positionPrototypeXmlLoader.loadPositionPrototype(
                        element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT)
                )
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.CameraTrackingComponent;
    }
}
