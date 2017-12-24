package remove.tanks.game.level.engine.entity.component.behavior;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.*;

import java.util.List;

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
        try {
            return new ChangeBehaviorComponentPrototype(
                    loadComponentPrototypes(element)
            );
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    private List<ComponentPrototype> loadComponentPrototypes(XmlReader.Element element) {
        return componentPrototypeXmlLoader.loadComponentsPrototypes(
                element.getChildByName(ComponentPrototypeXmlLoader.COMPONENTS_ELEMENT)
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.ChangeBehaviorComponent;
    }
}
