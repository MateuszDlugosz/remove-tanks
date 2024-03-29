package remove.tanks.game.configuration.component.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.audio.music.MusicFactory;
import remove.tanks.game.audio.music.MusicPrefabXmlReader;
import remove.tanks.game.audio.sound.SoundFactory;
import remove.tanks.game.audio.sound.SoundPrefabXmlReader;
import remove.tanks.game.graphics.camera.effect.CameraEffectFactory;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefabXmlReader;
import remove.tanks.game.level.event.*;
import remove.tanks.game.level.event.airplane.SpawnAirplaneEventExecutor;
import remove.tanks.game.level.event.airplane.SpawnAirplaneEventFactory;
import remove.tanks.game.level.event.airplane.SpawnAirplaneEventPrefabXmlReader;
import remove.tanks.game.level.event.ammo.AmmoLevelUpEventExecutor;
import remove.tanks.game.level.event.ammo.AmmoLevelUpEventFactory;
import remove.tanks.game.level.event.ammo.AmmoLevelUpEventPrefabXmlReader;
import remove.tanks.game.level.event.artillery.ArtilleryShootEventExecutor;
import remove.tanks.game.level.event.artillery.ArtilleryShootEventFactory;
import remove.tanks.game.level.event.artillery.ArtilleryShootEventPrefabXmlReader;
import remove.tanks.game.level.event.camera.AddCameraEffectEventExecutor;
import remove.tanks.game.level.event.camera.AddCameraEffectEventFactory;
import remove.tanks.game.level.event.camera.AddCameraEffectEventPrefabXmlReader;
import remove.tanks.game.level.event.create.*;
import remove.tanks.game.level.event.destroy.*;
import remove.tanks.game.level.event.entity.airplane.SpawnAirplaneEntityEventExecutor;
import remove.tanks.game.level.event.entity.airplane.SpawnAirplaneEntityEventFactory;
import remove.tanks.game.level.event.entity.airplane.SpawnAirplaneEntityEventPrefabXmlReader;
import remove.tanks.game.level.event.entity.ammo.AmmoLevelUpEntityEventExecutor;
import remove.tanks.game.level.event.entity.ammo.AmmoLevelUpEntityEventFactory;
import remove.tanks.game.level.event.entity.ammo.AmmoLevelUpEntityEventPrefabXmlReader;
import remove.tanks.game.level.event.entity.artillery.ArtilleryShootEntityEventExecutor;
import remove.tanks.game.level.event.entity.artillery.ArtilleryShootEntityEventFactory;
import remove.tanks.game.level.event.entity.artillery.ArtilleryShootEntityEventPrefabXmlReader;
import remove.tanks.game.level.event.entity.camera.AddCameraEffectEntityEventExecutor;
import remove.tanks.game.level.event.entity.camera.AddCameraEffectEntityEventFactory;
import remove.tanks.game.level.event.entity.camera.AddCameraEffectEntityEventPrefabXmlReader;
import remove.tanks.game.level.event.entity.create.*;
import remove.tanks.game.level.event.entity.destroy.*;
import remove.tanks.game.level.event.entity.life.*;
import remove.tanks.game.level.event.entity.message.AddMessageEntityEventExecutor;
import remove.tanks.game.level.event.entity.message.AddMessageEntityEventFactory;
import remove.tanks.game.level.event.entity.message.AddMessageEntityEventPrefabXmlReader;
import remove.tanks.game.level.event.entity.music.PlayMusicEntityEventExecutor;
import remove.tanks.game.level.event.entity.music.PlayMusicEntityEventFactory;
import remove.tanks.game.level.event.entity.music.PlayMusicEntityEventPrefabXmlReader;
import remove.tanks.game.level.event.entity.points.*;
import remove.tanks.game.level.event.entity.sound.PlaySoundEntityEventExecutor;
import remove.tanks.game.level.event.entity.sound.PlaySoundEntityEventFactory;
import remove.tanks.game.level.event.entity.sound.PlaySoundEntityEventPrefabXmlReader;
import remove.tanks.game.level.event.entity.spawner.ActivateSpawnerEntityEventExecutor;
import remove.tanks.game.level.event.entity.spawner.ActivateSpawnerEntityEventFactory;
import remove.tanks.game.level.event.entity.spawner.ActivateSpawnerEntityEventPrefabXmlReader;
import remove.tanks.game.level.event.entity.state.ChangeLevelStateEntityEventExecutor;
import remove.tanks.game.level.event.entity.state.ChangeLevelStateEntityEventFactory;
import remove.tanks.game.level.event.entity.state.ChangeLevelStateEntityEventPrefabXmlReader;
import remove.tanks.game.level.event.entity.system.*;
import remove.tanks.game.level.event.entity.weather.*;
import remove.tanks.game.level.event.life.AddLifeEventExecutor;
import remove.tanks.game.level.event.life.AddLifeEventFactory;
import remove.tanks.game.level.event.life.AddLifeEventPrefabXmlReader;
import remove.tanks.game.level.event.life.RemoveLifeEventExecutor;
import remove.tanks.game.level.event.message.*;
import remove.tanks.game.level.event.music.PlayMusicEventExecutor;
import remove.tanks.game.level.event.music.PlayMusicEventFactory;
import remove.tanks.game.level.event.music.PlayMusicEventPrefabXmlReader;
import remove.tanks.game.level.event.points.*;
import remove.tanks.game.level.event.sound.PlaySoundEvenFactory;
import remove.tanks.game.level.event.sound.PlaySoundEventExecutor;
import remove.tanks.game.level.event.sound.PlaySoundEventPrefabXmlReader;
import remove.tanks.game.level.event.spawner.ActivateSpawnerEventFactory;
import remove.tanks.game.level.event.spawner.ActivateSpawnerEventPrefabXmlReader;
import remove.tanks.game.level.event.state.ChangeLevelStateEventExecutor;
import remove.tanks.game.level.event.state.ChangeLevelStateEventFactory;
import remove.tanks.game.level.event.state.ChangeLevelStateEventPrefabXmlReader;
import remove.tanks.game.level.event.system.*;
import remove.tanks.game.level.event.weather.*;
import remove.tanks.game.level.utility.create.CreateEntryFactory;
import remove.tanks.game.level.utility.create.CreateEntryPrefabXmlReader;
import remove.tanks.game.level.utility.stage.broker.message.MessageFactory;
import remove.tanks.game.level.utility.stage.broker.message.MessagePrefabXmlReader;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectFactory;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefabXmlReader;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class EventConfiguration {
    @ComponentName("EventExecutor")
    public static final class LevelEventExecutorSupplier extends ComponentSupplier<EventExecutor> {
        @Override
        public EventExecutor supplyComponent() {
            return new EventExecutor(
                    new SubEventExecutor[] {
                            new ActivateSystemEventExecutor(),
                            new ActivateSystemEntityEventExecutor(),
                            new DeactivateSystemEventExecutor(),
                            new DeactivateSystemEntityEventExecutor(),
                            new PlaySoundEventExecutor(),
                            new PlaySoundEntityEventExecutor(),
                            new PlayMusicEventExecutor(),
                            new PlayMusicEntityEventExecutor(),
                            new AddCameraEffectEventExecutor(),
                            new AddCameraEffectEntityEventExecutor(),
                            new AddPointsEntityEventExecutor(),
                            new AddPointsEventExecutor(),
                            new CreateEventExecutor(),
                            new CreateEntityEventExecutor(),
                            new DestroyEntityEventExecutor(),
                            new DestroyEntityByIdEventExecutor(),
                            new DestroyEntityByIdEntityEventExecutor(),
                            new DestroyFamilyEventExecutor(),
                            new DestroyFamilyEntityEventExecutor(),
                            new AddLifeEntityEventExecutor(),
                            new AddLifeEventExecutor(),
                            new RemoveLifeEventExecutor(),
                            new RemoveLifeEntityEventExecutor(),
                            new IncreasePointsMultiplierEventExecutor(),
                            new IncreasePointsMultiplierEntityEventExecutor(),
                            new AmmoLevelUpEntityEventExecutor(),
                            new AmmoLevelUpEventExecutor(),
                            new SpawnAirplaneEntityEventExecutor(),
                            new SpawnAirplaneEventExecutor(),
                            new ChangeLevelStateEntityEventExecutor(),
                            new ChangeLevelStateEventExecutor(),
                            new AddMessageEntityEventExecutor(),
                            new AddMessageEventExecutor(),
                            new ActivateSystemEventExecutor(),
                            new ActivateSpawnerEntityEventExecutor(),
                            new ResetPointsMultiplierEventExecutor(),
                            new ResetPointsMultiplierEntityEventExecutor(),
                            new ClearMessagesEventExecutor(),
                            new AddWeatherEffectEventExecutor(),
                            new AddWeatherEffectEntityEventExecutor(),
                            new ClearWeatherEffectsEventExecutor(),
                            new ClearWeatherEffectsEntityEventExecutor(),
                            new RemoveWeatherEffectEntityEventExecutor(),
                            new RemoveWeatherEffectEventExecutor(),
                            new RandomCreateEventExecutor(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new RandomCreateEntityEventExecutor(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new ArtilleryShootEntityEventExecutor(),
                            new ArtilleryShootEventExecutor()
                    }
            );
        }
    }

    @ComponentName("EventPrefabXmlReader")
    public static final class EventPrefabXmlReaderSupplier extends ComponentSupplier<EventPrefabXmlReader> {
        @Override
        public EventPrefabXmlReader supplyComponent() {
            return new EventPrefabXmlReader(
                    new SubEventPrefabXmlReader[] {
                            new ActivateSystemEventPrefabXmlReader(),
                            new DeactivateSystemEventPrefabXmlReader(),
                            new DestroyEntityByIdEventPrefabXmlReader(),
                            new CreateEventPrefabXmlReader(
                                    getContext().getComponent("CreateEntryPrefabXmlReader", CreateEntryPrefabXmlReader.class)
                            ),
                            new PlaySoundEventPrefabXmlReader(
                                    getContext().getComponent("SoundPrefabXmlReader", SoundPrefabXmlReader.class)
                            ),
                            new PlayMusicEventPrefabXmlReader(
                                    getContext().getComponent("MusicPrefabXmlReader", MusicPrefabXmlReader.class)
                            ),
                            new DestroyFamilyEventPrefabXmlReader(),
                            new AddPointsEventPrefabXmlReader(),
                            new AddCameraEffectEventPrefabXmlReader(
                                    getContext().getComponent("CameraEffectPrefabXmlReader", CameraEffectPrefabXmlReader.class)
                            ),
                            new AddLifeEventPrefabXmlReader(),
                            new IncreasePointsMultiplierEventPrefabXmlReader(),
                            new AmmoLevelUpEventPrefabXmlReader(),
                            new SpawnAirplaneEventPrefabXmlReader(),
                            new ChangeLevelStateEventPrefabXmlReader(),
                            new AddMessageEventPrefabXmlReader(
                                    getContext().getComponent("MessagePrefabXmlReader", MessagePrefabXmlReader.class)
                            ),
                            new ActivateSpawnerEventPrefabXmlReader(),
                            new ResetPointsMultiplierEventPrefabXmlReader(),
                            new ClearMessagesEventPrefabXmlReader(),
                            new AddWeatherEffectEventPrefabXmlReader(
                                    getContext().getComponent("WeatherEffectPrefabXmlReader", WeatherEffectPrefabXmlReader.class)
                            ),
                            new ClearWeatherEffectsEventPrefabXmlReader(),
                            new RandomCreateEventPrefabXmlReader(
                                    getContext().getComponent("CreateEntryPrefabXmlReader", CreateEntryPrefabXmlReader.class)
                            ),
                            new RemoveWeatherEffectEventPrefabXmlReader(),
                            new ArtilleryShootEventPrefabXmlReader()
                    }
            );
        }
    }

    @ComponentName("EventFactory")
    public static final class EventFactorySupplier extends ComponentSupplier<EventFactory> {
        @Override
        public EventFactory supplyComponent() {
            return new EventFactory(
                    new SubEventFactory[] {
                            new ActivateSystemEventFactory(),
                            new DeactivateSystemEventFactory(),
                            new DestroyEntityByIdEventFactory(),
                            new CreateEventFactory(
                                    getContext().getComponent("CreateEntryFactory", CreateEntryFactory.class)
                            ),
                            new PlaySoundEvenFactory(
                                    getContext().getComponent("SoundFactory", SoundFactory.class)
                            ),
                            new PlayMusicEventFactory(
                                    getContext().getComponent("MusicFactory", MusicFactory.class)
                            ),
                            new DestroyFamilyEventFactory(),
                            new AddPointsEventFactory(),
                            new AddCameraEffectEventFactory(
                                    getContext().getComponent("CameraEffectFactory", CameraEffectFactory.class)
                            ),
                            new AddLifeEventFactory(),
                            new IncreasePointsMultiplierEventFactory(),
                            new AmmoLevelUpEventFactory(),
                            new SpawnAirplaneEventFactory(),
                            new ChangeLevelStateEventFactory(),
                            new AddMessageEventFactory(
                                    getContext().getComponent("MessageFactory", MessageFactory.class)
                            ),
                            new ActivateSpawnerEventFactory(),
                            new ResetPointsMultiplierEventFactory(),
                            new ClearMessagesEventFactory(),
                            new AddWeatherEffectEventFactory(
                                    getContext().getComponent("WeatherEffectFactory", WeatherEffectFactory.class)
                            ),
                            new ClearWeatherEffectsEventFactory(),
                            new RandomCreateEventFactory(
                                    getContext().getComponent("CreateEntryFactory", CreateEntryFactory.class)
                            ),
                            new RemoveWeatherEffectEventFactory(),
                            new ArtilleryShootEventFactory()
                    }
            );
        }
    }

    @ComponentName("EntityEventPrefabXmlReader")
    public static final class EntityEventPrefabXmlReaderSupplier extends ComponentSupplier<EntityEventPrefabXmlReader> {
        @Override
        public EntityEventPrefabXmlReader supplyComponent() {
            return new EntityEventPrefabXmlReader(
                    new SubEntityEventPrefabXmlReader[] {
                            new PlaySoundEntityEventPrefabXmlReader(
                                    getContext().getComponent("SoundPrefabXmlReader", SoundPrefabXmlReader.class)
                            ),
                            new PlayMusicEntityEventPrefabXmlReader(
                                    getContext().getComponent("MusicPrefabXmlReader", MusicPrefabXmlReader.class)
                            ),
                            new CreateEntityEventPrefabXmlReader(
                                    getContext().getComponent("CreateEntryPrefabXmlReader", CreateEntryPrefabXmlReader.class)
                            ),
                            new DestroyEntityEventPrefabXmlReader(),
                            new AddCameraEffectEntityEventPrefabXmlReader(
                                    getContext().getComponent("CameraEffectPrefabXmlReader", CameraEffectPrefabXmlReader.class)
                            ),
                            new AddPointsEntityEventPrefabXmlReader(),
                            new DestroyEntityByIdEntityEventPrefabXmlReader(),
                            new DestroyFamilyEntityEventPrefabXmlReader(),
                            new AddLifeEntityEventPrefabXmlReader(),
                            new IncreasePointsMultiplierEntityEventPrefabXmlReader(),
                            new AmmoLevelUpEntityEventPrefabXmlReader(),
                            new SpawnAirplaneEntityEventPrefabXmlReader(),
                            new ChangeLevelStateEntityEventPrefabXmlReader(),
                            new AddMessageEntityEventPrefabXmlReader(
                                    getContext().getComponent("MessagePrefabXmlReader", MessagePrefabXmlReader.class)
                            ),
                            new ActivateSpawnerEntityEventPrefabXmlReader(),
                            new RandomCreateEntityEventPrefabXmlReader(
                                    getContext().getComponent("CreateEntryPrefabXmlReader", CreateEntryPrefabXmlReader.class)
                            ),
                            new RemoveLifeEntityEventPrefabXmlReader(),
                            new ResetPointsMultiplierEntityEventPrefabXmlReader(),
                            new ActivateSystemEntityEventPrefabXmlReader(),
                            new DeactivateSystemEntityEventPrefabXmlReader(),
                            new AddWeatherEffectEntityEventPrefabXmlReader(
                                    getContext().getComponent("WeatherEffectPrefabXmlReader", WeatherEffectPrefabXmlReader.class)
                            ),
                            new RandomCreateEntityEventPrefabXmlReader(
                                    getContext().getComponent("CreateEntryPrefabXmlReader", CreateEntryPrefabXmlReader.class)
                            ),
                            new RemoveWeatherEffectEntityEventPrefabXmlReader(),
                            new ClearWeatherEffectsEntityEventPrefabXmlReader(),
                            new ArtilleryShootEntityEventPrefabXmlReader()
                    }
            );
        }
    }

    @ComponentName("EntityEventFactory")
    public static final class EntityEventFactorySupplier extends ComponentSupplier<EntityEventFactory> {
        @Override
        public EntityEventFactory supplyComponent() {
            return new EntityEventFactory(
                    new SubEntityEventFactory[] {
                            new PlaySoundEntityEventFactory(
                                    getContext().getComponent("SoundFactory", SoundFactory.class)
                            ),
                            new PlayMusicEntityEventFactory(
                                    getContext().getComponent("MusicFactory", MusicFactory.class)
                            ),
                            new CreateEntityEventFactory(
                                    getContext().getComponent("CreateEntryFactory", CreateEntryFactory.class)
                            ),
                            new DestroyEntityEventFactory(),
                            new AddCameraEffectEntityEventFactory(
                                    getContext().getComponent("CameraEffectFactory", CameraEffectFactory.class)
                            ),
                            new AddPointsEntityEventFactory(),
                            new DestroyEntityByIdEntityEventFactory(),
                            new DestroyFamilyEntityEventFactory(),
                            new AddLifeEntityEventFactory(),
                            new IncreasePointsMultiplierEntityEventFactory(),
                            new AmmoLevelUpEntityEventFactory(),
                            new SpawnAirplaneEntityEventFactory(),
                            new ChangeLevelStateEntityEventFactory(),
                            new AddMessageEntityEventFactory(
                                    getContext().getComponent("MessageFactory", MessageFactory.class)
                            ),
                            new ActivateSpawnerEntityEventFactory(),
                            new RandomCreateEntityEventFactory(
                                    getContext().getComponent("CreateEntryFactory", CreateEntryFactory.class)
                            ),
                            new RemoveLifeEntityEventFactory(),
                            new ResetPointsMultiplierEntityEventFactory(),
                            new ActivateSystemEntityEventFactory(),
                            new DeactivateSystemEntityEventFactory(),
                            new AddWeatherEffectEntityEventFactory(
                                    getContext().getComponent("WeatherEffectFactory", WeatherEffectFactory.class)
                            ),
                            new RandomCreateEntityEventFactory(
                                    getContext().getComponent("CreateEntryFactory", CreateEntryFactory.class)
                            ),
                            new ClearWeatherEffectsEntityEventFactory(),
                            new RemoveWeatherEffectEntityEventFactory(),
                            new ArtilleryShootEntityEventFactory()
                    }
            );
        }
    }
}
