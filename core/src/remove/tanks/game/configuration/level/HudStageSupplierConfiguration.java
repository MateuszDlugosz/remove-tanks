package remove.tanks.game.configuration.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.level.engine.system.hud.stages.HudStageFactory;
import remove.tanks.game.level.engine.system.hud.stages.HudStagePrototypeXmlLoader;
import remove.tanks.game.level.engine.system.hud.stages.message.MessageBarFactory;
import remove.tanks.game.level.engine.system.hud.stages.message.MessageBarPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.hud.stages.message.MessageFactory;
import remove.tanks.game.level.engine.system.hud.stages.message.MessagePrototypeXmlLoader;
import remove.tanks.game.level.engine.system.hud.stages.state.StateBarFactory;
import remove.tanks.game.level.engine.system.hud.stages.state.StateBarPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.hud.stages.widget.RegistrableWidgetFactory;
import remove.tanks.game.level.engine.system.hud.stages.widget.RegistrableWidgetPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetFactory;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.hud.stages.widget.property.PropertyPresenterWidgetFactory;
import remove.tanks.game.level.engine.system.hud.stages.widget.property.PropertyPresenterWidgetPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class HudStageSupplierConfiguration {
    @ComponentName("HudStageFactory")
    public static final class HudStageFactorySupplier extends ComponentSupplier<HudStageFactory> {
        @Override
        public HudStageFactory supplyComponent() {
            return new HudStageFactory(
                    getContext().getComponent("WidgetFactory", WidgetFactory.class),
                    getContext().getComponent("StateBarFactory", StateBarFactory.class),
                    getContext().getComponent("MessageBarFactory", MessageBarFactory.class)
            );
        }
    }

    @ComponentName("HudStagePrototypeXmlLoader")
    public static final class HudStagePrototypeXmlLoaderSupplier extends ComponentSupplier<HudStagePrototypeXmlLoader> {
        @Override
        public HudStagePrototypeXmlLoader supplyComponent() {
            return new HudStagePrototypeXmlLoader(
                    getContext().getComponent("WidgetPrototypeXmlLoader", WidgetPrototypeXmlLoader.class),
                    getContext().getComponent("StateBarPrototypeXmlLoader", StateBarPrototypeXmlLoader.class),
                    getContext().getComponent("MessageBarPrototypeXmlLoader", MessageBarPrototypeXmlLoader.class)
            );
        }
    }

    @ComponentName("WidgetFactory")
    public static final class WidgetFactorySupplier extends ComponentSupplier<WidgetFactory> {
        @Override
        public WidgetFactory supplyComponent() {
            return new WidgetFactory(
                    new RegistrableWidgetFactory[] {
                            new PropertyPresenterWidgetFactory()
                    }
            );
        }
    }

    @ComponentName("WidgetPrototypeXmlLoader")
    public static final class WidgetPrototypeXmlLoaderSupplier extends ComponentSupplier<WidgetPrototypeXmlLoader> {
        @Override
        public WidgetPrototypeXmlLoader supplyComponent() {
            return new WidgetPrototypeXmlLoader(
                    new RegistrableWidgetPrototypeXmlLoader[] {
                            new PropertyPresenterWidgetPrototypeXmlLoader()
                    }
            );
        }
    }

    @ComponentName("StateBarFactory")
    public static final class StateBarFactorySupplier extends ComponentSupplier<StateBarFactory> {
        @Override
        public StateBarFactory supplyComponent() {
            return new StateBarFactory();
        }
    }

    @ComponentName("StateBarPrototypeXmlLoader")
    public static final class StateBarPrototypeXmlLoaderSupplier extends ComponentSupplier<StateBarPrototypeXmlLoader> {
        @Override
        public StateBarPrototypeXmlLoader supplyComponent() {
            return new StateBarPrototypeXmlLoader();
        }
    }

    @ComponentName("MessageBarPrototypeXmlLoader")
    public static final class MessageBarPrototypeXmlLoaderSupplier extends ComponentSupplier<MessageBarPrototypeXmlLoader> {
        @Override
        public MessageBarPrototypeXmlLoader supplyComponent() {
            return new MessageBarPrototypeXmlLoader();
        }
    }

    @ComponentName("MessageBarFactory")
    public static final class MessageBarFactorySupplier extends ComponentSupplier<MessageBarFactory> {
        @Override
        public MessageBarFactory supplyComponent() {
            return new MessageBarFactory();
        }
    }

    @ComponentName("MessagePrototypeXmlLoader")
    public static final class MessagePrototypeXmlLoaderSupplier extends ComponentSupplier<MessagePrototypeXmlLoader> {
        @Override
        public MessagePrototypeXmlLoader supplyComponent() {
            return new MessagePrototypeXmlLoader();
        }
    }

    @ComponentName("MessageFactory")
    public static final class MessageFactorySupplier extends ComponentSupplier<MessageFactory> {
        @Override
        public MessageFactory supplyComponent() {
            return new MessageFactory();
        }
    }
}
