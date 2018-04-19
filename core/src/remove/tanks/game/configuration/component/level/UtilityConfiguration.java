package remove.tanks.game.configuration.component.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.audio.sound.SoundFactory;
import remove.tanks.game.audio.sound.SoundPrefabXmlReader;
import remove.tanks.game.graphics.color.ColorFactory;
import remove.tanks.game.graphics.color.ColorPrefabXmlReader;
import remove.tanks.game.graphics.particle.ParticleEffectFactory;
import remove.tanks.game.graphics.particle.ParticleEffectPrefabXmlReader;
import remove.tanks.game.graphics.sprite.SpriteFactory;
import remove.tanks.game.graphics.sprite.SpritePrefabXmlReader;
import remove.tanks.game.level.engine.entity.EntityPrefabCodeXmlReader;
import remove.tanks.game.level.event.EventFactory;
import remove.tanks.game.level.event.EventPrefabXmlReader;
import remove.tanks.game.level.utility.create.CreateEntryFactory;
import remove.tanks.game.level.utility.create.CreateEntryPrefabXmlReader;
import remove.tanks.game.level.utility.direction.DirectionXmlReader;
import remove.tanks.game.level.utility.spawner.SpawnerFactory;
import remove.tanks.game.level.utility.spawner.SpawnerPrefabXmlReader;
import remove.tanks.game.level.utility.stage.HudStageFactory;
import remove.tanks.game.level.utility.stage.HudStagePrefabXmlReader;
import remove.tanks.game.level.utility.stage.broker.MessageBarFactory;
import remove.tanks.game.level.utility.stage.broker.MessageBarPrefabXmlReader;
import remove.tanks.game.level.utility.stage.broker.face.FaceFactory;
import remove.tanks.game.level.utility.stage.broker.face.FacePrefabXmlReader;
import remove.tanks.game.level.utility.stage.broker.message.MessageFactory;
import remove.tanks.game.level.utility.stage.broker.message.MessagePrefabXmlReader;
import remove.tanks.game.level.utility.stage.broker.printer.MessagePrinterFactory;
import remove.tanks.game.level.utility.stage.broker.printer.MessagePrinterPrefabXmlReader;
import remove.tanks.game.level.utility.stage.state.StateBarFactory;
import remove.tanks.game.level.utility.stage.state.StateBarPrefabXmlReader;
import remove.tanks.game.level.utility.stage.widget.SubWidgetFactory;
import remove.tanks.game.level.utility.stage.widget.SubWidgetPrefabXmlReader;
import remove.tanks.game.level.utility.stage.widget.WidgetFactory;
import remove.tanks.game.level.utility.stage.widget.WidgetPrefabXmlReader;
import remove.tanks.game.level.utility.stage.widget.points.PointsPresenterWidgetFactory;
import remove.tanks.game.level.utility.stage.widget.points.PointsPresenterWidgetPrefabXmlReader;
import remove.tanks.game.level.utility.stage.widget.property.PropertyPresenterWidgetFactory;
import remove.tanks.game.level.utility.stage.widget.property.PropertyPresenterWidgetPrefabXmlReader;
import remove.tanks.game.level.utility.stage.widget.time.TimeLeftPresenterWidgetFactory;
import remove.tanks.game.level.utility.stage.widget.time.TimeLeftPresenterWidgetPrefabXmlReader;
import remove.tanks.game.level.utility.state.StateXmlReader;
import remove.tanks.game.level.utility.timeline.TimelineEntryFactory;
import remove.tanks.game.level.utility.timeline.TimelineEntryPrefabXmlReader;
import remove.tanks.game.level.utility.timeline.TimelineFactory;
import remove.tanks.game.level.utility.timeline.TimelinePrefabXmlReader;
import remove.tanks.game.level.utility.weather.WeatherFactory;
import remove.tanks.game.level.utility.weather.WeatherPrefabXmlReader;
import remove.tanks.game.level.utility.weather.effect.SubWeatherEffectFactory;
import remove.tanks.game.level.utility.weather.effect.SubWeatherEffectPrefabXmlReader;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectFactory;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefabXmlReader;
import remove.tanks.game.level.utility.weather.effect.lightning.LightningWeatherEffectFactory;
import remove.tanks.game.level.utility.weather.effect.lightning.LightningWeatherEffectPrefabXmlReader;
import remove.tanks.game.level.utility.weather.effect.rainfall.RainfallWeatherEffectFactory;
import remove.tanks.game.level.utility.weather.effect.rainfall.RainfallWeatherEffectPrefabXmlReader;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;
import remove.tanks.game.utility.surface.position.PositionFactory;
import remove.tanks.game.utility.surface.position.PositionPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class UtilityConfiguration {
    @ComponentName("StateXmlReader")
    public static final class StateXmlReaderSupplier extends ComponentSupplier<StateXmlReader> {
        @Override
        public StateXmlReader supplyComponent() {
            return new StateXmlReader();
        }
    }

    @ComponentName("DirectionXmlReader")
    public static final class DirectionXmlReaderSupplier extends ComponentSupplier<DirectionXmlReader> {
        @Override
        public DirectionXmlReader supplyComponent() {
            return new DirectionXmlReader();
        }
    }

    @ComponentName("CreateEntryPrefabXmlReader")
    public static final class SpawnEntryPrefabXmlReaderSupplier extends ComponentSupplier<CreateEntryPrefabXmlReader> {
        @Override
        public CreateEntryPrefabXmlReader supplyComponent() {
            return new CreateEntryPrefabXmlReader(
                    getContext().getComponent("PositionPrefabXmlReader", PositionPrefabXmlReader.class),
                    getContext().getComponent("EntityPrefabCodeXmlReader", EntityPrefabCodeXmlReader.class)
            );
        }
    }

    @ComponentName("CreateEntryFactory")
    public static final class PositionEntryFactorySupplier extends ComponentSupplier<CreateEntryFactory> {
        @Override
        public CreateEntryFactory supplyComponent() {
            return new CreateEntryFactory(
                    getContext().getComponent("PositionFactory", PositionFactory.class)
            );
        }
    }

    @ComponentName("SpawnerPrefabXmlReader")
    public static final class SpawnerPrefabXmlReaderSupplier extends ComponentSupplier<SpawnerPrefabXmlReader> {
        @Override
        public SpawnerPrefabXmlReader supplyComponent() {
            return new SpawnerPrefabXmlReader(
                    getContext().getComponent("EntityPrefabCodeXmlReader", EntityPrefabCodeXmlReader.class)
            );
        }
    }

    @ComponentName("SpawnerFactory")
    public static final class SpawnerFactorySupplier extends ComponentSupplier<SpawnerFactory> {
        @Override
        public SpawnerFactory supplyComponent() {
            return new SpawnerFactory();
        }
    }

    @ComponentName("TimelineFactory")
    public static final class TimelineFactorySupplier extends ComponentSupplier<TimelineFactory> {
        @Override
        public TimelineFactory supplyComponent() {
            return new TimelineFactory(
                    getContext().getComponent("TimelineEntryFactory", TimelineEntryFactory.class)
            );
        }
    }

    @ComponentName("TimelinePrefabXmlReader")
    public static final class TimelinePrefabXmlReaderSupplier extends ComponentSupplier<TimelinePrefabXmlReader> {
        @Override
        public TimelinePrefabXmlReader supplyComponent() {
            return new TimelinePrefabXmlReader(
                    getContext().getComponent("TimelineEntryPrefabXmlReader", TimelineEntryPrefabXmlReader.class)
            );
        }
    }

    @ComponentName("TimelineEntryFactory")
    public static final class TimelineEntryFactorySupplier extends ComponentSupplier<TimelineEntryFactory> {
        @Override
        public TimelineEntryFactory supplyComponent() {
            return new TimelineEntryFactory(
                    getContext().getComponent("EventFactory", EventFactory.class)
            );
        }
    }

    @ComponentName("TimelineEntryPrefabXmlReader")
    public static final class TimelineEntryPrefabXmlReaderSupplier extends ComponentSupplier<TimelineEntryPrefabXmlReader> {
        @Override
        public TimelineEntryPrefabXmlReader supplyComponent() {
            return new TimelineEntryPrefabXmlReader(
                    getContext().getComponent("EventPrefabXmlReader", EventPrefabXmlReader.class)
            );
        }
    }

    @ComponentName("HudStagePrefabXmlReader")
    public static final class HudStagePrefabXmlReaderSupplier extends ComponentSupplier<HudStagePrefabXmlReader> {
        @Override
        public HudStagePrefabXmlReader supplyComponent() {
            return new HudStagePrefabXmlReader(
                    getContext().getComponent("WidgetPrefabXmlReader", WidgetPrefabXmlReader.class),
                    getContext().getComponent("StateBarPrefabXmlReader", StateBarPrefabXmlReader.class),
                    getContext().getComponent("MessageBarPrefabXmlReader", MessageBarPrefabXmlReader.class)
            );
        }
    }

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

    @ComponentName("WidgetPrefabXmlReader")
    public static final class WidgetPrefabXmlReaderSupplier extends ComponentSupplier<WidgetPrefabXmlReader> {
        @Override
        public WidgetPrefabXmlReader supplyComponent() {
            return new WidgetPrefabXmlReader(
                    new SubWidgetPrefabXmlReader[] {
                            new PropertyPresenterWidgetPrefabXmlReader(),
                            new TimeLeftPresenterWidgetPrefabXmlReader(),
                            new PointsPresenterWidgetPrefabXmlReader()
                    }
            );
        }
    }

    @ComponentName("WidgetFactory")
    public static final class WidgetFactorySupplier extends ComponentSupplier<WidgetFactory> {
        @Override
        public WidgetFactory supplyComponent() {
            return new WidgetFactory(
                    new SubWidgetFactory[] {
                            new PropertyPresenterWidgetFactory(),
                            new TimeLeftPresenterWidgetFactory(),
                            new PointsPresenterWidgetFactory()
                    }
            );
        }
    }

    @ComponentName("StateBarPrefabXmlReader")
    public static final class StateBarPrefabXmlReaderSupplier extends ComponentSupplier<StateBarPrefabXmlReader> {
        @Override
        public StateBarPrefabXmlReader supplyComponent() {
            return new StateBarPrefabXmlReader();
        }
    }

    @ComponentName("StateBarFactory")
    public static final class StateBarFactorySupplier extends ComponentSupplier<StateBarFactory> {
        @Override
        public StateBarFactory supplyComponent() {
            return new StateBarFactory();
        }
    }

    @ComponentName("MessageBarFactory")
    public static final class MessageBarFactorySupplier extends ComponentSupplier<MessageBarFactory> {
        @Override
        public MessageBarFactory supplyComponent() {
            return new MessageBarFactory(
                    getContext().getComponent("MessagePrinterFactory", MessagePrinterFactory.class),
                    getContext().getComponent("FaceFactory", FaceFactory.class)
            );
        }
    }

    @ComponentName("MessageBarPrefabXmlReader")
    public static final class MessageBarPrefabXmlReaderSupplier extends ComponentSupplier<MessageBarPrefabXmlReader> {
        @Override
        public MessageBarPrefabXmlReader supplyComponent() {
            return new MessageBarPrefabXmlReader(
                    getContext().getComponent("MessagePrinterPrefabXmlReader", MessagePrinterPrefabXmlReader.class),
                    getContext().getComponent("FacePrefabXmlReader", FacePrefabXmlReader.class)
            );
        }
    }

    @ComponentName("MessagePrinterFactory")
    public static final class MessagePrinterFactorySupplier extends ComponentSupplier<MessagePrinterFactory> {
        @Override
        public MessagePrinterFactory supplyComponent() {
            return new MessagePrinterFactory(
                    getContext().getComponent("SoundFactory", SoundFactory.class)
            );
        }
    }

    @ComponentName("MessagePrinterPrefabXmlReader")
    public static final class MessagePrinterPrefabXmlReaderSupplier extends ComponentSupplier<MessagePrinterPrefabXmlReader> {
        @Override
        public MessagePrinterPrefabXmlReader supplyComponent() {
            return new MessagePrinterPrefabXmlReader(
                    getContext().getComponent("SoundPrefabXmlReader", SoundPrefabXmlReader.class)
            );
        }
    }

    @ComponentName("FaceFactory")
    public static final class FaceFactorySupplier extends ComponentSupplier<FaceFactory> {
        @Override
        public FaceFactory supplyComponent() {
            return new FaceFactory(
                    getContext().getComponent("SpriteFactory", SpriteFactory.class)
            );
        }
    }

    @ComponentName("FacePrefabXmlReader")
    public static final class FacePrefabXmlReaderSupplier extends ComponentSupplier<FacePrefabXmlReader> {
        @Override
        public FacePrefabXmlReader supplyComponent() {
            return new FacePrefabXmlReader(
                    getContext().getComponent("SpritePrefabXmlReader", SpritePrefabXmlReader.class)
            );
        }
    }

    @ComponentName("MessageFactory")
    public static final class MessageFactorySupplier extends ComponentSupplier<MessageFactory> {
        @Override
        public MessageFactory supplyComponent() {
            return new MessageFactory();
        }
    }

    @ComponentName("MessagePrefabXmlReader")
    public static final class MessagePrefabXmlReaderSupplier extends ComponentSupplier<MessagePrefabXmlReader> {
        @Override
        public MessagePrefabXmlReader supplyComponent() {
            return new MessagePrefabXmlReader();
        }
    }

    @ComponentName("WeatherFactory")
    public static final class WeatherFactorySupplier extends ComponentSupplier<WeatherFactory> {
        @Override
        public WeatherFactory supplyComponent() {
            return new WeatherFactory(
                    getContext().getComponent("WeatherEffectFactory", WeatherEffectFactory.class)
            );
        }
    }

    @ComponentName("WeatherPrefabXmlReader")
    public static final class WeatherPrefabXmlReaderSupplier extends ComponentSupplier<WeatherPrefabXmlReader> {
        @Override
        public WeatherPrefabXmlReader supplyComponent() {
            return new WeatherPrefabXmlReader(
                    getContext().getComponent("WeatherEffectPrefabXmlReader", WeatherEffectPrefabXmlReader.class)
            );
        }
    }

    @ComponentName("WeatherEffectFactory")
    public static final class WeatherEffectFactorySupplier extends ComponentSupplier<WeatherEffectFactory> {
        @Override
        public WeatherEffectFactory supplyComponent() {
            return new WeatherEffectFactory(
                    new SubWeatherEffectFactory[] {
                            new LightningWeatherEffectFactory(
                                    getContext().getComponent("SoundFactory", SoundFactory.class),
                                    getContext().getComponent("ColorFactory", ColorFactory.class),
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new RainfallWeatherEffectFactory(
                                    getContext().getComponent("ParticleEffectFactory", ParticleEffectFactory.class)
                            )
                    }
            );
        }
    }

    @ComponentName("WeatherEffectPrefabXmlReader")
    public static final class WeatherEffectPrefabXmlReaderSupplier extends ComponentSupplier<WeatherEffectPrefabXmlReader> {
        @Override
        public WeatherEffectPrefabXmlReader supplyComponent() {
            return new WeatherEffectPrefabXmlReader(
                    new SubWeatherEffectPrefabXmlReader[] {
                            new LightningWeatherEffectPrefabXmlReader(
                                    getContext().getComponent("SoundPrefabXmlReader", SoundPrefabXmlReader.class),
                                    getContext().getComponent("ColorPrefabXmlReader", ColorPrefabXmlReader.class)
                            ),
                            new RainfallWeatherEffectPrefabXmlReader(
                                    getContext().getComponent("ParticleEffectPrefabXmlReader", ParticleEffectPrefabXmlReader.class)
                            )
                    }
            );
        }
    }
}
