package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.graphic.effect.EffectPrototype;
import remove.tanks.game.graphic.effect.EffectPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class CloudLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<CloudLayerRenderSystemPrototype>
{
    public CloudLayerRenderSystemPrototypeXmlLoader(EffectPrototypeXmlLoader effectPrototypeXmlLoader) {
        super(effectPrototypeXmlLoader);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.CloudLayerRenderSystem;
    }

    @Override
    protected CloudLayerRenderSystemPrototype loadEntitySystemPrototype(EffectPrototype effectPrototype, int priority) {
        return new CloudLayerRenderSystemPrototype(effectPrototype, priority);
    }
}
