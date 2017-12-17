package remove.tanks.game.graphic.particle;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectPrototypeXmlLoader {
    public static final String PARTICLE_EFFECT_ELEMENT = "particleEffect";
    public static final String PARTICLE_EFFECTS_ELEMENT = "particleEffects";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<ParticleEffectType, RegistrableParticleEffectPrototypeXmlLoader> loaders
            = new HashMap<>();

    public ParticleEffectPrototypeXmlLoader(RegistrableParticleEffectPrototypeXmlLoader[] loaders) {
        Arrays.stream(loaders).forEach(l -> this.loaders.put(l.getLoaderType(), l));
    }

    public List<ParticleEffectPrototype> loadParticleEffectPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(PARTICLE_EFFECT_ELEMENT).toArray())
                .map(this::loadParticleEffectPrototype)
                .collect(Collectors.toList());
    }

    public ParticleEffectPrototype loadParticleEffectPrototype(XmlReader.Element element) {
        try {
            ParticleEffectType type = ParticleEffectType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!loaders.containsKey(type)) {
                throw new ParticleEffectLoaderNotFoundException(type);
            }
            return loaders.get(type).loadParticleEffectPrototype(element);
        } catch (Exception e) {
            throw new ParticleEffectPrototypeXmlLoadException(element, e);
        }
    }
}
