package remove.tanks.game.level.engine.entity.component.graphic;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphic.view.ViewPrototype;
import remove.tanks.game.graphic.view.ViewPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class GraphicsComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<GraphicsComponentPrototype>
{
    private final ViewPrototypeXmlLoader viewPrototypeXmlLoader;

    public GraphicsComponentPrototypeXmlLoader(ViewPrototypeXmlLoader viewPrototypeXmlLoader) {
        this.viewPrototypeXmlLoader = viewPrototypeXmlLoader;
    }

    @Override
    public GraphicsComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new GraphicsComponentPrototype(
                    loadViewPrototypes(element)
            );
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    private List<ViewPrototype> loadViewPrototypes(XmlReader.Element element) {
        return viewPrototypeXmlLoader.loadViewPrototypes(
                element.getChildByName(ViewPrototypeXmlLoader.VIEWS_ELEMENT)
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.GraphicsComponent;
    }
}
