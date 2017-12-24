package remove.tanks.game.level.engine.system.view;

import remove.tanks.game.graphic.view.updater.ViewUpdater;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ViewUpdateSystemFactory
        implements RegistrableEntitySystemFactory<ViewUpdateSystem, ViewUpdateSystemPrototype>
{
    private final ViewUpdater viewUpdater;

    public ViewUpdateSystemFactory(ViewUpdater viewUpdater) {
        this.viewUpdater = viewUpdater;
    }

    @Override
    public ViewUpdateSystem createEntitySystem(ViewUpdateSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new ViewUpdateSystem(prototype.getPriority(), viewUpdater);
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    @Override
    public Class<ViewUpdateSystemPrototype> getFactoryType() {
        return ViewUpdateSystemPrototype.class;
    }
}
