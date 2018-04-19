package remove.tanks.game.configuration.component.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.audio.music.MusicFactory;
import remove.tanks.game.audio.music.MusicPrefabXmlReader;
import remove.tanks.game.graphics.effect.EffectFactory;
import remove.tanks.game.graphics.effect.EffectPrefabXmlReader;
import remove.tanks.game.graphics.view.renderer.ViewRenderer;
import remove.tanks.game.graphics.view.updater.ViewUpdater;
import remove.tanks.game.level.engine.entity.EntityPrefabCodeXmlReader;
import remove.tanks.game.level.engine.system.EntitySystemFactory;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.airplane.AirplaneControlSystemFactory;
import remove.tanks.game.level.engine.system.airplane.AirplaneControlSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.artillery.ArtilleryControlSystemFactory;
import remove.tanks.game.level.engine.system.artillery.ArtilleryControlSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.behavior.ChangeBehaviorSystemFactory;
import remove.tanks.game.level.engine.system.behavior.ChangeBehaviorSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.camera.*;
import remove.tanks.game.level.engine.system.cloud.CloudControlSystemFactory;
import remove.tanks.game.level.engine.system.cloud.CloudControlSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.combat.*;
import remove.tanks.game.level.engine.system.direction.RandomDirectionSystemFactory;
import remove.tanks.game.level.engine.system.direction.RandomDirectionSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.hud.HudSystemFactory;
import remove.tanks.game.level.engine.system.hud.HudSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.input.InputSystemFactory;
import remove.tanks.game.level.engine.system.input.InputSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.lifecycle.*;
import remove.tanks.game.level.engine.system.move.AutoMoveSystemFactory;
import remove.tanks.game.level.engine.system.move.AutoMoveSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.music.MusicOnStartSystemFactory;
import remove.tanks.game.level.engine.system.music.MusicOnStartSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.render.map.FogOfWarMapLayerRenderSystemFactory;
import remove.tanks.game.level.engine.system.render.map.FogOfWarMapLayerRenderSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.render.map.GroundMapLayerRenderSystemFactory;
import remove.tanks.game.level.engine.system.render.map.GroundMapLayerRenderSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.render.view.*;
import remove.tanks.game.level.engine.system.spawn.AutoSpawnerSystemFactory;
import remove.tanks.game.level.engine.system.spawn.AutoSpawnerSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.spawn.RespawnSystemFactory;
import remove.tanks.game.level.engine.system.spawn.RespawnSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.state.defeat.NoLifesDefeatSystemFactory;
import remove.tanks.game.level.engine.system.state.defeat.NoLifesDefeatSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.state.defeat.TimeEndDefeatSystemFactory;
import remove.tanks.game.level.engine.system.state.defeat.TimeEndDefeatSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.state.end.LevelEndSystemFactory;
import remove.tanks.game.level.engine.system.state.end.LevelEndSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.state.reset.PlayerDestroyedResetSystemFactory;
import remove.tanks.game.level.engine.system.state.reset.PlayerDestroyedResetSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.state.victory.NoEnemiesVictorySystemFactory;
import remove.tanks.game.level.engine.system.state.victory.NoEnemiesVictorySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.time.TimeUpdateSystemFactory;
import remove.tanks.game.level.engine.system.time.TimeUpdateSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.time.TimelineSystemFactory;
import remove.tanks.game.level.engine.system.time.TimelineSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.weather.WeatherSystemFactory;
import remove.tanks.game.level.engine.system.weather.WeatherSystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.world.*;
import remove.tanks.game.level.utility.spawner.SpawnerFactory;
import remove.tanks.game.level.utility.spawner.SpawnerPrefabXmlReader;
import remove.tanks.game.level.utility.stage.HudStageFactory;
import remove.tanks.game.level.utility.stage.HudStagePrefabXmlReader;
import remove.tanks.game.level.utility.timeline.TimelineFactory;
import remove.tanks.game.level.utility.timeline.TimelinePrefabXmlReader;
import remove.tanks.game.level.utility.weather.WeatherFactory;
import remove.tanks.game.level.utility.weather.WeatherPrefabXmlReader;
import remove.tanks.game.physics.light.world.renderer.WorldLightRenderer;
import remove.tanks.game.physics.world.renderer.WorldRenderer;
import remove.tanks.game.physics.world.updater.WorldUpdater;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class EntitySystemConfiguration {
    @ComponentName("EntitySystemFactory")
    public static final class EntitySystemFactorySupplier extends ComponentSupplier<EntitySystemFactory> {
        @Override
        public EntitySystemFactory supplyComponent() {
            return new EntitySystemFactory(
                    new SubEntitySystemFactory[] {
                            new CameraTrackSystemFactory(),
                            new CameraUpdateSystemFactory(),
                            new CameraEffectSystemFactory(),
                            new WorldLightRenderSystemFactory(
                                    getContext().getComponent("WorldLightRenderer", WorldLightRenderer.class)
                            ),
                            new WorldUpdateSystemFactory(
                                    getContext().getComponent("WorldUpdater", WorldUpdater.class)
                            ),
                            new WorldDebugRenderSystemFactory(
                                    getContext().getComponent("WorldRenderer", WorldRenderer.class)
                            ),
                            new GroundMapLayerRenderSystemFactory(),
                            new FogOfWarMapLayerRenderSystemFactory(),
                            new ViewUpdateSystemFactory(
                                    getContext().getComponent("ViewUpdater", ViewUpdater.class)
                            ),
                            new GroundLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new BulletLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new VehicleLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new ObstacleLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new ExplosionLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new BonusLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new CloudLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new BombLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new AirplaneLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new InputSystemFactory(),
                            new AutoMoveSystemFactory(),
                            new DestroySystemFactory(),
                            new LifetimeSystemFactory(),
                            new RandomDirectionSystemFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new HealthSystemFactory(),
                            new CombatSystemFactory(
                                    getContext().getComponent("EffectFactory", EffectFactory.class)
                            ),
                            new HitSystemFactory(),
                            new DestroyOnContactSystemFactory(),
                            new HudSystemFactory(
                                    getContext().getComponent("HudStageFactory", HudStageFactory.class)
                            ),
                            new WeatherSystemFactory(
                                    getContext().getComponent("WeatherFactory", WeatherFactory.class)
                            ),
                            new AutoShootSystemFactory(),
                            new RandomShootSystemFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new DestroyOnContactLostSystemFactory(),
                            new ChangeBehaviorSystemFactory(),
                            new RandomCreateSystemFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new RespawnSystemFactory(),
                            new NoEnemiesVictorySystemFactory(),
                            new LevelEndSystemFactory(),
                            new NoLifesDefeatSystemFactory(),
                            new TimeEndDefeatSystemFactory(),
                            new TimeUpdateSystemFactory(),
                            new TimelineSystemFactory(
                                    getContext().getComponent("TimelineFactory", TimelineFactory.class)
                            ),
                            new MusicOnStartSystemFactory(
                                    getContext().getComponent("MusicFactory", MusicFactory.class)
                            ),
                            new AutoSpawnerSystemFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class),
                                    getContext().getComponent("SpawnerFactory", SpawnerFactory.class)
                            ),
                            new PlayerDestroyedResetSystemFactory(),
                            new AirplaneControlSystemFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new CloudControlSystemFactory(),
                            new ArtilleryControlSystemFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            )
                    }
            );
        }
    }

    @ComponentName("EntitySystemPrefabXmlReader")
    public static final class EntitySystemPrefabXmlReaderSupplier extends ComponentSupplier<EntitySystemPrefabXmlReader> {
        @Override
        public EntitySystemPrefabXmlReader supplyComponent() {
            return new EntitySystemPrefabXmlReader(
                    new SubEntitySystemPrefabXmlReader[] {
                            new CameraTrackSystemPrefabXmlReader(),
                            new CameraUpdateSystemPrefabXmlReader(),
                            new CameraEffectSystemPrefabXmlReader(),
                            new WorldLightRenderSystemPrefabXmlReader(),
                            new WorldUpdateSystemPrefabXmlReader(),
                            new WorldDebugRenderSystemPrefabXmlReader(),
                            new GroundMapLayerRenderSystemPrefabXmlReader(),
                            new FogOfWarMapLayerRenderSystemPrefabXmlReader(),
                            new ViewUpdateSystemPrefabXmlReader(),
                            new GroundLayerRenderSystemPrefabXmlReader(),
                            new BulletLayerRenderSystemPrefabXmlReader(),
                            new VehicleLayerRenderSystemPrefabXmlReader(),
                            new ObstacleLayerRenderSystemPrefabXmlReader(),
                            new ExplosionLayerRenderSystemPrefabXmlReader(),
                            new BonusLayerRenderSystemPrefabXmlReader(),
                            new CloudLayerRenderSystemPrefabXmlReader(),
                            new BombLayerRenderSystemPrefabXmlReader(),
                            new AirplaneLayerRenderSystemPrefabXmlReader(),
                            new InputSystemPrefabXmlReader(),
                            new AutoMoveSystemPrefabXmlReader(),
                            new DestroySystemPrefabXmlReader(),
                            new LifetimeSystemPrefabXmlReader(),
                            new RandomDirectionSystemPrefabXmlReader(),
                            new HealthSystemPrefabXmlReader(),
                            new CombatSystemPrefabXmlReader(
                                    getContext().getComponent("EffectPrefabXmlReader", EffectPrefabXmlReader.class)
                            ),
                            new HitSystemPrefabXmlReader(),
                            new DestroyOnContactSystemPrefabXmlReader(),
                            new HudSystemPrefabXmlReader(
                                    getContext().getComponent("HudStagePrefabXmlReader", HudStagePrefabXmlReader.class)
                            ),
                            new WeatherSystemPrefabXmlReader(
                                    getContext().getComponent("WeatherPrefabXmlReader", WeatherPrefabXmlReader.class)
                            ),
                            new AutoShootSystemPrefabXmlReader(),
                            new RandomShootSystemPrefabXmlReader(),
                            new DestroyOnContactLostSystemPrefabXmlReader(),
                            new ChangeBehaviorSystemPrefabXmlReader(),
                            new RandomCreateSystemPrefabXmlReader(),
                            new RespawnSystemPrefabXmlReader(
                                    getContext().getComponent("EntityPrefabCodeXmlReader", EntityPrefabCodeXmlReader.class)
                            ),
                            new NoEnemiesVictorySystemPrefabXmlReader(),
                            new LevelEndSystemPrefabXmlReader(),
                            new NoLifesDefeatSystemPrefabXmlReader(),
                            new TimeEndDefeatSystemPrefabXmlReader(),
                            new TimeUpdateSystemPrefabXmlReader(),
                            new TimelineSystemPrefabXmlReader(
                                    getContext().getComponent("TimelinePrefabXmlReader", TimelinePrefabXmlReader.class)
                            ),
                            new MusicOnStartSystemPrefabXmlReader(
                                    getContext().getComponent("MusicPrefabXmlReader", MusicPrefabXmlReader.class)
                            ),
                            new AutoSpawnerSystemPrefabXmlReader(
                                    getContext().getComponent("SpawnerPrefabXmlReader", SpawnerPrefabXmlReader.class)
                            ),
                            new PlayerDestroyedResetSystemPrefabXmlReader(),
                            new AirplaneControlSystemPrefabXmlReader(),
                            new CloudControlSystemPrefabXmlReader(),
                            new ArtilleryControlSystemPrefabXmlReader(
                                    getContext().getComponent("EntityPrefabCodeXmlReader", EntityPrefabCodeXmlReader.class)
                            )
                    }
            );
        }
    }
}
