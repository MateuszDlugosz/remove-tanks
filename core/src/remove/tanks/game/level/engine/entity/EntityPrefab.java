package remove.tanks.game.level.engine.entity;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;
import remove.tanks.game.level.preload.PreloadData;
import remove.tanks.game.utility.Prefab;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefab extends Prefab {
    private final PreloadData preloadData;
    private final Map<Class<? extends ComponentPrefab>, ComponentPrefab> componentPrefabs;

    public EntityPrefab(
            PreloadData preloadData,
            Map<Class<? extends ComponentPrefab>, ComponentPrefab> componentPrefabs
    ) {
        this.preloadData = preloadData;
        this.componentPrefabs = componentPrefabs;
    }

    public PreloadData getPreloadData() {
        return preloadData;
    }

    public Map<Class<? extends ComponentPrefab>, ComponentPrefab> getComponentPrefabs() {
        return componentPrefabs;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("preloadData", preloadData)
                .add("componentPrefabs", componentPrefabs)
                .toString();
    }
}
