package remove.tanks.game.level.engine.system.layer;

import remove.tanks.game.graphic.effect.EffectPrototype;
import remove.tanks.game.graphic.effect.EffectPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class BulletLayerRenderSystemPrototypeXmlLoader
        extends LayerRenderSystemPrototypeXmlLoader<BulletLayerRenderSystemPrototype>
{
    public BulletLayerRenderSystemPrototypeXmlLoader(EffectPrototypeXmlLoader effectPrototypeXmlLoader) {
        super(effectPrototypeXmlLoader);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.BulletLayerRenderSystem;
    }

    @Override
    protected BulletLayerRenderSystemPrototype loadEntitySystemPrototype(int priority, EffectPrototype effectPrototype) {
        return new BulletLayerRenderSystemPrototype(priority, effectPrototype);
    }
}
