package remove.tanks.game.level.engine.entity.component.graphic;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphic.view.ViewPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

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
        return new GraphicsComponentPrototype(
                viewPrototypeXmlLoader.loadViewPrototypes(
                        element.getChildByName(ViewPrototypeXmlLoader.VIEWS_ELEMENT)
                )
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.GraphicsComponent;
    }
}
