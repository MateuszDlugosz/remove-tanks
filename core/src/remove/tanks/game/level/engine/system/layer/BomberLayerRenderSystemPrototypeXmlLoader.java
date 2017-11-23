package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.graphic.effect.EffectPrototype;
import remove.tanks.game.graphic.effect.EffectPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class BomberLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<BomberLayerRenderSystemPrototype>
{
    public BomberLayerRenderSystemPrototypeXmlLoader(EffectPrototypeXmlLoader effectPrototypeXmlLoader) {
        super(effectPrototypeXmlLoader);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.BomberLayerRenderSystem;
    }

    @Override
    protected BomberLayerRenderSystemPrototype loadEntitySystemPrototype(int priority, EffectPrototype effectPrototype) {
        return new BomberLayerRenderSystemPrototype(priority, effectPrototype);
    }
}
