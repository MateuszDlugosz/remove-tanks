package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class ExplosionLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<ExplosionLayerRenderSystemPrototype>
{
    @Override
    public SystemType getLoaderType() {
        return SystemType.ExplosionLayerRenderSystem;
    }

    @Override
    protected ExplosionLayerRenderSystemPrototype loadEntitySystemPrototype(int priority) {
        return new ExplosionLayerRenderSystemPrototype(priority);
    }
}
