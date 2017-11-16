package remove.tanks.game.graphic.shader;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ShaderProgramPrototypeXmlLoader {
    public static final String SHADER_PROGRAM_ELEMENT = "shaderProgram";

    private static final String VERTEX_SHADER_FILENAME_ELEMENT = "vertexShaderFilename";
    private static final String FRAGMENT_SHADER_FILENAME_ELEMENT = "fragmentShaderFilename";

    public ShaderProgramPrototype loadShaderProgramPrototype(XmlReader.Element element) {
        try {
            return new ShaderProgramPrototype(
                    loadVertexShaderFilename(element),
                    loadFragmentShaderFilename(element)
            );
        } catch (Exception e) {
            throw new ShaderProgramPrototypeXmlLoadException(element, e);
        }
    }

    private String loadVertexShaderFilename(XmlReader.Element element) {
        return element.getChildByName(VERTEX_SHADER_FILENAME_ELEMENT).getText().trim();
    }

    private String loadFragmentShaderFilename(XmlReader.Element element) {
        return element.getChildByName(FRAGMENT_SHADER_FILENAME_ELEMENT).getText().trim();
    }
}
