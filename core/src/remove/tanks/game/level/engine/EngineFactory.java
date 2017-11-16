package remove.tanks.game.level.engine;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.engine.listener.EntityListenerFactory;
import remove.tanks.game.level.engine.listener.EntityListenerPrototype;
import remove.tanks.game.level.engine.system.EntitySystemFactory;
import remove.tanks.game.level.engine.system.EntitySystemPrototype;
import remove.tanks.game.level.resource.ResourceRegistry;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class EngineFactory {
    private final EntitySystemFactory entitySystemFactory;
    private final EntityListenerFactory entityListenerFactory;

    public EngineFactory(
            EntitySystemFactory entitySystemFactory,
            EntityListenerFactory entityListenerFactory
    ) {
        this.entitySystemFactory = entitySystemFactory;
        this.entityListenerFactory = entityListenerFactory;
    }

    public Engine createEngine(EnginePrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            Engine engine = new Engine();
            createSystems(prototype.getSystemsPrototypes(), engine, resourceRegistry);
            createListeners(prototype.getListenersPrototypes(), engine, resourceRegistry);
            return engine;
        } catch (Exception e) {
            throw new EngineCreateException(prototype, e);
        }
    }

    private void createSystems(List<EntitySystemPrototype> prototypes, Engine engine, ResourceRegistry resourceRegistry) {
        entitySystemFactory.createEntitiesSystems(prototypes, resourceRegistry).forEach(engine::addSystem);
    }

    private void createListeners(List<EntityListenerPrototype> prototypes, Engine engine, ResourceRegistry resourceRegistry) {
        entityListenerFactory.createEntitiesListeners(prototypes, resourceRegistry, engine).forEach(l ->
            engine.addEntityListener(l.getFamily(), l.getPriority(), l)
        );
    }
}
