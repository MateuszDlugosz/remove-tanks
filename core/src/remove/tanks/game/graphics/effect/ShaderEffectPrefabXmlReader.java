package remove.tanks.game.graphics.effect;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.shader.ShaderProgramPrefab;
import remove.tanks.game.graphics.shader.ShaderProgramPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ShaderEffectPrefabXmlReader implements SubEffectPrefabXmlReader<ShaderEffectPrefab> {
    private final ShaderProgramPrefabXmlReader shaderProgramPrefabXmlReader;

    public ShaderEffectPrefabXmlReader(ShaderProgramPrefabXmlReader shaderProgramPrefabXmlReader) {
        this.shaderProgramPrefabXmlReader = shaderProgramPrefabXmlReader;
    }

    @Override
    public ShaderEffectPrefab readEffectPrefab(XmlReader.Element element) {
        try {
            return new ShaderEffectPrefab(readShaderProgramPrefab(element));
        } catch (Exception e) {
            throw new EffectPrefabXmlReadException(element, e);
        }
    }

    private ShaderProgramPrefab readShaderProgramPrefab(XmlReader.Element element) {
        return shaderProgramPrefabXmlReader.readShaderProgramPrefab(
                element.getChildByName(ShaderProgramPrefabXmlReader.SHADER_PROGRAM_ELEMENT)
        );
    }

    @Override
    public EffectType getReaderType() {
        return EffectType.ShaderEffect;
    }
}
