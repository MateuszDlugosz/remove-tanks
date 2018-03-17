package remove.tanks.game.configuration.component.graphics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphics.color.ColorFactory;
import remove.tanks.game.graphics.color.ColorPrefabXmlReader;
import remove.tanks.game.graphics.effect.*;
import remove.tanks.game.graphics.shader.ShaderProgramFactory;
import remove.tanks.game.graphics.shader.ShaderProgramPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class EffectConfiguration {
    @ComponentName("EffectPrefabXmlReader")
    public static final class EffectPrefabXmlReaderSupplier extends ComponentSupplier<EffectPrefabXmlReader> {
        @Override
        public EffectPrefabXmlReader supplyComponent() {
            return new EffectPrefabXmlReader(
                    new SubEffectPrefabXmlReader[] {
                            new AlphaEffectPrefabXmlReader(),
                            new TintEffectPrefabXmlReader(
                                    getContext().getComponent("ColorPrefabXmlReader", ColorPrefabXmlReader.class)
                            ),
                            new ShaderEffectPrefabXmlReader(
                                    getContext().getComponent("ShaderProgramPrefabXmlReader", ShaderProgramPrefabXmlReader.class)
                            )
                    }
            );
        }
    }

    @ComponentName("EffectFactory")
    public static final class EffectFactorySupplier extends ComponentSupplier<EffectFactory> {
        @Override
        public EffectFactory supplyComponent() {
            return new EffectFactory(
                    new SubEffectFactory[] {
                            new AlphaEffectFactory(),
                            new TintEffectFactory(
                                    getContext().getComponent("ColorFactory", ColorFactory.class)
                            ),
                            new ShaderEffectFactory(
                                    getContext().getComponent("ShaderProgramFactory", ShaderProgramFactory.class)
                            )
                    }
            );
        }
    }
}
