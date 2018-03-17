package remove.tanks.game.configuration.component.graphics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphics.shader.ShaderProgramFactory;
import remove.tanks.game.graphics.shader.ShaderProgramPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ShaderConfiguration {
    @ComponentName("ShaderProgramPrefabXmlReader")
    public static final class ShaderProgramPrefabXmlReaderSupplier extends ComponentSupplier<ShaderProgramPrefabXmlReader> {
        @Override
        public ShaderProgramPrefabXmlReader supplyComponent() {
            return new ShaderProgramPrefabXmlReader();
        }
    }

    @ComponentName("ShaderProgramFactory")
    public static final class ShaderProgramFactorySupplier extends ComponentSupplier<ShaderProgramFactory> {
        @Override
        public ShaderProgramFactory supplyComponent() {
            return new ShaderProgramFactory();
        }
    }
}
