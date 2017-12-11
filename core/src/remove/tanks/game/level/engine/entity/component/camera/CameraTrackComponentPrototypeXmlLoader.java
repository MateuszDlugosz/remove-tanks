package remove.tanks.game.level.engine.entity.component.camera;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<CameraTrackComponentPrototype>
{
    private final PositionPrototypeXmlLoader positionPrototypeXmlLoader;

    public CameraTrackComponentPrototypeXmlLoader(PositionPrototypeXmlLoader positionPrototypeXmlLoader) {
        this.positionPrototypeXmlLoader = positionPrototypeXmlLoader;
    }

    @Override
    public CameraTrackComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new CameraTrackComponentPrototype(
                positionPrototypeXmlLoader.loadPositionPrototype(
                        element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT)
                )
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.CameraTrackComponent;
    }
}
