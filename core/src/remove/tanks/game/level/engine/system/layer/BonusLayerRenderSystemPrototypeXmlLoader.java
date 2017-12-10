package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class BonusLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<BonusLayerRenderSystemPrototype>
{
    @Override
    public SystemType getLoaderType() {
        return SystemType.BonusLayerRenderSystem;
    }

    @Override
    protected BonusLayerRenderSystemPrototype loadEntitySystemPrototype(int priority) {
        return new BonusLayerRenderSystemPrototype(priority);
    }
}
