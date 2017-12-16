package remove.tanks.game.level.engine.entity;

import com.badlogic.ashley.core.Family;
import remove.tanks.game.level.engine.entity.component.audio.SoundOnDestroyComponent;
import remove.tanks.game.level.engine.entity.component.audio.SoundOnSpawnComponent;
import remove.tanks.game.level.engine.entity.component.behavior.ChangeBehaviorComponent;
import remove.tanks.game.level.engine.entity.component.bonus.BonusLootComponent;
import remove.tanks.game.level.engine.entity.component.camera.CameraTrackComponent;
import remove.tanks.game.level.engine.entity.component.control.PlayerControlComponent;
import remove.tanks.game.level.engine.entity.component.damage.DamageComponent;
import remove.tanks.game.level.engine.entity.component.destroy.DestroyComponent;
import remove.tanks.game.level.engine.entity.component.destroy.DestroyOnContactComponent;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponent;
import remove.tanks.game.level.engine.entity.component.direction.RandomDirectionComponent;
import remove.tanks.game.level.engine.entity.component.faction.EnemyComponent;
import remove.tanks.game.level.engine.entity.component.graphic.GraphicsComponent;
import remove.tanks.game.level.engine.entity.component.health.HealthComponent;
import remove.tanks.game.level.engine.entity.component.id.IdentityComponent;
import remove.tanks.game.level.engine.entity.component.layer.*;
import remove.tanks.game.level.engine.entity.component.lifetime.LifetimeComponent;
import remove.tanks.game.level.engine.entity.component.move.AutoMoveComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.points.PointsComponent;
import remove.tanks.game.level.engine.entity.component.respawn.PlayerRespawnComponent;
import remove.tanks.game.level.engine.entity.component.shoot.AmmoComponent;
import remove.tanks.game.level.engine.entity.component.shoot.AutoShootComponent;
import remove.tanks.game.level.engine.entity.component.shoot.RandomShootComponent;
import remove.tanks.game.level.engine.entity.component.spawn.AutoSpawnerComponent;
import remove.tanks.game.level.engine.entity.component.spawn.BombersSpawnerComponent;
import remove.tanks.game.level.engine.entity.component.spawn.RandomSpawnComponent;
import remove.tanks.game.level.engine.entity.component.spawn.SpawnOnDestroyComponent;
import remove.tanks.game.level.engine.entity.component.speed.SpeedComponent;
import remove.tanks.game.level.engine.entity.component.state.StateComponent;
import remove.tanks.game.level.engine.entity.component.trigger.TriggerComponent;

/**
 * @author Mateusz Długosz
 */
public enum EntityFamily {
    RandomDirectionFamily(Family.all(
            PhysicsComponent.class, DirectionComponent.class,
            RandomDirectionComponent.class
    ).get()),
    RandomShootFamily(Family.all(
            PhysicsComponent.class, RandomShootComponent.class
    ).get()),
    RandomSpawnFamily(Family.all(
            PhysicsComponent.class, RandomSpawnComponent.class
    ).get()),
    AutoMoveFamily(Family.all(
            PhysicsComponent.class, DirectionComponent.class,
            AutoMoveComponent.class, SpeedComponent.class,
            StateComponent.class
    ).get()),
    AutoShootFamily(Family.all(
            PhysicsComponent.class, DirectionComponent.class,
            AutoShootComponent.class, AmmoComponent.class
    ).get()),
    CameraTrackingFamily(Family.all(
            PhysicsComponent.class, CameraTrackComponent.class
    ).get()),
    GroundLayerRenderableFamily(Family.all(
            PhysicsComponent.class, GraphicsComponent.class,
            GroundLayerComponent.class, StateComponent.class,
            DirectionComponent.class
    ).get()),
    BulletLayerRenderableFamily(Family.all(
            PhysicsComponent.class, GraphicsComponent.class,
            BulletLayerComponent.class, StateComponent.class,
            DirectionComponent.class
    ).get()),
    VehicleLayerRenderableFamily(Family.all(
            PhysicsComponent.class, GraphicsComponent.class,
            VehicleLayerComponent.class, StateComponent.class,
            DirectionComponent.class
    ).get()),
    ObstacleLayerRenderableFamily(Family.all(
            PhysicsComponent.class, GraphicsComponent.class,
            ObstacleLayerComponent.class, StateComponent.class,
            DirectionComponent.class
    ).get()),
    ExplosionLayerRenderableFamily(Family.all(
            PhysicsComponent.class, GraphicsComponent.class,
            ExplosionLayerComponent.class, StateComponent.class,
            DirectionComponent.class
    ).get()),
    BonusLayerRenderableFamily(Family.all(
            PhysicsComponent.class, GraphicsComponent.class,
            BonusLayerComponent.class, StateComponent.class,
            DirectionComponent.class
    ).get()),
    CloudLayerRenderableFamily(Family.all(
            PhysicsComponent.class, GraphicsComponent.class,
            CloudLayerComponent.class, StateComponent.class,
            DirectionComponent.class
    ).get()),
    BombsLayerRenderableFamily(Family.all(
            PhysicsComponent.class, GraphicsComponent.class,
            BombLayerComponent.class, StateComponent.class,
            DirectionComponent.class
    ).get()),
    BomberLayerRenderableFamily(Family.all(
            PhysicsComponent.class, GraphicsComponent.class,
            BomberLayerComponent.class, StateComponent.class,
            DirectionComponent.class
    ).get()),
    DestroyedFamily(Family.all(
            PhysicsComponent.class, DestroyComponent.class
    ).get()),
    DestroyOnContactFamily(Family.all(
            PhysicsComponent.class, DestroyOnContactComponent.class
    ).get()),
    HealthFamily(Family.all(
            PhysicsComponent.class, HealthComponent.class
    ).get()),
    LifetimeFamily(Family.all(
            PhysicsComponent.class, LifetimeComponent.class
    ).get()),
    PlayerControlledFamily(Family.all(
            PhysicsComponent.class, PlayerControlComponent.class,
            DirectionComponent.class, StateComponent.class
    ).get()),
    RenderableFamily(Family.all(
            PhysicsComponent.class, GraphicsComponent.class,
            StateComponent.class, DirectionComponent.class
    ).get()),
    DamageableFamily(Family.all(
            PhysicsComponent.class, DamageComponent.class
    ).get()),
    SoundableFamily(Family.all(
            PhysicsComponent.class
    ).one(
            SoundOnSpawnComponent.class, SoundOnDestroyComponent.class
    ).get()),
    LifecycleFamily(Family.all(
            PhysicsComponent.class
    ).one(
            SpawnOnDestroyComponent.class
    ).get()),
    BombersSpawnerFamily(Family.all(
            PhysicsComponent.class, BombersSpawnerComponent.class
    ).get()),
    BonusLootFamily(Family.all(
            PhysicsComponent.class, BonusLootComponent.class
    ).get()),
    PointsFamily(Family.all(
            PhysicsComponent.class, PointsComponent.class
    ).get()),
    EnemiesFamily(Family.all(
            PhysicsComponent.class, EnemyComponent.class
    ).get()),
    SpawnerFamily(Family.all(
            PhysicsComponent.class, AutoSpawnerComponent.class
    ).get()),
    TriggerFamily(Family.all(
            PhysicsComponent.class, TriggerComponent.class
    ).get()),
    PlayerRespawnFamily(Family.all(
            PhysicsComponent.class, PlayerRespawnComponent.class
    ).get()),
    ChangeBehaviorFamily(Family.all(
            PhysicsComponent.class, ChangeBehaviorComponent.class
    ).get()),
    IdentifiableFamily(Family.all(
            PhysicsComponent.class, IdentityComponent.class
    ).get());

    private final Family family;

    EntityFamily(Family family) {
        this.family = family;
    }

    public Family getFamily() {
        return family;
    }
}
