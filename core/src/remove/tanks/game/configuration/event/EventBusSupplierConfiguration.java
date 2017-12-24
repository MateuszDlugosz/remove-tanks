package remove.tanks.game.configuration.event;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;

/**
 * @author Mateusz Długosz
 */
public final class EventBusSupplierConfiguration {
    @ComponentName("EventBus")
    public static final class EventBusSupplier extends ComponentSupplier<EventBus> {
        @Override
        public EventBus supplyComponent() {
            return new EventBus();
        }
    }
}
