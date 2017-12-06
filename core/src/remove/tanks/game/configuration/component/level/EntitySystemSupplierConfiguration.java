package remove.tanks.game.configuration.component.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.audio.music.MusicFactory;
import remove.tanks.game.audio.music.MusicPrototypeXmlLoader;
import remove.tanks.game.graphic.effect.EffectFactory;
import remove.tanks.game.graphic.effect.EffectPrototypeXmlLoader;
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
import remove.tanks.game.level.engine.system.camera.CameraTrackingSystemFactory;
import remove.tanks.game.level.engine.system.camera.CameraTrackingSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.camera.CameraUpdateSystemFactory;
import remove.tanks.game.level.engine.system.camera.CameraUpdateSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.control.PlayerControlSystemFactory;
import remove.tanks.game.level.engine.system.control.PlayerControlSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.damage.DamageSystemFactory;
import remove.tanks.game.level.engine.system.damage.DamageSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.state.defeat.OperationDefeatSystemFactory;
import remove.tanks.game.level.engine.system.state.defeat.OperationDefeatSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.destroy.DestroyOnContactSystemFactory;
import remove.tanks.game.level.engine.system.destroy.DestroyOnContactSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.destroy.DestroySystemFactory;
import remove.tanks.game.level.engine.system.destroy.DestroySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.direction.RandomDirectionSystemFactory;
import remove.tanks.game.level.engine.system.direction.RandomDirectionSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.health.HealthSystemFactory;
import remove.tanks.game.level.engine.system.health.HealthSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.hud.OperationHudRenderSystemFactory;
import remove.tanks.game.level.engine.system.hud.OperationHudRenderSystemPrototypeXmlLoader;
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
import remove.tanks.game.level.engine.system.state.end.LevelEndSystemFactory;
import remove.tanks.game.level.engine.system.state.end.LevelEndSystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.state.victory.OperationVictorySystemFactory;
import remove.tanks.game.level.engine.system.state.victory.OperationVictorySystemPrototypeXmlLoader;
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
                            new CameraTrackingSystemFactory(),
                            new CameraUpdateSystemFactory(),
                            new DamageSystemFactory(),
                            new DestroyOnContactSystemFactory(),
                            new DestroySystemFactory(),
                            new RandomDirectionSystemFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new HealthSystemFactory(),
                            new OperationHudRenderSystemFactory(),
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
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class),
                                    getContext().getComponent("EffectFactory", EffectFactory.class)
                            ),
                            new BombLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class),
                                    getContext().getComponent("EffectFactory", EffectFactory.class)
                            ),
                            new BonusLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class),
                                    getContext().getComponent("EffectFactory", EffectFactory.class)
                            ),
                            new BulletLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class),
                                    getContext().getComponent("EffectFactory", EffectFactory.class)
                            ),
                            new CloudLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class),
                                    getContext().getComponent("EffectFactory", EffectFactory.class)
                            ),
                            new ExplosionLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class),
                                    getContext().getComponent("EffectFactory", EffectFactory.class)
                            ),
                            new GroundLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class),
                                    getContext().getComponent("EffectFactory", EffectFactory.class)
                            ),
                            new ObstacleLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class),
                                    getContext().getComponent("EffectFactory", EffectFactory.class)
                            ),
                            new VehicleLayerRenderSystemFactory(
                                    getContext().getComponent("ViewRenderer", ViewRenderer.class),
                                    getContext().getComponent("EffectFactory", EffectFactory.class)
                            ),
                            new RandomSpawnSystemFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new AutoSpawnerSystemFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class),
                                    getContext().getComponent("SpawnerFactory", SpawnerFactory.class)
                            ),
                            new PlayerRespawnSystemFactory(),
                            new OperationDefeatSystemFactory(),
                            new OperationVictorySystemFactory(),
                            new MusicOnStartSystemFactory(
                                    getContext().getComponent("MusicFactory", MusicFactory.class)
                            ),
                            new ChangeBehaviorSystemFactory(),
                            new LevelEndSystemFactory()
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
                            new CameraTrackingSystemPrototypeXmlLoader(),
                            new CameraUpdateSystemPrototypeXmlLoader(),
                            new DamageSystemPrototypeXmlLoader(),
                            new DestroyOnContactSystemPrototypeXmlLoader(),
                            new DestroySystemPrototypeXmlLoader(),
                            new RandomDirectionSystemPrototypeXmlLoader(),
                            new HealthSystemPrototypeXmlLoader(),
                            new OperationHudRenderSystemPrototypeXmlLoader(),
                            new PlayerControlSystemPrototypeXmlLoader(),
                            new LifetimeSystemPrototypeXmlLoader(),
                            new TiledMapRenderSystemPrototypeXmlLoader(),
                            new AutoMoveSystemPrototypeXmlLoader(),
                            new ViewUpdateSystemPrototypeXmlLoader(),
                            new AutoShootSystemPrototypeXmlLoader(),
                            new RandomShootSystemPrototypeXmlLoader(),
                            new BomberLayerRenderSystemPrototypeXmlLoader(
                                    getContext().getComponent("EffectPrototypeXmlLoader", EffectPrototypeXmlLoader.class)
                            ),
                            new BombLayerRenderSystemPrototypeXmlLoader(
                                    getContext().getComponent("EffectPrototypeXmlLoader", EffectPrototypeXmlLoader.class)
                            ),
                            new BonusLayerRenderSystemPrototypeXmlLoader(
                                    getContext().getComponent("EffectPrototypeXmlLoader", EffectPrototypeXmlLoader.class)
                            ),
                            new BulletLayerRenderSystemPrototypeXmlLoader(
                                    getContext().getComponent("EffectPrototypeXmlLoader", EffectPrototypeXmlLoader.class)
                            ),
                            new CloudLayerRenderSystemPrototypeXmlLoader(
                                    getContext().getComponent("EffectPrototypeXmlLoader", EffectPrototypeXmlLoader.class)
                            ),
                            new ExplosionLayerRenderSystemPrototypeXmlLoader(
                                    getContext().getComponent("EffectPrototypeXmlLoader", EffectPrototypeXmlLoader.class)
                            ),
                            new GroundLayerRenderSystemPrototypeXmlLoader(
                                    getContext().getComponent("EffectPrototypeXmlLoader", EffectPrototypeXmlLoader.class)
                            ),
                            new ObstacleLayerRenderSystemPrototypeXmlLoader(
                                    getContext().getComponent("EffectPrototypeXmlLoader", EffectPrototypeXmlLoader.class)
                            ),
                            new VehicleLayerRenderSystemPrototypeXmlLoader(
                                    getContext().getComponent("EffectPrototypeXmlLoader", EffectPrototypeXmlLoader.class)
                            ),
                            new RandomSpawnSystemPrototypeXmlLoader(),
                            new AutoSpawnerSystemPrototypeXmlLoader(
                                    getContext().getComponent("SpawnerPrototypeXmlLoader", SpawnerPrototypeXmlLoader.class)
                            ),
                            new PlayerRespawnSystemPrototypeXmlLoader(),
                            new OperationDefeatSystemPrototypeXmlLoader(),
                            new OperationVictorySystemPrototypeXmlLoader(),
                            new MusicOnStartSystemPrototypeXmlLoader(
                                    getContext().getComponent("MusicPrototypeXmlLoader", MusicPrototypeXmlLoader.class)
                            ),
                            new ChangeBehaviorSystemPrototypeXmlLoader(),
                            new LevelEndSystemPrototypeXmlLoader()
                    }
            );
        }
    }
}
