package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphic.effect.EffectPrototype;
import remove.tanks.game.graphic.effect.EffectPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public abstract class LayerRenderSystemPrototypeXmlLoader<T extends LayerRenderSystemPrototype>
        extends RegistrableEntitySystemPrototypeXmlLoader<T>
{
    private static final String HIGHLIGHT_ELEMENT = "highlight";

    private final EffectPrototypeXmlLoader effectPrototypeXmlLoader;

    public LayerRenderSystemPrototypeXmlLoader(EffectPrototypeXmlLoader effectPrototypeXmlLoader) {
        this.effectPrototypeXmlLoader = effectPrototypeXmlLoader;
    }

    @Override
    protected final T loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return loadEntitySystemPrototype(
                effectPrototypeXmlLoader.loadEffectPrototype(
                        element.getChildByName(HIGHLIGHT_ELEMENT)
                                .getChildByName(EffectPrototypeXmlLoader.EFFECT_ELEMENT)
                ),
                priority
        );
    }

    protected abstract T loadEntitySystemPrototype(EffectPrototype effectPrototype, int priority);
}
