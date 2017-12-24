package remove.tanks.game.configuration.graphic;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphic.shader.ShaderProgramFactory;
import remove.tanks.game.graphic.shader.ShaderProgramPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ShaderProgramSupplierConfiguration {
    @ComponentName("ShaderProgramFactory")
    public static final class ShaderProgramFactorySupplier extends ComponentSupplier<ShaderProgramFactory> {
        @Override
        public ShaderProgramFactory supplyComponent() {
            return new ShaderProgramFactory();
        }
    }

    @ComponentName("ShaderProgramPrototypeXmlLoader")
    public static final class ShaderProgramPrototypeXmlLoaderSupplier extends ComponentSupplier<ShaderProgramPrototypeXmlLoader> {
        @Override
        public ShaderProgramPrototypeXmlLoader supplyComponent() {
            return new ShaderProgramPrototypeXmlLoader();
        }
    }
}
