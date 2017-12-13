package remove.tanks.game.configuration.component.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.audio.sound.SoundFactory;
import remove.tanks.game.audio.sound.SoundPrototypeXmlLoader;
import remove.tanks.game.graphic.color.ColorFactory;
import remove.tanks.game.graphic.color.ColorPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.environment.weather.WeatherFactory;
import remove.tanks.game.level.engine.system.environment.weather.WeatherPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.environment.weather.effect.RegistrableWeatherEffectFactory;
import remove.tanks.game.level.engine.system.environment.weather.effect.RegistrableWeatherEffectPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.environment.weather.effect.WeatherEffectFactory;
import remove.tanks.game.level.engine.system.environment.weather.effect.WeatherEffectPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.environment.weather.effect.lightning.LightningWeatherEffectFactory;
import remove.tanks.game.level.engine.system.environment.weather.effect.lightning.LightningWeatherEffectPrototypeXmlLoader;
import remove.tanks.game.level.engine.utility.direction.AvailableDirectionsXmlLoader;
import remove.tanks.game.level.engine.utility.direction.DirectionXmlLoader;
import remove.tanks.game.level.engine.utility.spawn.entry.SpawnEntryFactory;
import remove.tanks.game.level.engine.utility.spawn.entry.SpawnEntryPrototypeXmlLoader;
import remove.tanks.game.level.engine.utility.spawn.spawner.SpawnerFactory;
import remove.tanks.game.level.engine.utility.spawn.spawner.SpawnerPrototypeXmlLoader;
import remove.tanks.game.utility.position.PositionFactory;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;
import remove.tanks.game.utility.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class EntityUtilitySupplierConfiguration {
    @ComponentName("DirectionXmlLoader")
    public static final class DirectionXmlLoaderSupplier extends ComponentSupplier<DirectionXmlLoader> {
        @Override
        public DirectionXmlLoader supplyComponent() {
            return new DirectionXmlLoader();
        }
    }

    @ComponentName("AvailableDirectionsXmlLoader")
    public static final class AvailableDirectionsXmlLoaderSupplier extends ComponentSupplier<AvailableDirectionsXmlLoader> {
        @Override
        public AvailableDirectionsXmlLoader supplyComponent() {
            return new AvailableDirectionsXmlLoader(
                    getContext().getComponent("DirectionXmlLoader", DirectionXmlLoader.class)
            );
        }
    }

    @ComponentName("SpawnEntryFactory")
    public static final class SpawnEntryFactorySupplier extends ComponentSupplier<SpawnEntryFactory> {
        @Override
        public SpawnEntryFactory supplyComponent() {
            return new SpawnEntryFactory(
                    getContext().getComponent("PositionFactory", PositionFactory.class)
            );
        }
    }

    @ComponentName("SpawnEntryPrototypeXmlLoader")
    public static final class SpawnEntryPrototypeXmlLoaderSupplier extends ComponentSupplier<SpawnEntryPrototypeXmlLoader> {
        @Override
        public SpawnEntryPrototypeXmlLoader supplyComponent() {
            return new SpawnEntryPrototypeXmlLoader(
                    getContext().getComponent("PositionPrototypeXmlLoader", PositionPrototypeXmlLoader.class)
            );
        }
    }

    @ComponentName("SpawnerPrototypeXmlLoader")
    public static final class SpawnerPrototypeXmlLoaderSupplier extends ComponentSupplier<SpawnerPrototypeXmlLoader> {
        @Override
        public SpawnerPrototypeXmlLoader supplyComponent() {
            return new SpawnerPrototypeXmlLoader();
        }
    }

    @ComponentName("SpawnerFactory")
    public static final class SpawnerFactorySupplier extends ComponentSupplier<SpawnerFactory> {
        @Override
        public SpawnerFactory supplyComponent() {
            return new SpawnerFactory();
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

    @ComponentName("WeatherEffectFactory")
    public static final class WeatherEffectFactorySupplier extends ComponentSupplier<WeatherEffectFactory> {
        @Override
        public WeatherEffectFactory supplyComponent() {
            return new WeatherEffectFactory(
                    new RegistrableWeatherEffectFactory[] {
                            new LightningWeatherEffectFactory(
                                    getContext().getComponent("SoundFactory", SoundFactory.class),
                                    getContext().getComponent("ColorFactory", ColorFactory.class),
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            )
                    }
            );
        }
    }

    @ComponentName("WeatherPrototypeXmlLoader")
    public static final class WeatherPrototypeXmlLoaderSupplier extends ComponentSupplier<WeatherPrototypeXmlLoader> {
        @Override
        public WeatherPrototypeXmlLoader supplyComponent() {
            return new WeatherPrototypeXmlLoader(
                    getContext().getComponent("WeatherEffectPrototypeXmlLoader", WeatherEffectPrototypeXmlLoader.class)
            );
        }
    }

    @ComponentName("WeatherEffectPrototypeXmlLoader")
    public static final class WeatherEffectPrototypeXmlLoaderSupplier extends ComponentSupplier<WeatherEffectPrototypeXmlLoader> {
        @Override
        public WeatherEffectPrototypeXmlLoader supplyComponent() {
            return new WeatherEffectPrototypeXmlLoader(
                    new RegistrableWeatherEffectPrototypeXmlLoader[] {
                            new LightningWeatherEffectPrototypeXmlLoader(
                                    getContext().getComponent("SoundPrototypeXmlLoader", SoundPrototypeXmlLoader.class),
                                    getContext().getComponent("ColorPrototypeXmlLoader", ColorPrototypeXmlLoader.class)
                            )
                    }
            );
        }
    }
}
