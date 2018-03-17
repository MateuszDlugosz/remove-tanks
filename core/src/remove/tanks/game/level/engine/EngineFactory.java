package remove.tanks.game.level.engine;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.engine.listener.EntityListenerFactory;
import remove.tanks.game.level.engine.listener.EntityListenerPrefab;
import remove.tanks.game.level.engine.system.EntitySystemFactory;
import remove.tanks.game.level.engine.system.EntitySystemPrefab;
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

    public Engine createEngine(EnginePrefab prefab, ResourceRegistry registry) {
        try {
            Engine engine = new Engine();
            createSystems(prefab.getSystemsPrefabs(), engine, registry);
            createListeners(prefab.getListenersPrefabs(), engine, registry);
            return engine;
        } catch (Exception e) {
            throw new EngineCreateException(prefab, e);
        }
    }

    private void createSystems(List<EntitySystemPrefab> prefabs, Engine engine, ResourceRegistry registry) {
        entitySystemFactory.createEntitiesSystems(prefabs, registry).forEach(engine::addSystem);
    }

    private void createListeners(List<EntityListenerPrefab> prefabs, Engine engine, ResourceRegistry registry) {
        entityListenerFactory.createEntitiesListeners(prefabs, registry, engine).forEach(l ->
                engine.addEntityListener(l.getFamily(), l.getPriority(), l)
        );
    }
}
