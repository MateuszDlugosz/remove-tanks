package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.graphic.effect.EffectPrototype;
import remove.tanks.game.graphic.effect.EffectPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class ObstacleLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<ObstacleLayerRenderSystemPrototype>
{
    public ObstacleLayerRenderSystemPrototypeXmlLoader(EffectPrototypeXmlLoader effectPrototypeXmlLoader) {
        super(effectPrototypeXmlLoader);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.ObstacleLayerRenderSystem;
    }

    @Override
    protected ObstacleLayerRenderSystemPrototype loadEntitySystemPrototype(EffectPrototype effectPrototype, int priority) {
        return new ObstacleLayerRenderSystemPrototype(effectPrototype, priority);
    }
}
