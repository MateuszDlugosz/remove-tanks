package remove.tanks.game.graphics.particle;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectPrefabXmlReader {
    public static final String PARTICLE_EFFECT_ELEMENT = "particleEffect";
    public static final String PARTICLE_EFFECTS_ELEMENT = "particleEffects";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<ParticleEffectType, SubParticleEffectPrefabXmlReader> readers
            = new EnumMap<>(ParticleEffectType.class);

    public ParticleEffectPrefabXmlReader(SubParticleEffectPrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(l -> this.readers.put(l.getReaderType(), l));
    }

    public List<ParticleEffectPrefab> readParticleEffectPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(PARTICLE_EFFECT_ELEMENT).toArray())
                .map(this::readParticleEffectPrefab)
                .collect(Collectors.toList());
    }

    public ParticleEffectPrefab readParticleEffectPrefab(XmlReader.Element element) {
        try {
            ParticleEffectType type = ParticleEffectType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!readers.containsKey(type)) {
                throw new ParticleEffectPrefabReaderNotFoundException(type);
            }
            return readers.get(type).readParticleEffectPrefab(element);
        } catch (Exception e) {
            throw new ParticleEffectPrefabXmlReadException(element, e);
        }
    }
}
