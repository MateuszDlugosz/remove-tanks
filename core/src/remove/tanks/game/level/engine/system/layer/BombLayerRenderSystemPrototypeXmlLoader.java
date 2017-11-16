package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.graphic.effect.EffectPrototype;
import remove.tanks.game.graphic.effect.EffectPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class BombLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<BombLayerRenderSystemPrototype>
{
    public BombLayerRenderSystemPrototypeXmlLoader(EffectPrototypeXmlLoader effectPrototypeXmlLoader) {
        super(effectPrototypeXmlLoader);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.BombLayerRenderSystem;
    }

    @Override
    protected BombLayerRenderSystemPrototype loadEntitySystemPrototype(EffectPrototype effectPrototype, int priority) {
        return new BombLayerRenderSystemPrototype(effectPrototype, priority);
    }
}
