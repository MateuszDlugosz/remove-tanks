package remove.tanks.game.graphic.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphic.particle.ParticleEffectPrototype;
import remove.tanks.game.graphic.particle.ParticleEffectPrototypeXmlLoader;
import remove.tanks.game.utility.position.PositionPrototype;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectViewPrototypeXmlLoader
        implements RegistrableViewPrototypeXmlLoader<ParticleEffectViewPrototype>
{
    private static final String ID_ATTRIBUTE = "id";

    private final PositionPrototypeXmlLoader positionPrototypeXmlLoader;
    private final ParticleEffectPrototypeXmlLoader particleEffectPrototypeXmlLoader;

    public ParticleEffectViewPrototypeXmlLoader(
            PositionPrototypeXmlLoader positionPrototypeXmlLoader,
            ParticleEffectPrototypeXmlLoader particleEffectPrototypeXmlLoader
    ) {
        this.positionPrototypeXmlLoader = positionPrototypeXmlLoader;
        this.particleEffectPrototypeXmlLoader = particleEffectPrototypeXmlLoader;
    }

    @Override
    public ParticleEffectViewPrototype loadViewPrototype(XmlReader.Element element) {
        try {
            return new ParticleEffectViewPrototype(
                    loadId(element),
                    loadViewPositionPrototype(element),
                    loadParticleEffectPrototype(element)
            );
        } catch (Exception e) {
            throw new ViewPrototypeXmlLoadException(element, e);
        }
    }

    private String loadId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE);
    }

    private PositionPrototype loadViewPositionPrototype(XmlReader.Element element) {
        return element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT) == null
                ? new PositionPrototype(0,0)
                : positionPrototypeXmlLoader.loadPositionPrototype(
                element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT)
        );
    }

    private ParticleEffectPrototype loadParticleEffectPrototype(XmlReader.Element element) {
        return particleEffectPrototypeXmlLoader.loadParticleEffectPrototype(
                element.getChildByName(ParticleEffectPrototypeXmlLoader.PARTICLE_EFFECT_ELEMENT)
        );
    }

    @Override
    public ViewType getLoaderType() {
        return ViewType.ParticleEffectView;
    }
}
