package remove.tanks.game.configuration.component.physics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.physics.body.BodyFactory;
import remove.tanks.game.physics.body.BodyPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class BodySupplierConfiguration {
    @ComponentName("BodyFactory")
    public static final class BodyFactorySupplier extends ComponentSupplier<BodyFactory> {
        @Override
        public BodyFactory supplyComponent() {
            return new BodyFactory();
        }
    }

    @ComponentName("BodyPrototypeXmlLoader")
    public static final class BodyPrototypeXmlLoaderSupplier extends ComponentSupplier<BodyPrototypeXmlLoader> {
        @Override
        public BodyPrototypeXmlLoader supplyComponent() {
            return new BodyPrototypeXmlLoader();
        }
    }
}
