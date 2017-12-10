package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class VehicleLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<VehicleLayerRenderSystemPrototype>
{
    @Override
    public SystemType getLoaderType() {
        return SystemType.VehicleLayerRenderSystem;
    }

    @Override
    protected VehicleLayerRenderSystemPrototype loadEntitySystemPrototype(int priority) {
        return new VehicleLayerRenderSystemPrototype(priority);
    }
}
