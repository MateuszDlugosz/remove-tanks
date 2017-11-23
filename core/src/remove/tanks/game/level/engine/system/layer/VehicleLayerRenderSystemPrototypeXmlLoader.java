package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.graphic.effect.EffectPrototype;
import remove.tanks.game.graphic.effect.EffectPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class VehicleLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<VehicleLayerRenderSystemPrototype>
{
    public VehicleLayerRenderSystemPrototypeXmlLoader(EffectPrototypeXmlLoader effectPrototypeXmlLoader) {
        super(effectPrototypeXmlLoader);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.VehicleLayerRenderSystem;
    }

    @Override
    protected VehicleLayerRenderSystemPrototype loadEntitySystemPrototype(int priority, EffectPrototype effectPrototype) {
        return new VehicleLayerRenderSystemPrototype(priority, effectPrototype);
    }
}
