package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class CloudLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<CloudLayerRenderSystemPrototype>
{
    @Override
    public SystemType getLoaderType() {
        return SystemType.CloudLayerRenderSystem;
    }

    @Override
    protected CloudLayerRenderSystemPrototype loadEntitySystemPrototype(int priority) {
        return new CloudLayerRenderSystemPrototype(priority);
    }
}
