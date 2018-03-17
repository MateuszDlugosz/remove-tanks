package remove.tanks.game.configuration.component.physics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.physics.body.BodyFactory;
import remove.tanks.game.physics.body.BodyPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class BodyConfiguration {
    @ComponentName("BodyPrefabXmlReader")
    public static final class BodyPrefabXmlReaderSupplier extends ComponentSupplier<BodyPrefabXmlReader> {
        @Override
        public BodyPrefabXmlReader supplyComponent() {
            return new BodyPrefabXmlReader();
        }
    }

    @ComponentName("BodyFactory")
    public static final class BodyFactorySupplier extends ComponentSupplier<BodyFactory> {
        @Override
        public BodyFactory supplyComponent() {
            return new BodyFactory();
        }
    }
}
