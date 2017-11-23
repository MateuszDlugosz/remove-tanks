package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.graphic.effect.EffectPrototype;
import remove.tanks.game.graphic.effect.EffectPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class BonusLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<BonusLayerRenderSystemPrototype>
{
    public BonusLayerRenderSystemPrototypeXmlLoader(EffectPrototypeXmlLoader effectPrototypeXmlLoader) {
        super(effectPrototypeXmlLoader);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.BonusLayerRenderSystem;
    }

    @Override
    protected BonusLayerRenderSystemPrototype loadEntitySystemPrototype(int priority, EffectPrototype effectPrototype) {
        return new BonusLayerRenderSystemPrototype(priority, effectPrototype);
    }
}
