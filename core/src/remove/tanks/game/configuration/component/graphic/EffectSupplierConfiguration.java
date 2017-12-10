package remove.tanks.game.configuration.component.graphic;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphic.color.ColorFactory;
import remove.tanks.game.graphic.color.ColorPrototypeXmlLoader;
import remove.tanks.game.graphic.effect.*;
import remove.tanks.game.graphic.shader.ShaderProgramFactory;
import remove.tanks.game.graphic.shader.ShaderProgramPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class EffectSupplierConfiguration {
    @ComponentName("EffectFactory")
    public static final class EffectFactorySupplier extends ComponentSupplier<EffectFactory> {
        @Override
        public EffectFactory supplyComponent() {
            return new EffectFactory(
                    new RegistrableEffectFactory[] {
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

    @ComponentName("EffectPrototypeXmlLoader")
    public static final class EffectPrototypeXmlLoaderSupplier extends ComponentSupplier<EffectPrototypeXmlLoader> {
        @Override
        public EffectPrototypeXmlLoader supplyComponent() {
            return new EffectPrototypeXmlLoader(
                    new RegistrableEffectPrototypeXmlLoader[] {
                            new AlphaEffectPrototypeXmlLoader(),
                            new TintEffectPrototypeXmlLoader(
                                    getContext().getComponent("ColorPrototypeXmlLoader", ColorPrototypeXmlLoader.class)
                            ),
                            new ShaderEffectPrototypeXmlLoader(
                                    getContext().getComponent("ShaderProgramPrototypeXmlLoader", ShaderProgramPrototypeXmlLoader.class)
                            )
                    },
                    getContext().getComponent("XmlReader", XmlReader.class)
            );
        }
    }
}
