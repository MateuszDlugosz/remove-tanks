package remove.tanks.game.level.engine.system.render.view;

import remove.tanks.game.graphics.view.updater.ViewUpdater;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ViewUpdateSystemFactory implements SubEntitySystemFactory<ViewUpdateSystem, ViewUpdateSystemPrefab> {
    private final ViewUpdater viewUpdater;

    public ViewUpdateSystemFactory(ViewUpdater viewUpdater) {
        this.viewUpdater = viewUpdater;
    }

    @Override
    public ViewUpdateSystem createEntitySystem(ViewUpdateSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new ViewUpdateSystem(prefab.getPriority(), viewUpdater);
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<ViewUpdateSystemPrefab> getFactoryType() {
        return ViewUpdateSystemPrefab.class;
    }
}
