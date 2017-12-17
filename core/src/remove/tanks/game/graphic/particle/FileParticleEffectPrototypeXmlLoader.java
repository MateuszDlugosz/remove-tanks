package remove.tanks.game.graphic.particle;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class FileParticleEffectPrototypeXmlLoader
        implements RegistrableParticleEffectPrototypeXmlLoader<FileParticleEffectPrototype>
{
    private static final String FILENAME_ELEMENT = "filename";
    private static final String IMAGES_DIRECTORY_ELEMENT = "imagesDirectory";

    private static final String FLIP_X_ATTRIBUTE = "flipX";
    private static final String FLIP_Y_ATTRIBUTE = "flipY";

    private static final boolean FLIP_X_DEFAULT_VALUE = false;
    private static final boolean FLIP_Y_DEFAULT_VALUE = false;

    @Override
    public FileParticleEffectPrototype loadParticleEffectPrototype(XmlReader.Element element) {
        try {
            return new FileParticleEffectPrototype(
                    loadFilename(element),
                    loadImagesDirectory(element),
                    loadFlipX(element),
                    loadFlipY(element)
            );
        } catch (Exception e) {
            throw new ParticleEffectPrototypeXmlLoadException(element, e);
        }
    }

    private String loadFilename(XmlReader.Element element) {
        return element.getChildByName(FILENAME_ELEMENT).getText().trim();
    }

    private String loadImagesDirectory(XmlReader.Element element) {
        return element.getChildByName(IMAGES_DIRECTORY_ELEMENT).getText().trim();
    }

    private boolean loadFlipX(XmlReader.Element element) {
        return element.getBoolean(FLIP_X_ATTRIBUTE, FLIP_X_DEFAULT_VALUE);
    }

    private boolean loadFlipY(XmlReader.Element element) {
        return element.getBoolean(FLIP_Y_ATTRIBUTE, FLIP_Y_DEFAULT_VALUE);
    }

    @Override
    public ParticleEffectType getLoaderType() {
        return ParticleEffectType.FileParticleEffect;
    }
}
