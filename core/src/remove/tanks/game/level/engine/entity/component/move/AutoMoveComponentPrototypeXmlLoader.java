package remove.tanks.game.level.engine.entity.component.move;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class AutoMoveComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<AutoMoveComponentPrototype>
{
    private static final String LOADER_TYPE = "AutoMoveComponent";

    @Override
    public AutoMoveComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new AutoMoveComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.AutoMoveComponent;
    }
}
