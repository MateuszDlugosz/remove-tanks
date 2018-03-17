package remove.tanks.game.configuration.component.graphics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphics.color.*;

/**
 * @author Mateusz Długosz
 */
public final class ColorConfiguration {
    @ComponentName("ColorPrefabXmlReader")
    public static final class ColorPrefabXmlReaderSupplier extends ComponentSupplier<ColorPrefabXmlReader> {
        @Override
        public ColorPrefabXmlReader supplyComponent() {
            return new ColorPrefabXmlReader(
                    new SubColorPrefabXmlReader[] {
                            new HexColorPrefabXmlReader(),
                            new RgbColorPrefabXmlReader(),
                            new RgbaColorPrefabXmlReader()
                    }
            );
        }
    }

    @ComponentName("ColorFactory")
    public static final class ColorFactorySupplier extends ComponentSupplier<ColorFactory> {
        @Override
        public ColorFactory supplyComponent() {
            return new ColorFactory(
                    new SubColorFactory[] {
                            new HexColorFactory(),
                            new RgbColorFactory(),
                            new RgbaColorFactory()
                    }
            );
        }
    }
}
