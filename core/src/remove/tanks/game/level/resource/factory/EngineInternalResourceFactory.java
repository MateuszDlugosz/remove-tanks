package remove.tanks.game.level.resource.factory;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.level.LevelPrototype;
import remove.tanks.game.level.engine.EngineFactory;
import remove.tanks.game.level.resource.AbstractInternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class EngineInternalResourceFactory
        extends AbstractInternalResourceFactory<Engine>
{
    private final EngineFactory engineFactory;

    public EngineInternalResourceFactory(EngineFactory engineFactory) {
        this.engineFactory = engineFactory;
    }

    @Override
    protected String getResourceName() {
        return LevelResource.Engine.toString();
    }

    @Override
    protected Engine getResourceObject(ResourceRegistry registry) {
        return engineFactory.createEngine(
                registry.getResource(LevelResource.LevelPrototype.toString(), LevelPrototype.class)
                        .getEnginePrototype(),
                registry
        );
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[] {
                LevelResource.GameCamera.toString(),
                LevelResource.HudCamera.toString(),
                LevelResource.SpriteBatch.toString(),
                LevelResource.EventBus.toString(),
                LevelResource.Locale.toString(),
                LevelResource.Configuration.toString(),
                LevelResource.Properties.toString(),
                LevelResource.LevelPrototype.toString(),
                LevelResource.WorldScale.toString(),
                LevelResource.DisplayScale.toString(),
                LevelResource.AssetStorage.toString(),
                LevelResource.TiledMap.toString(),
                LevelResource.TiledMapBoundaries.toString(),
                LevelResource.EntityPrototypeRepository.toString(),
                LevelResource.World.toString(),
                LevelResource.WorldLight.toString(),
        };
    }
}
