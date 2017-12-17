package remove.tanks.game.graphic.particle;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableParticleEffectPrototypeXmlLoader<T extends ParticleEffectPrototype> {
    T loadParticleEffectPrototype(XmlReader.Element element);
    ParticleEffectType getLoaderType();
}
