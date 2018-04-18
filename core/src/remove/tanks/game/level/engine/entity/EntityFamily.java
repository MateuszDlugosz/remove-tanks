package remove.tanks.game.level.engine.entity;

import com.badlogic.ashley.core.Family;
import remove.tanks.game.level.engine.entity.component.airplane.AirplaneComponent;
import remove.tanks.game.level.engine.entity.component.behavior.ChangeBehaviorComponent;
import remove.tanks.game.level.engine.entity.component.bonus.LeaveBonusComponent;
import remove.tanks.game.level.engine.entity.component.camera.CameraTrackComponent;
import remove.tanks.game.level.engine.entity.component.combat.*;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponent;
import remove.tanks.game.level.engine.entity.component.direction.RandomDirectionComponent;
import remove.tanks.game.level.engine.entity.component.faction.EnemyComponent;
import remove.tanks.game.level.engine.entity.component.faction.PlayerComponent;
import remove.tanks.game.level.engine.entity.component.identity.IdentityComponent;
import remove.tanks.game.level.engine.entity.component.input.InputComponent;
import remove.tanks.game.level.engine.entity.component.lifecycle.*;
import remove.tanks.game.level.engine.entity.component.move.AutoMoveComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.render.ViewComponent;
import remove.tanks.game.level.engine.entity.component.render.layer.*;
import remove.tanks.game.level.engine.entity.component.spawn.AirplaneSpawnerComponent;
import remove.tanks.game.level.engine.entity.component.spawn.AutoSpawnerComponent;
import remove.tanks.game.level.engine.entity.component.spawn.RespawnComponent;
import remove.tanks.game.level.engine.entity.component.speed.SpeedComponent;
import remove.tanks.game.level.engine.entity.component.state.StateComponent;

/**
 * @author Mateusz Długosz
 */
public enum EntityFamily {
    CreateFamily(Family.all(
            PhysicsComponent.class, CreateComponent.class
    ).get()),
    DestroyFamily(Family.all(
           PhysicsComponent.class, DestroyComponent.class
    ).get()),
    DestroyOnContactFamily(Family.all(
            PhysicsComponent.class, DestroyOnContactComponent.class
    ).get()),
    DestroyOnContactLostFamily(Family.all(
            PhysicsComponent.class, DestroyOnContactLostComponent.class
    ).get()),
    LifetimeFamily(Family.all(
            PhysicsComponent.class, LifetimeComponent.class
    ).get()),
    CameraTrackFamily(Family.all(
            PhysicsComponent.class, CameraTrackComponent.class
    ).get()),
    InputFamily(Family.all(
            PhysicsComponent.class, InputComponent.class
    ).get()),
    AutoMoveFamily(Family.all(
            PhysicsComponent.class, DirectionComponent.class, AutoMoveComponent.class,
            SpeedComponent.class, StateComponent.class
    ).get()),
    ViewFamily(Family.all(
            PhysicsComponent.class, ViewComponent.class,
            StateComponent.class, DirectionComponent.class
    ).get()),
    GroundRenderLayerFamily(Family.all(
            PhysicsComponent.class, ViewComponent.class, GroundRenderLayerComponent.class,
            StateComponent.class, DirectionComponent.class
    ).get()),
    BulletRenderLayerFamily(Family.all(
            PhysicsComponent.class, ViewComponent.class, BulletRenderLayerComponent.class,
            StateComponent.class, DirectionComponent.class
    ).get()),
    VehicleRenderLayerFamily(Family.all(
            PhysicsComponent.class, ViewComponent.class, VehicleRenderLayerComponent.class,
            StateComponent.class, DirectionComponent.class
    ).get()),
    ObstacleRenderLayerFamily(Family.all(
            PhysicsComponent.class, ViewComponent.class, ObstacleRenderLayerComponent.class,
            StateComponent.class, DirectionComponent.class
    ).get()),
    ExplosionRenderLayerFamily(Family.all(
            PhysicsComponent.class, ViewComponent.class, ExplosionRenderLayerComponent.class,
            StateComponent.class, DirectionComponent.class
    ).get()),
    BonusRenderLayerFamily(Family.all(
            PhysicsComponent.class, ViewComponent.class, BonusRenderLayerComponent.class,
            StateComponent.class, DirectionComponent.class
    ).get()),
    CloudRenderLayerFamily(Family.all(
            PhysicsComponent.class, ViewComponent.class, CloudRenderLayerComponent.class,
            StateComponent.class, DirectionComponent.class
    ).get()),
    BombRenderLayerFamily(Family.all(
            PhysicsComponent.class, ViewComponent.class, BombRenderLayerComponent.class,
            StateComponent.class, DirectionComponent.class
    ).get()),
    AirplaneRenderLayerFamily(Family.all(
            PhysicsComponent.class, ViewComponent.class, AirplaneRenderLayerComponent.class,
            StateComponent.class, DirectionComponent.class
    ).get()),
    RandomDirectionFamily(Family.all(
            PhysicsComponent.class, RandomDirectionComponent.class
    ).get()),
    HealthFamily(Family.all(
            PhysicsComponent.class, HealthComponent.class
    ).get()),
    DamageFamily(Family.all(
            PhysicsComponent.class, DamageComponent.class
    ).get()),
    HitFamily(Family.all(
            PhysicsComponent.class, HitComponent.class
    ).get()),
    LeaveBonusFamily(Family.all(
           PhysicsComponent.class, LeaveBonusComponent.class
    ).get()),
    IdentityFamily(Family.all(
           PhysicsComponent.class, IdentityComponent.class
    ).get()),
    AutoShootFamily(Family.all(
            PhysicsComponent.class, DirectionComponent.class,
            AutoShootComponent.class, AmmoComponent.class
    ).get()),
    RandomShootFamily(Family.all(
            PhysicsComponent.class, RandomShootComponent.class
    ).get()),
    EnemyFamily(Family.all(
            PhysicsComponent.class, EnemyComponent.class
    ).get()),
    PlayerFamily(Family.all(
            PhysicsComponent.class, PlayerComponent.class
    ).get()),
    ChangeBehaviorFamily(Family.all(
            PhysicsComponent.class, ChangeBehaviorComponent.class
    ).get()),
    RandomCreateFamily(Family.all(
            PhysicsComponent.class, RandomCreateComponent.class
    ).get()),
    AutoSpawnerFamily(Family.all(
            PhysicsComponent.class, AutoSpawnerComponent.class
    ).get()),
    RespawnFamily(Family.all(
            PhysicsComponent.class, RespawnComponent.class
    ).get()),
    AirplaneSpawnerFamily(Family.all(
            PhysicsComponent.class, AirplaneSpawnerComponent.class
    ).get()),
    AirplaneFamily(Family.all(
            PhysicsComponent.class, AirplaneComponent.class
    ).get());

    private final Family family;

    EntityFamily(Family family) {
        this.family = family;
    }

    public Family getFamily() {
        return family;
    }
}
