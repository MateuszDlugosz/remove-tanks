package remove.tanks.game.configuration.component.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.audio.sound.SoundFactory;
import remove.tanks.game.audio.sound.SoundPrototypeXmlLoader;
import remove.tanks.game.graphic.view.ViewFactory;
import remove.tanks.game.graphic.view.ViewPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.ComponentFactory;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.actor.ActorComponentFactory;
import remove.tanks.game.level.engine.entity.component.actor.ActorComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.actor.ActorDirectionControllerComponentFactory;
import remove.tanks.game.level.engine.entity.component.actor.ActorDirectionControllerComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.audio.SoundOnDestroyComponentFactory;
import remove.tanks.game.level.engine.entity.component.audio.SoundOnDestroyComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.audio.SoundOnSpawnComponentFactory;
import remove.tanks.game.level.engine.entity.component.audio.SoundOnSpawnComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.bonus.BonusComponentFactory;
import remove.tanks.game.level.engine.entity.component.bonus.BonusComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.bonus.BonusLootComponentFactory;
import remove.tanks.game.level.engine.entity.component.bonus.BonusLootComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.camera.CameraTrackingComponentFactory;
import remove.tanks.game.level.engine.entity.component.camera.CameraTrackingComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.control.PlayerControlComponentFactory;
import remove.tanks.game.level.engine.entity.component.control.PlayerControlComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.damage.DamageComponentFactory;
import remove.tanks.game.level.engine.entity.component.damage.DamageComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.destroy.DestroyComponentFactory;
import remove.tanks.game.level.engine.entity.component.destroy.DestroyComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.destroy.DestroyOnContactComponentFactory;
import remove.tanks.game.level.engine.entity.component.destroy.DestroyOnContactComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponentFactory;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.direction.RandomDirectionComponentFactory;
import remove.tanks.game.level.engine.entity.component.direction.RandomDirectionComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.faction.EnemyComponentFactory;
import remove.tanks.game.level.engine.entity.component.faction.EnemyComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.faction.PlayerComponentFactory;
import remove.tanks.game.level.engine.entity.component.faction.PlayerComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.graphic.GraphicsComponentFactory;
import remove.tanks.game.level.engine.entity.component.graphic.GraphicsComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.health.HealthComponentFactory;
import remove.tanks.game.level.engine.entity.component.health.HealthComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.layer.*;
import remove.tanks.game.level.engine.entity.component.layer.highlight.HighlightComponentFactory;
import remove.tanks.game.level.engine.entity.component.layer.highlight.HighlightComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.layer.highlight.HighlightOnHitComponentFactory;
import remove.tanks.game.level.engine.entity.component.layer.highlight.HighlightOnHitComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.lifetime.LifetimeComponentFactory;
import remove.tanks.game.level.engine.entity.component.lifetime.LifetimeComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.move.AutoMoveComponentFactory;
import remove.tanks.game.level.engine.entity.component.move.AutoMoveComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponentFactory;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.point.PointsComponentFactory;
import remove.tanks.game.level.engine.entity.component.point.PointsComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.respawn.PlayerRespawnComponentFactory;
import remove.tanks.game.level.engine.entity.component.respawn.PlayerRespawnComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.shoot.*;
import remove.tanks.game.level.engine.entity.component.spawn.*;
import remove.tanks.game.level.engine.entity.component.speed.*;
import remove.tanks.game.level.engine.entity.component.state.StateComponentFactory;
import remove.tanks.game.level.engine.entity.component.state.StateComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.trigger.TriggerComponentFactory;
import remove.tanks.game.level.engine.entity.component.trigger.TriggerComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.utility.direction.AvailableDirectionsXmlLoader;
import remove.tanks.game.level.engine.utility.direction.DirectionXmlLoader;
import remove.tanks.game.level.engine.utility.spwan.entry.SpawnEntryFactory;
import remove.tanks.game.level.engine.utility.spwan.entry.SpawnEntryPrototypeXmlLoader;
import remove.tanks.game.physics.body.BodyFactory;
import remove.tanks.game.physics.body.BodyPrototypeXmlLoader;
import remove.tanks.game.physics.fixture.hitbox.HitBoxFactory;
import remove.tanks.game.physics.fixture.hitbox.HitBoxPrototypeXmlLoader;
import remove.tanks.game.physics.fixture.sensor.SensorFactory;
import remove.tanks.game.physics.fixture.sensor.SensorPrototypeXmlLoader;
import remove.tanks.game.physics.light.LightHandlerFactory;
import remove.tanks.game.physics.light.LightHandlerPrototypeXmlLoader;
import remove.tanks.game.utility.position.PositionFactory;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;
import remove.tanks.game.utility.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class EntityComponentSupplierConfiguration {
    @ComponentName("ComponentFactory")
    public static final class ComponentFactorySupplier extends ComponentSupplier<ComponentFactory> {
        @Override
        public ComponentFactory supplyComponent() {
            return new ComponentFactory(
                    new RegistrableComponentFactory[] {
                            new SoundOnSpawnComponentFactory(
                                    getContext().getComponent("SoundFactory", SoundFactory.class)
                            ),
                            new SoundOnDestroyComponentFactory(
                                    getContext().getComponent("SoundFactory", SoundFactory.class)
                            ),
                            new BonusComponentFactory(),
                            new BonusLootComponentFactory(),
                            new CameraTrackingComponentFactory(
                                    getContext().getComponent("PositionFactory", PositionFactory.class)
                            ),
                            new DamageComponentFactory(),
                            new DestroyComponentFactory(),
                            new DestroyOnContactComponentFactory(),
                            new DirectionComponentFactory(),
                            new RandomDirectionComponentFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new EnemyComponentFactory(),
                            new PlayerComponentFactory(),
                            new GraphicsComponentFactory(
                                    getContext().getComponent("ViewFactory", ViewFactory.class)
                            ),
                            new HealthComponentFactory(),
                            new PlayerControlComponentFactory(),
                            new LifetimeComponentFactory(),
                            new AutoMoveComponentFactory(),
                            new PhysicsComponentFactory(
                                    getContext().getComponent("BodyFactory", BodyFactory.class),
                                    getContext().getComponent("HitBoxFactory", HitBoxFactory.class),
                                    getContext().getComponent("SensorFactory", SensorFactory.class),
                                    getContext().getComponent("LightHandlerFactory", LightHandlerFactory.class)
                            ),
                            new PointsComponentFactory(),
                            new BomberLayerComponentFactory(),
                            new BombLayerComponentFactory(),
                            new BulletLayerComponentFactory(),
                            new BonusLayerComponentFactory(),
                            new VehicleLayerComponentFactory(),
                            new ObstacleLayerComponentFactory(),
                            new GroundLayerComponentFactory(),
                            new CloudLayerComponentFactory(),
                            new ExplosionLayerComponentFactory(),
                            new AmmoComponentFactory(),
                            new AutoShootComponentFactory(),
                            new RandomShootComponentFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new SpeedComponentFactory(),
                            new StateComponentFactory(),
                            new SpawnOnDestroyComponentFactory(
                                    getContext().getComponent("SpawnEntryFactory", SpawnEntryFactory.class)
                            ),
                            new RandomSpawnComponentFactory(
                                    getContext().getComponent("SpawnEntryFactory", SpawnEntryFactory.class),
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new AutoSpawnerComponentFactory(),
                            new TriggerComponentFactory(),
                            new BombersSpawnerComponentFactory(),
                            new PlayerRespawnComponentFactory(),
                            new ActorComponentFactory(),
                            new ActorDirectionControllerComponentFactory(),
                            new HighlightComponentFactory(),
                            new HighlightOnHitComponentFactory(),
                            new SpeedModifierComponentFactory(),
                            new ModifySpeedComponentFactory()
                    }
            );
        }
    }

    @ComponentName("ComponentPrototypeXmlLoader")
    public static final class ComponentPrototypeXmlLoaderSupplier extends ComponentSupplier<ComponentPrototypeXmlLoader> {
        @Override
        public ComponentPrototypeXmlLoader supplyComponent() {
            return new ComponentPrototypeXmlLoader(
                    new RegistrableComponentPrototypeXmlLoader[] {
                            new SoundOnSpawnComponentPrototypeXmlLoader(
                                    getContext().getComponent("SoundPrototypeXmlLoader", SoundPrototypeXmlLoader.class)
                            ),
                            new SoundOnDestroyComponentPrototypeXmlLoader(
                                    getContext().getComponent("SoundPrototypeXmlLoader", SoundPrototypeXmlLoader.class)
                            ),
                            new BonusComponentPrototypeXmlLoader(),
                            new BonusLootComponentPrototypeXmlLoader(),
                            new CameraTrackingComponentPrototypeXmlLoader(
                                    getContext().getComponent("PositionPrototypeXmlLoader", PositionPrototypeXmlLoader.class)
                            ),
                            new DamageComponentPrototypeXmlLoader(),
                            new DestroyComponentPrototypeXmlLoader(),
                            new DestroyOnContactComponentPrototypeXmlLoader(),
                            new DirectionComponentPrototypeXmlLoader(
                                    getContext().getComponent("DirectionXmlLoader", DirectionXmlLoader.class)
                            ),
                            new RandomDirectionComponentPrototypeXmlLoader(
                                    getContext().getComponent("AvailableDirectionsXmlLoader", AvailableDirectionsXmlLoader.class)
                            ),
                            new EnemyComponentPrototypeXmlLoader(),
                            new PlayerComponentPrototypeXmlLoader(),
                            new GraphicsComponentPrototypeXmlLoader(
                                    getContext().getComponent("ViewPrototypeXmlLoader", ViewPrototypeXmlLoader.class)
                            ),
                            new HealthComponentPrototypeXmlLoader(),
                            new PlayerControlComponentPrototypeXmlLoader(),
                            new LifetimeComponentPrototypeXmlLoader(),
                            new AutoMoveComponentPrototypeXmlLoader(),
                            new PhysicsComponentPrototypeXmlLoader(
                                    getContext().getComponent("BodyPrototypeXmlLoader", BodyPrototypeXmlLoader.class),
                                    getContext().getComponent("HitBoxPrototypeXmlLoader", HitBoxPrototypeXmlLoader.class),
                                    getContext().getComponent("SensorPrototypeXmlLoader", SensorPrototypeXmlLoader.class),
                                    getContext().getComponent("LightHandlerPrototypeXmlLoader", LightHandlerPrototypeXmlLoader.class)
                            ),
                            new PointsComponentPrototypeXmlLoader(),
                            new BomberLayerComponentPrototypeXmlLoader(),
                            new BombLayerComponentPrototypeXmlLoader(),
                            new BulletLayerComponentPrototypeXmlLoader(),
                            new BonusLayerComponentPrototypeXmlLoader(),
                            new GroundLayerComponentPrototypeXmlLoader(),
                            new CloudLayerComponentPrototypeXmlLoader(),
                            new ExplosionLayerComponentPrototypeXmlLoader(),
                            new VehicleLayerComponentPrototypeXmlLoader(),
                            new ObstacleLayerComponentPrototypeXmlLoader(),
                            new AmmoComponentPrototypeXmlLoader(),
                            new AutoShootComponentPrototypeXmlLoader(),
                            new RandomShootComponentPrototypeXmlLoader(),
                            new SpeedComponentPrototypeXmlLoader(),
                            new StateComponentPrototypeXmlLoader(),
                            new SpawnOnDestroyComponentPrototypeXmlLoader(
                                    getContext().getComponent("SpawnEntryPrototypeXmlLoader", SpawnEntryPrototypeXmlLoader.class)
                            ),
                            new RandomSpawnComponentPrototypeXmlLoader(
                                    getContext().getComponent("SpawnEntryPrototypeXmlLoader", SpawnEntryPrototypeXmlLoader.class)
                            ),
                            new AutoSpawnerComponentPrototypeXmlLoader(),
                            new TriggerComponentPrototypeXmlLoader(),
                            new BombersSpawnerComponentPrototypeXmlLoader(),
                            new PlayerRespawnComponentPrototypeXmlLoader(),
                            new ActorComponentPrototypeXmlLoader(),
                            new ActorDirectionControllerComponentPrototypeXmlLoader(),
                            new HighlightComponentPrototypeXmlLoader(),
                            new HighlightOnHitComponentPrototypeXmlLoader(),
                            new SpeedModifierComponentPrototypeXmlLoader(),
                            new ModifySpeedComponentPrototypeXmlLoader()
                    }
            );
        }
    }
}
