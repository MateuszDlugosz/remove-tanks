package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class BombLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<BombLayerRenderSystemPrototype>
{
    @Override
    public SystemType getLoaderType() {
        return SystemType.BombLayerRenderSystem;
    }

    @Override
    protected BombLayerRenderSystemPrototype loadEntitySystemPrototype(int priority) {
        return new BombLayerRenderSystemPrototype(priority);
    }
}
