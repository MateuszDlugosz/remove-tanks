package remove.tanks.game.graphic.effect;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphic.shader.ShaderProgramPrototype;
import remove.tanks.game.graphic.shader.ShaderProgramPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ShaderEffectPrototypeXmlLoader
        implements RegistrableEffectPrototypeXmlLoader<ShaderEffectPrototype>
{
    private final ShaderProgramPrototypeXmlLoader shaderProgramPrototypeXmlLoader;

    public ShaderEffectPrototypeXmlLoader(ShaderProgramPrototypeXmlLoader shaderProgramPrototypeXmlLoader) {
        this.shaderProgramPrototypeXmlLoader = shaderProgramPrototypeXmlLoader;
    }

    @Override
    public ShaderEffectPrototype loadEffectPrototype(XmlReader.Element element) {
        try {
            return new ShaderEffectPrototype(loadShaderProgramPrototype(element));
        } catch (Exception e) {
            throw new EffectPrototypeXmlLoadException(element, e);
        }
    }

    private ShaderProgramPrototype loadShaderProgramPrototype(XmlReader.Element element) {
        return shaderProgramPrototypeXmlLoader.loadShaderProgramPrototype(
                element.getChildByName(ShaderProgramPrototypeXmlLoader.SHADER_PROGRAM_ELEMENT)
        );
    }

    @Override
    public EffectType getLoaderType() {
        return EffectType.ShaderEffect;
    }
}
