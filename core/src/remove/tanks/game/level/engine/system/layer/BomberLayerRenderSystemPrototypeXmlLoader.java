package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class BomberLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<BomberLayerRenderSystemPrototype>
{
    @Override
    public SystemType getLoaderType() {
        return SystemType.BomberLayerRenderSystem;
    }

    @Override
    protected BomberLayerRenderSystemPrototype loadEntitySystemPrototype(int priority) {
        return new BomberLayerRenderSystemPrototype(priority);
    }
}
