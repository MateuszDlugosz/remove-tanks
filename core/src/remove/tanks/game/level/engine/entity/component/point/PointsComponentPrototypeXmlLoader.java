package remove.tanks.game.level.engine.entity.component.point;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class PointsComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<PointsComponentPrototype>
{
    private static final String POINTS_ELEMENT = "points";

    @Override
    public PointsComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new PointsComponentPrototype(Integer.valueOf(element
                .getChildByName(POINTS_ELEMENT).getText().trim()));
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.PointsComponent;
    }
}
