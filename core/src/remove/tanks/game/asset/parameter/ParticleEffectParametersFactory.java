package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ParticleEffectLoader;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectParametersFactory
        implements SubParametersFactory<ParticleEffectLoader.ParticleEffectParameter>
{
    private static final String ATLAS_FILE_PARAMETER = "atlasFile";
    private static final String ATLAS_PREFIX_PARAMETER = "atlasPrefix";
    private static final String IMAGES_DIR_PARAMETER = "imagesDir";

    @Override
    public ParticleEffectLoader.ParticleEffectParameter createParameters(ParametersPrefab prefab) {
        try {
            ParticleEffectLoader.ParticleEffectParameter pep = new ParticleEffectLoader.ParticleEffectParameter();
            pep.atlasFile = prefab.getParameters().get(ATLAS_FILE_PARAMETER);
            pep.atlasPrefix = prefab.getParameters().get(ATLAS_PREFIX_PARAMETER);
            if (prefab.getParameters().get(IMAGES_DIR_PARAMETER) != null) {
                pep.imagesDir = Gdx.files.internal(prefab.getParameters().get(IMAGES_DIR_PARAMETER));
            }
            return pep;
        } catch (Exception e) {
            throw new ParametersCreateException(prefab, e);
        }
    }

    @Override
    public Class<ParticleEffectLoader.ParticleEffectParameter> getFactoryType() {
        return ParticleEffectLoader.ParticleEffectParameter.class;
    }
}
