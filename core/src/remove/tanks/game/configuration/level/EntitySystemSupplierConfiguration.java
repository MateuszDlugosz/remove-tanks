package remove.tanks.game.configuration.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.audio.music.MusicFactory;
import remove.tanks.game.audio.music.MusicPrototypeXmlLoader;
import remove.tanks.game.graphic.view.renderer.ViewRenderer;
import remove.tanks.game.graphic.view.updater.ViewUpdater;
import remove.tanks.game.level.engine.system.EntitySystemFactory;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.audio.MusicOnStartSystemFactory;
import remove.tanks.game.level.engine.system.audio.MusicOnStartSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.behavior.ChangeBehaviorSystemFactory;
import remove.tanks.game.level.engine.system.behavior.ChangeBehaviorSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.camera.*;
import remove.tanks.game.level.engine.system.control.PlayerControlSystemFactory;
import remove.tanks.game.level.engine.system.control.PlayerControlSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.damage.DamageSystemFactory;
import remove.tanks.game.level.engine.system.damage.DamageSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.destroy.DestroyOnContactSystemFactory;
import remove.tanks.game.level.engine.system.destroy.DestroyOnContactSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.destroy.DestroySystemFactory;
import remove.tanks.game.level.engine.system.destroy.DestroySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.direction.RandomDirectionSystemFactory;
import remove.tanks.game.level.engine.system.direction.RandomDirectionSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.environment.WeatherSystemFactory;
import remove.tanks.game.level.engine.system.environment.WeatherSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.environment.weather.WeatherFactory;
import remove.tanks.game.level.engine.system.environment.weather.WeatherPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.health.HealthSystemFactory;
import remove.tanks.game.level.engine.system.health.HealthSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.hud.HudRenderSystemFactory;
import remove.tanks.game.level.engine.system.hud.HudRenderSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.hud.stages.HudStageFactory;
import remove.tanks.game.level.engine.system.hud.stages.HudStagePrototypeXmlLoader;
import remove.tanks.game.level.engine.system.layer.*;
import remove.tanks.game.level.engine.system.lifetime.LifetimeSystemFactory;
import remove.tanks.game.level.engine.system.lifetime.LifetimeSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.map.TiledMapRenderSystemFactory;
import remove.tanks.game.level.engine.system.map.TiledMapRenderSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.move.AutoMoveSystemFactory;
import remove.tanks.game.level.engine.system.move.AutoMoveSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.respawn.PlayerRespawnSystemFactory;
import remove.tanks.game.level.engine.system.respawn.PlayerRespawnSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.shoot.AutoShootSystemFactory;
import remove.tanks.game.level.engine.system.shoot.AutoShootSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.shoot.RandomShootSystemFactory;
import remove.tanks.game.level.engine.system.shoot.RandomShootSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.spawn.AutoSpawnerSystemFactory;
import remove.tanks.game.level.engine.system.spawn.AutoSpawnerSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.spawn.RandomSpawnSystemFactory;
import remove.tanks.game.level.engine.system.spawn.RandomSpawnSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.state.defeat.NoLifesDefeatSystemFactory;
import remove.tanks.game.level.engine.system.state.defeat.NoLifesDefeatSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.state.end.LevelEndSystemFactory;
import remove.tanks.game.level.engine.system.state.end.LevelEndSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.state.victory.NoEnemiesVictorySystemFactory;
import remove.tanks.game.level.engine.system.state.victory.NoEnemiesVictorySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.view.ViewUpdateSystemFactory;
import remove.tanks.game.level.engine.system.view.ViewUpdateSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.world.*;
import remove.tanks.game.level.engine.utility.spawn.spawner.SpawnerFactory;
import remove.tanks.game.level.engine.utility.spawn.spawner.SpawnerPrototypeXmlLoader;
import remove.tanks.game.physics.light.world.renderer.WorldLightRenderer;
import remove.tanks.game.physics.world.renderer.WorldRenderer;
import remove.tanks.game.physics.world.updater.WorldUpdater;
import remove.tanks.game.utility.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class EntitySystemSupplierConfiguration {
    @ComponentName("EntitySystemFactory")
    public static final class EntitySystemFactorySupplier extends ComponentSupplier<EntitySystemFactory> {
        @Override
        public EntitySystemFactory supplyComponent() {
            return new EntitySystemFactory(
                    new RegistrableEntitySystemFactory[] {
                            new WorldDebugRenderSystemFactory(
                                    getContext().getComponent("WorldRenderer", WorldRenderer.class)
                            ),
                            new WorldUpdateSystemFactory(
                                    getContext().getComponent("WorldUpdater", WorldUpdater.class)
                            ),
                            new WorldLightRenderSystemFactory(
                                    getContext().getComponent("WorldLightRenderer", WorldLightRenderer.class)
                            ),
                            new CameraTrackSystemFactory(),
                            new CameraUpdateSystemFactory(),
                            new DamageSystemFactory(),
                            new DestroyOnContactSystemFactory(),
                            new DestroySystemFactory(),
                            new RandomDirectionSystemFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new HealthSystemFactory(),
                            new HudRenderSystemFactory(
                                    getContext().getComponent("HudStageFactory", HudStageFactory.class)
                            ),
                            new PlayerControlSystemFactory(),
                            new LifetimeSystemFactory(),
                            new TiledMapRenderSystemFactory(),
                            new AutoMoveSystemFactory(),
                            new ViewUpdateSystemFactory(
                                    getContext().getComponent("ViewUpdater", ViewUpdater.class)
                            ),
                            new AutoShootSystemFactory(),
                            new RandomShootSystemFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new BomberLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new BombLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new BonusLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new BulletLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new CloudLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new ExplosionLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new GroundLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new ObstacleLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new VehicleLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class)
                            ),
                            new RandomSpawnSystemFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new AutoSpawnerSystemFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class),
                                    getContext().getComponent("SpawnerFactory", SpawnerFactory.class)
                            ),
                            new PlayerRespawnSystemFactory(),
                            new NoLifesDefeatSystemFactory(),
                            new NoEnemiesVictorySystemFactory(),
                            new MusicOnStartSystemFactory(
                                    getContext().getComponent("MusicFactory", MusicFactory.class)
                            ),
                            new ChangeBehaviorSystemFactory(),
                            new LevelEndSystemFactory(),
                            new WeatherSystemFactory(
                                    getContext().getComponent("WeatherFactory", WeatherFactory.class)
                            ),
                            new CameraEffectSystemFactory()
                    }
            );
        }
    }

    @ComponentName("EntitySystemPrototypeXmlLoader")
    public static final class EntitySystemPrototypeXmlLoaderSupplier extends ComponentSupplier<EntitySystemPrototypeXmlLoader> {
        @Override
        public EntitySystemPrototypeXmlLoader supplyComponent() {
            return new EntitySystemPrototypeXmlLoader(
                    new RegistrableEntitySystemPrototypeXmlLoader[] {
                            new WorldDebugRenderSystemPrototypeXmlLoader(),
                            new WorldUpdateSystemPrototypeXmlLoader(),
                            new WorldLightRenderSystemPrototypeXmlLoader(),
                            new CameraTrackSystemPrototypeXmlLoader(),
                            new CameraUpdateSystemPrototypeXmlLoader(),
                            new DamageSystemPrototypeXmlLoader(),
                            new DestroyOnContactSystemPrototypeXmlLoader(),
                            new DestroySystemPrototypeXmlLoader(),
                            new RandomDirectionSystemPrototypeXmlLoader(),
                            new HealthSystemPrototypeXmlLoader(),
                            new HudRenderSystemPrototypeXmlLoader(
                                    getContext().getComponent("HudStagePrototypeXmlLoader", HudStagePrototypeXmlLoader.class)
                            ),
                            new PlayerControlSystemPrototypeXmlLoader(),
                            new LifetimeSystemPrototypeXmlLoader(),
                            new TiledMapRenderSystemPrototypeXmlLoader(),
                            new AutoMoveSystemPrototypeXmlLoader(),
                            new ViewUpdateSystemPrototypeXmlLoader(),
                            new AutoShootSystemPrototypeXmlLoader(),
                            new RandomShootSystemPrototypeXmlLoader(),
                            new BomberLayerRenderSystemPrototypeXmlLoader(),
                            new BombLayerRenderSystemPrototypeXmlLoader(),
                            new BonusLayerRenderSystemPrototypeXmlLoader(),
                            new BulletLayerRenderSystemPrototypeXmlLoader(),
                            new CloudLayerRenderSystemPrototypeXmlLoader(),
                            new ExplosionLayerRenderSystemPrototypeXmlLoader(),
                            new GroundLayerRenderSystemPrototypeXmlLoader(),
                            new ObstacleLayerRenderSystemPrototypeXmlLoader(),
                            new VehicleLayerRenderSystemPrototypeXmlLoader(),
                            new RandomSpawnSystemPrototypeXmlLoader(),
                            new AutoSpawnerSystemPrototypeXmlLoader(
                                    getContext().getComponent("SpawnerPrototypeXmlLoader", SpawnerPrototypeXmlLoader.class)
                            ),
                            new PlayerRespawnSystemPrototypeXmlLoader(),
                            new NoLifesDefeatSystemPrototypeXmlLoader(),
                            new NoEnemiesVictorySystemPrototypeXmlLoader(),
                            new MusicOnStartSystemPrototypeXmlLoader(
                                    getContext().getComponent("MusicPrototypeXmlLoader", MusicPrototypeXmlLoader.class)
                            ),
                            new ChangeBehaviorSystemPrototypeXmlLoader(),
                            new LevelEndSystemPrototypeXmlLoader(),
                            new WeatherSystemPrototypeXmlLoader(
                                    getContext().getComponent("WeatherPrototypeXmlLoader", WeatherPrototypeXmlLoader.class)
                            ),
                            new CameraEffectSystemPrototypeXmlLoader()
                    }
            );
        }
    }
}
