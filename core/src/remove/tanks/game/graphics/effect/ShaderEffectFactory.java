package remove.tanks.game.graphics.effect;

import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.shader.ShaderProgramFactory;

/**
 * @author Mateusz Długosz
 */
public final class ShaderEffectFactory implements SubEffectFactory<ShaderEffect, ShaderEffectPrefab> {
    private final ShaderProgramFactory shaderProgramFactory;

    public ShaderEffectFactory(ShaderProgramFactory shaderProgramFactory) {
        this.shaderProgramFactory = shaderProgramFactory;
    }

    @Override
    public ShaderEffect createEffect(ShaderEffectPrefab prefab, AssetStorage assetStorage) {
        try {
            return new ShaderEffect(createShaderProgram(prefab, assetStorage));
        } catch (Exception e) {
            throw new EffectCreateException(prefab, e);
        }
    }

    private ShaderProgram createShaderProgram(ShaderEffectPrefab prefab, AssetStorage assetStorage) {
        return shaderProgramFactory.createShaderProgram(prefab.getShaderProgramPrefab(), assetStorage);
    }

    @Override
    public Class<ShaderEffectPrefab> getFactoryType() {
        return ShaderEffectPrefab.class;
    }
}
