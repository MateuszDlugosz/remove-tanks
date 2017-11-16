package remove.tanks.game.graphic.effect;

import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import remove.tanks.game.graphic.shader.ShaderProgramFactory;

/**
 * @author Mateusz Długosz
 */
public final class ShaderEffectFactory implements RegistrableEffectFactory<ShaderEffect, ShaderEffectPrototype> {
    private final ShaderProgramFactory shaderProgramFactory;

    public ShaderEffectFactory(ShaderProgramFactory shaderProgramFactory) {
        this.shaderProgramFactory = shaderProgramFactory;
    }

    @Override
    public ShaderEffect createEffect(ShaderEffectPrototype prototype) {
        try {
            return new ShaderEffect(createShaderProgram(prototype));
        } catch (Exception e) {
            throw new EffectCreateException(prototype, e);
        }
    }

    private ShaderProgram createShaderProgram(ShaderEffectPrototype prototype) {
        return shaderProgramFactory.createShaderProgram(prototype.getShaderProgramPrototype());
    }

    @Override
    public Class<ShaderEffectPrototype> getFactoryType() {
        return ShaderEffectPrototype.class;
    }
}
