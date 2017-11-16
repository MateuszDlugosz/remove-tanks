package remove.tanks.game.graphic.particle;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectPrototypeXmlLoader {
    public static final String PARTICLE_EFFECT_ELEMENT = "particleEffect";
    public static final String PARTICLE_EFFECTS_ELEMENT = "particleEffects";

    private static final String FILENAME_ELEMENT = "filename";
    private static final String FLIP_X_ATTRIBUTE = "flipX";
    private static final String FLIP_Y_ATTRIBUTE = "flipY";

    private static final boolean FLIP_X_DEFAULT_VALUE = false;
    private static final boolean FLIP_Y_DEFAULT_VALUE = false;

    public List<ParticleEffectPrototype> loadParticleEffectPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(PARTICLE_EFFECT_ELEMENT).toArray())
                .map(this::loadParticleEffectPrototype)
                .collect(Collectors.toList());
    }

    public ParticleEffectPrototype loadParticleEffectPrototype(XmlReader.Element element) {
        try {
            return new ParticleEffectPrototype(
                    loadFilename(element),
                    loadFlipX(element),
                    loadFlipY(element)
            );
        } catch (Exception e) {
            throw new ParticleEffectPrototypeXmlLoadException(element, e);
        }
    }

    private String loadFilename(XmlReader.Element element) {
        return element.getChildByName(FILENAME_ELEMENT).getText();
    }

    private boolean loadFlipX(XmlReader.Element element) {
        return element.getBoolean(FLIP_X_ATTRIBUTE, FLIP_X_DEFAULT_VALUE);
    }

    private boolean loadFlipY(XmlReader.Element element) {
        return element.getBoolean(FLIP_Y_ATTRIBUTE, FLIP_Y_DEFAULT_VALUE);
    }
}
