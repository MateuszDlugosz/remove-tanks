package remove.tanks.game.configuration.component.graphic;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphic.color.*;

/**
 * @author Mateusz Długosz
 */
public final class ColorSupplierConfiguration {
    @ComponentName("ColorFactory")
    public static final class ColorFactorySupplier extends ComponentSupplier<ColorFactory> {
        @Override
        public ColorFactory supplyComponent() {
            return new ColorFactory(
                    new RegistrableColorFactory[] {
                            new RgbColorFactory(),
                            new HexColorFactory(),
                            new RgbaColorFactory()
                    }
            );
        }
    }

    @ComponentName("ColorPrototypeXmlLoader")
    public static final class ColorPrototypeXmlLoaderSupplier extends ComponentSupplier<ColorPrototypeXmlLoader> {
        @Override
        public ColorPrototypeXmlLoader supplyComponent() {
            return new ColorPrototypeXmlLoader(
                    new RegistrableColorPrototypeXmlLoader[] {
                            new RgbColorPrototypeXmlLoader(),
                            new HexColorPrototypeXmlLoader(),
                            new RgbaColorPrototypeXmlLoader()
                    }
            );
        }
    }
}
