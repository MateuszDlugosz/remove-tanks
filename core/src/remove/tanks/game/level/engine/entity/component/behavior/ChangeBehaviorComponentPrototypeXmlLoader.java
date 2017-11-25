package remove.tanks.game.level.engine.entity.component.behavior;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ChangeBehaviorComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<ChangeBehaviorComponentPrototype>
{
    private final ComponentPrototypeXmlLoader componentPrototypeXmlLoader;

    public ChangeBehaviorComponentPrototypeXmlLoader(ComponentPrototypeXmlLoader componentPrototypeXmlLoader) {
        this.componentPrototypeXmlLoader = componentPrototypeXmlLoader;
    }

    @Override
    public ChangeBehaviorComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new ChangeBehaviorComponentPrototype(
                componentPrototypeXmlLoader.loadComponentsPrototypes(
                        element.getChildByName(ComponentPrototypeXmlLoader.COMPONENTS_ELEMENT)
                )
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.ChangeBehaviorComponent;
    }
}
