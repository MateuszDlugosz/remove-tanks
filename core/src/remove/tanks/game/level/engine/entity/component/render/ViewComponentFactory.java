package remove.tanks.game.level.engine.entity.component.render;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.view.View;
import remove.tanks.game.graphics.view.ViewFactory;
import remove.tanks.game.graphics.view.ViewPrefab;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.scale.Scale;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ViewComponentFactory implements SubComponentFactory<ViewComponent, ViewComponentPrefab> {
    private final ViewFactory viewFactory;

    public ViewComponentFactory(ViewFactory viewFactory) {
        this.viewFactory = viewFactory;
    }

    @Override
    public ViewComponent createComponent(ViewComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new ViewComponent(
                    createViewIdMap(
                            prefab.getViewPrefabs(),
                            registry.getResource(ResourceType.AssetStorageResource, AssetStorage.class),
                            registry.getResource(ResourceType.WorldScaleResource, Scale.class)
                    )
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    private Map<String, View> createViewIdMap(List<ViewPrefab> prefabs, AssetStorage assetStorage, Scale scale) {
        return prefabs.stream()
                .collect(Collectors.toMap(
                        ViewPrefab::getId,
                        p -> viewFactory.createView(p, assetStorage, scale)
                ));
    }

    @Override
    public Class<ViewComponentPrefab> getFactoryType() {
        return ViewComponentPrefab.class;
    }
}
