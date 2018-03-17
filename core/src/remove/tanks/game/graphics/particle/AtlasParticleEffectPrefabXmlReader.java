package remove.tanks.game.graphics.particle;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AtlasParticleEffectPrefabXmlReader implements SubParticleEffectPrefabXmlReader<AtlasParticleEffectPrefab> {
    private static final String FILENAME_ELEMENT = "filename";
    private static final String ATLAS_FILENAME_ELEMENT = "atlasFilename";

    private static final String FLIP_X_ATTRIBUTE = "flipX";
    private static final String FLIP_Y_ATTRIBUTE = "flipY";

    private static final boolean FLIP_X_DEFAULT_VALUE = false;
    private static final boolean FLIP_Y_DEFAULT_VALUE = false;

    @Override
    public AtlasParticleEffectPrefab readParticleEffectPrefab(XmlReader.Element element) {
        try {
            return new AtlasParticleEffectPrefab(
                    readFilename(element),
                    readAtlasFilename(element),
                    readFlipX(element),
                    readFlipY(element)
            );
        } catch (Exception e) {
            throw new ParticleEffectPrefabXmlReadException(element, e);
        }
    }

    private String readFilename(XmlReader.Element element) {
        return element.getChildByName(FILENAME_ELEMENT).getText().trim();
    }

    private String readAtlasFilename(XmlReader.Element element) {
        return element.getChildByName(ATLAS_FILENAME_ELEMENT).getText().trim();
    }

    private boolean readFlipX(XmlReader.Element element) {
        return element.getBoolean(FLIP_X_ATTRIBUTE, FLIP_X_DEFAULT_VALUE);
    }

    private boolean readFlipY(XmlReader.Element element) {
        return element.getBoolean(FLIP_Y_ATTRIBUTE, FLIP_Y_DEFAULT_VALUE);
    }

    @Override
    public ParticleEffectType getReaderType() {
        return ParticleEffectType.AtlasParticleEffect;
    }
}
