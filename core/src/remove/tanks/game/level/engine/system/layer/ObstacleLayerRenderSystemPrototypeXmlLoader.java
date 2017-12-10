package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class ObstacleLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<ObstacleLayerRenderSystemPrototype>
{
    @Override
    public SystemType getLoaderType() {
        return SystemType.ObstacleLayerRenderSystem;
    }

    @Override
    protected ObstacleLayerRenderSystemPrototype loadEntitySystemPrototype(int priority) {
        return new ObstacleLayerRenderSystemPrototype(priority);
    }
}
