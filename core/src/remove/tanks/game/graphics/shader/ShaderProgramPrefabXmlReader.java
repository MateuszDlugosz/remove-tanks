package remove.tanks.game.graphics.shader;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ShaderProgramPrefabXmlReader {
    public static final String SHADER_PROGRAM_ELEMENT = "shaderProgram";
    public static final String SHADER_PROGRAMS_ELEMENT = "shaderPrograms";

    private static final String VERTEX_SHADER_FILENAME_ELEMENT = "vertexShaderFilename";
    private static final String FRAGMENT_SHADER_FILENAME_ELEMENT = "fragmentShaderFilename";

    public ShaderProgramPrefab readShaderProgramPrefab(XmlReader.Element element) {
        try {
            return new ShaderProgramPrefab(
                    readVertexShaderFilename(element),
                    readFragmentShaderFilename(element)
            );
        } catch (Exception e) {
            throw new ShaderProgramPrefabXmlReadException(element, e);
        }
    }

    private String readVertexShaderFilename(XmlReader.Element element) {
        return element.getChildByName(VERTEX_SHADER_FILENAME_ELEMENT).getText().trim();
    }

    private String readFragmentShaderFilename(XmlReader.Element element) {
        return element.getChildByName(FRAGMENT_SHADER_FILENAME_ELEMENT).getText().trim();
    }
}
