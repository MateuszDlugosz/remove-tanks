package remove.tanks.game.level.engine.entity.component.graphic;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphic.view.View;
import remove.tanks.game.graphic.view.ViewFactory;
import remove.tanks.game.graphic.view.ViewPrototype;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.scale.Scale;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class GraphicsComponentFactory
        implements RegistrableComponentFactory<GraphicsComponent, GraphicsComponentPrototype>
{
    private final ViewFactory viewFactory;

    public GraphicsComponentFactory(ViewFactory viewFactory) {
        this.viewFactory = viewFactory;
    }

    @Override
    public GraphicsComponent createComponent(GraphicsComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new GraphicsComponent(
                    createViewIdMap(
                            prototype.getViewPrototypes(),
                            level.getResourceRegistry()
                                    .getResource(LevelResource.AssetStorage.toString(), AssetStorage.class),
                            level.getResourceRegistry()
                                    .getResource(LevelResource.WorldScale.toString(), Scale.class)
                    )
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    private Map<String, View> createViewIdMap(List<ViewPrototype> prototypes, AssetStorage assetStorage, Scale scale) {
        return prototypes.stream()
                .collect(Collectors.toMap(
                        ViewPrototype::getId,
                        p -> viewFactory.createView(p, assetStorage, scale)
                ));
    }

    @Override
    public Class<GraphicsComponentPrototype> getFactoryType() {
        return GraphicsComponentPrototype.class;
    }
}
