package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ParticleEffectLoader;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectParameterFactory
        implements RegistrableParameterFactory<ParticleEffectLoader.ParticleEffectParameter>
{
    public static final String ATLAS_FILE_PARAMETER = "atlasFile";
    public static final String ATLAS_PREFIX_PARAMETER = "atlasPrefix";
    public static final String IMAGES_DIR_PARAMETER = "imagesDir";

    @Override
    public ParticleEffectLoader.ParticleEffectParameter createParameters(ParameterPrototype prototype) {
        ParticleEffectLoader.ParticleEffectParameter pep = new ParticleEffectLoader.ParticleEffectParameter();
        pep.atlasFile = prototype.getParameters().get(ATLAS_FILE_PARAMETER);
        pep.atlasPrefix = prototype.getParameters().get(ATLAS_PREFIX_PARAMETER);
        if (prototype.getParameters().get(IMAGES_DIR_PARAMETER) != null) {
            pep.imagesDir = Gdx.files.internal(prototype.getParameters().get(IMAGES_DIR_PARAMETER));
        }
        return pep;
    }

    @Override
    public Class<ParticleEffectLoader.ParticleEffectParameter> getFactoryType() {
        return ParticleEffectLoader.ParticleEffectParameter.class;
    }
}
