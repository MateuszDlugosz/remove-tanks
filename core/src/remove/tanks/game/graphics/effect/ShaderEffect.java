package remove.tanks.game.graphics.effect;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

/**
 * @author Mateusz Długosz
 */
public final class ShaderEffect implements Effect {
    private final ShaderProgram shaderProgram;
    private ShaderProgram previousShaderProgram;

    public ShaderEffect(ShaderProgram shaderProgram) {
        this.shaderProgram = shaderProgram;
    }

    @Override
    public void begin(SpriteBatch spriteBatch) {
        previousShaderProgram = spriteBatch.getShader();
        spriteBatch.setShader(shaderProgram);
    }

    @Override
    public void end(SpriteBatch spriteBatch) {
        spriteBatch.setShader(previousShaderProgram);
    }
}
