package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.graphic.effect.EffectPrototype;
import remove.tanks.game.graphic.effect.EffectPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class GroundLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<GroundLayerRenderSystemPrototype>
{
    public GroundLayerRenderSystemPrototypeXmlLoader(EffectPrototypeXmlLoader effectPrototypeXmlLoader) {
        super(effectPrototypeXmlLoader);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.GroundLayerRenderSystem;
    }

    @Override
    protected GroundLayerRenderSystemPrototype loadEntitySystemPrototype(int priority, EffectPrototype effectPrototype) {
        return new GroundLayerRenderSystemPrototype(priority, effectPrototype);
    }
}
