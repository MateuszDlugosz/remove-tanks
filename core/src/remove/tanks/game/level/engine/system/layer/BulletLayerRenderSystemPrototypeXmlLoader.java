package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class BulletLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<BulletLayerRenderSystemPrototype>
{
    @Override
    public SystemType getLoaderType() {
        return SystemType.BulletLayerRenderSystem;
    }

    @Override
    protected BulletLayerRenderSystemPrototype loadEntitySystemPrototype(int priority) {
        return new BulletLayerRenderSystemPrototype(priority);
    }
}
