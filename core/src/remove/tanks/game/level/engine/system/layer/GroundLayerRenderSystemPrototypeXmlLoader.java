package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class GroundLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<GroundLayerRenderSystemPrototype>
{
    @Override
    public SystemType getLoaderType() {
        return SystemType.GroundLayerRenderSystem;
    }

    @Override
    protected GroundLayerRenderSystemPrototype loadEntitySystemPrototype(int priority) {
        return new GroundLayerRenderSystemPrototype(priority);
    }
}
