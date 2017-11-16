package remove.tanks.game.graphic.shader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ShaderProgramFactory {
    public List<ShaderProgram> createShaderPrograms(List<ShaderProgramPrototype> programPrototypes) {
        return programPrototypes.stream()
                .map(this::createShaderProgram)
                .collect(Collectors.toList());
    }

    public ShaderProgram createShaderProgram(ShaderProgramPrototype prototype) {
        try {
            return new ShaderProgram(
                    Gdx.files.internal(prototype.getVertexShaderFilename()),
                    Gdx.files.internal(prototype.getFragmentShaderFilename())
            );
        } catch (Exception e) {
            throw new ShaderProgramCreateException(prototype, e);
        }
    }
}
