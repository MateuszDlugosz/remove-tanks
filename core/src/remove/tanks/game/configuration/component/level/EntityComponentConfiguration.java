package remove.tanks.game.configuration.component.level;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphics.effect.EffectFactory;
import remove.tanks.game.graphics.effect.EffectPrefabXmlReader;
import remove.tanks.game.graphics.view.ViewFactory;
import remove.tanks.game.graphics.view.ViewPrefabXmlReader;
import remove.tanks.game.level.engine.entity.EntityPrefabCodeXmlReader;
import remove.tanks.game.level.engine.entity.component.*;
import remove.tanks.game.level.engine.entity.component.airplane.AirplaneComponentFactory;
import remove.tanks.game.level.engine.entity.component.airplane.AirplaneComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.behavior.ChangeBehaviorComponentFactory;
import remove.tanks.game.level.engine.entity.component.behavior.ChangeBehaviorComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.bonus.LeaveBonusComponentFactory;
import remove.tanks.game.level.engine.entity.component.bonus.LeaveBonusComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.camera.CameraTrackComponentFactory;
import remove.tanks.game.level.engine.entity.component.camera.CameraTrackComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.combat.*;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponentFactory;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.direction.RandomDirectionComponentFactory;
import remove.tanks.game.level.engine.entity.component.direction.RandomDirectionComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.faction.EnemyComponentFactory;
import remove.tanks.game.level.engine.entity.component.faction.EnemyComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.faction.PlayerComponentFactory;
import remove.tanks.game.level.engine.entity.component.faction.PlayerComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.identity.IdentityComponentFactory;
import remove.tanks.game.level.engine.entity.component.identity.IdentityComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.input.InputComponentFactory;
import remove.tanks.game.level.engine.entity.component.input.InputComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.lifecycle.*;
import remove.tanks.game.level.engine.entity.component.move.AutoMoveComponentFactory;
import remove.tanks.game.level.engine.entity.component.move.AutoMoveComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponentFactory;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.render.ViewComponentFactory;
import remove.tanks.game.level.engine.entity.component.render.ViewComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.render.layer.*;
import remove.tanks.game.level.engine.entity.component.spawn.*;
import remove.tanks.game.level.engine.entity.component.speed.SpeedComponentFactory;
import remove.tanks.game.level.engine.entity.component.speed.SpeedComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.speed.SpeedModifierComponentFactory;
import remove.tanks.game.level.engine.entity.component.speed.SpeedModifierComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.state.StateComponentFactory;
import remove.tanks.game.level.engine.entity.component.state.StateComponentPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.trigger.*;
import remove.tanks.game.level.event.EntityEventFactory;
import remove.tanks.game.level.event.EntityEventPrefabXmlReader;
import remove.tanks.game.level.utility.create.CreateEntryFactory;
import remove.tanks.game.level.utility.create.CreateEntryPrefabXmlReader;
import remove.tanks.game.level.utility.direction.DirectionXmlReader;
import remove.tanks.game.level.utility.state.StateXmlReader;
import remove.tanks.game.physics.body.BodyFactory;
import remove.tanks.game.physics.body.BodyPrefabXmlReader;
import remove.tanks.game.physics.fixture.hitbox.HitBoxFactory;
import remove.tanks.game.physics.fixture.hitbox.HitBoxPrefabXmlReader;
import remove.tanks.game.physics.fixture.sensor.SensorFactory;
import remove.tanks.game.physics.fixture.sensor.SensorPrefabXmlReader;
import remove.tanks.game.physics.light.LightHandlerFactory;
import remove.tanks.game.physics.light.LightHandlerPrefabXmlReader;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;
import remove.tanks.game.utility.surface.position.PositionFactory;
import remove.tanks.game.utility.surface.position.PositionPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class EntityComponentConfiguration {
    @ComponentName("ComponentPrefabXmlReader")
    public static final class ComponentPrefabXmlReaderSupplier extends ComponentSupplier<ComponentPrefabXmlReader> {
        @Override
        public ComponentPrefabXmlReader supplyComponent() {
            return new ComponentPrefabXmlReader(
                    new SubComponentPrefabXmlReader[] {
                            new CameraTrackComponentPrefabXmlReader(
                                    getContext().getComponent("PositionPrefabXmlReader", PositionPrefabXmlReader.class)
                            ),
                            new PhysicsComponentPrefabXmlReader(
                                    getContext().getComponent("BodyPrefabXmlReader", BodyPrefabXmlReader.class),
                                    getContext().getComponent("HitBoxPrefabXmlReader", HitBoxPrefabXmlReader.class),
                                    getContext().getComponent("SensorPrefabXmlReader", SensorPrefabXmlReader.class),
                                    getContext().getComponent("LightHandlerPrefabXmlReader", LightHandlerPrefabXmlReader.class)
                            ),
                            new SpeedComponentPrefabXmlReader(),
                            new SpeedModifierComponentPrefabXmlReader(),
                            new StateComponentPrefabXmlReader(
                                    getContext().getComponent("StateXmlReader", StateXmlReader.class)
                            ),
                            new ViewComponentPrefabXmlReader(
                                    getContext().getComponent("ViewPrefabXmlReader", ViewPrefabXmlReader.class)
                            ),
                            new CreateTriggerComponentPrefabXmlReader(
                                    getContext().getComponent("EntityEventPrefabXmlReader", EntityEventPrefabXmlReader.class)
                            ),
                            new DestroyTriggerComponentPrefabXmlReader(
                                    getContext().getComponent("EntityEventPrefabXmlReader", EntityEventPrefabXmlReader.class)
                            ),
                            new HitTriggerComponentPrefabXmlReader(
                                    getContext().getComponent("EntityEventPrefabXmlReader", EntityEventPrefabXmlReader.class)
                            ),
                            new DirectionComponentPrefabXmlReader(
                                    getContext().getComponent("DirectionXmlReader", DirectionXmlReader.class)
                            ),
                            new RandomDirectionComponentPrefabXmlReader(
                                    getContext().getComponent("DirectionXmlReader", DirectionXmlReader.class)
                            ),
                            new InputComponentPrefabXmlReader(),
                            new AutoMoveComponentPrefabXmlReader(),
                            new GroundRenderLayerComponentPrefabXmlReader(),
                            new BulletRenderLayerComponentPrefabXmlReader(),
                            new VehicleRenderLayerComponentPrefabXmlReader(),
                            new ObstacleRenderLayerComponentPrefabXmlReader(),
                            new ExplosionRenderLayerComponentPrefabXmlReader(),
                            new BonusRenderLayerComponentPrefabXmlReader(),
                            new CloudRenderLayerComponentPrefabXmlReader(),
                            new BombRenderLayerComponentPrefabXmlReader(),
                            new AirplaneRenderLayerComponentPrefabXmlReader(),
                            new CreateComponentPrefabXmlReader(),
                            new DestroyComponentPrefabXmlReader(),
                            new LifetimeComponentPrefabXmlReader(),
                            new HealthComponentPrefabXmlReader(),
                            new DamageComponentPrefabXmlReader(),
                            new ProtectionComponentPrefabXmlReader(),
                            new HitComponentPrefabXmlReader(
                                    getContext().getComponent("EffectPrefabXmlReader", EffectPrefabXmlReader.class)
                            ),
                            new LeaveBonusComponentPrefabXmlReader(),
                            new IdentityComponentPrefabXmlReader(),
                            new DestroyOnContactComponentPrefabXmlReader(),
                            new AmmoComponentPrefabXmlReader(),
                            new AutoShootComponentPrefabXmlReader(),
                            new RandomShootComponentPrefabXmlReader(),
                            new EnemyComponentPrefabXmlReader(),
                            new PlayerComponentPrefabXmlReader(),
                            new DestroyOnContactLostComponentPrefabXmlReader(),
                            new ChangeBehaviorComponentPrefabXmlReader(
                                    new ComponentPrefabXmlReader(
                                            new SubComponentPrefabXmlReader[] {
                                                    new SpeedModifierComponentPrefabXmlReader(),
                                                    new DestroyTriggerComponentPrefabXmlReader(
                                                            getContext().getComponent("EntityEventPrefabXmlReader", EntityEventPrefabXmlReader.class)
                                                    ),
                                                    new DirectionComponentPrefabXmlReader(
                                                            getContext().getComponent("DirectionXmlReader", DirectionXmlReader.class)
                                                    )
                                            }
                                    )
                            ),
                            new RandomCreateComponentPrefabXmlReader(
                                    getContext().getComponent("CreateEntryPrefabXmlReader", CreateEntryPrefabXmlReader.class)
                            ),
                            new RespawnComponentPrefabXmlReader(),
                            new AirplaneSpawnerComponentPrefabXmlReader(
                                    getContext().getComponent("EntityPrefabCodeXmlReader", EntityPrefabCodeXmlReader.class)
                            ),
                            new AutoSpawnerComponentPrefabXmlReader(),
                            new AirplaneComponentPrefabXmlReader()
                    }
            );
        }
    }

    @ComponentName("ComponentFactory")
    public static final class ComponentFactorySupplier extends ComponentSupplier<ComponentFactory> {
        @Override
        public ComponentFactory supplyComponent() {
            return new ComponentFactory(
                    new SubComponentFactory[] {
                            new CameraTrackComponentFactory(
                                    getContext().getComponent("PositionFactory", PositionFactory.class)
                            ),
                            new PhysicsComponentFactory(
                                    getContext().getComponent("BodyFactory", BodyFactory.class),
                                    getContext().getComponent("HitBoxFactory", HitBoxFactory.class),
                                    getContext().getComponent("SensorFactory", SensorFactory.class),
                                    getContext().getComponent("LightHandlerFactory", LightHandlerFactory.class)
                            ),
                            new SpeedComponentFactory(),
                            new SpeedModifierComponentFactory(),
                            new StateComponentFactory(),
                            new ViewComponentFactory(
                                    getContext().getComponent("ViewFactory", ViewFactory.class)
                            ),
                            new CreateTriggerComponentFactory(
                                    getContext().getComponent("EntityEventFactory", EntityEventFactory.class)
                            ),
                            new DestroyTriggerComponentFactory(
                                    getContext().getComponent("EntityEventFactory", EntityEventFactory.class)
                            ),
                            new HitTriggerComponentFactory(
                                    getContext().getComponent("EntityEventFactory", EntityEventFactory.class)
                            ),
                            new DirectionComponentFactory(),
                            new RandomDirectionComponentFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new InputComponentFactory(),
                            new AutoMoveComponentFactory(),
                            new GroundRenderLayerComponentFactory(),
                            new BulletRenderLayerComponentFactory(),
                            new VehicleRenderLayerComponentFactory(),
                            new ObstacleRenderLayerComponentFactory(),
                            new ExplosionRenderLayerComponentFactory(),
                            new BonusRenderLayerComponentFactory(),
                            new CloudRenderLayerComponentFactory(),
                            new BombRenderLayerComponentFactory(),
                            new AirplaneRenderLayerComponentFactory(),
                            new CreateComponentFactory(),
                            new DestroyComponentFactory(),
                            new LifetimeComponentFactory(),
                            new HealthComponentFactory(),
                            new DamageComponentFactory(),
                            new ProtectionComponentFactory(),
                            new HitComponentFactory(
                                    getContext().getComponent("EffectFactory", EffectFactory.class)
                            ),
                            new LeaveBonusComponentFactory(),
                            new IdentityComponentFactory(),
                            new DestroyOnContactComponentFactory(),
                            new AmmoComponentFactory(),
                            new AutoShootComponentFactory(),
                            new RandomShootComponentFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new EnemyComponentFactory(),
                            new PlayerComponentFactory(),
                            new DestroyOnContactLostComponentFactory(),
                            new ChangeBehaviorComponentFactory(
                                    new ComponentFactory(
                                            new SubComponentFactory[] {
                                                    new SpeedModifierComponentFactory(),
                                                    new DestroyTriggerComponentFactory(
                                                            getContext().getComponent("EntityEventFactory", EntityEventFactory.class)
                                                    ),
                                                    new DirectionComponentFactory()
                                            }
                                    )
                            ),
                            new RandomCreateComponentFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class),
                                    getContext().getComponent("CreateEntryFactory", CreateEntryFactory.class)
                            ),
                            new RespawnComponentFactory(),
                            new AirplaneSpawnerComponentFactory(),
                            new AutoSpawnerComponentFactory(),
                            new AirplaneComponentFactory()
                    }
            );
        }
    }

    @ComponentName("ComponentPrefabMapObjectReader")
    public static final class ComponentPrefabMapObjectReaderSupplier extends ComponentSupplier<ComponentPrefabMapObjectReader> {
        @Override
        public ComponentPrefabMapObjectReader supplyComponent() {
            return new ComponentPrefabMapObjectReader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("ComponentPrefabXmlReader", ComponentPrefabXmlReader.class)
            );
        }
    }
}
