package remove.tanks.game.level.engine.system;

/**
 * @author Mateusz Długosz
 */
public enum SystemType {
    MusicOnStartSystem(100),
    WorldUpdateSystem(200),
    PlayerControlSystem(300),
    CameraTrackSystem(400),
    CameraEffectSystem(450),
    CameraUpdateSystem(500),
    RandomDirectionSystem(600),
    RandomSpawnSystem(700),
    RandomShootSystem(800),
    AutoShootSystem(900),
    AutoMoveSystem(1000),
    HealthSystem(1100),
    DamageSystem(1200),
    ChangeBehaviorSystem(1300),
    TiledMapRenderSystem(1400),
    GroundLayerRenderSystem(1500),
    BulletLayerRenderSystem(1600),
    VehicleLayerRenderSystem(1700),
    ObstacleLayerRenderSystem(1800),
    BonusLayerRenderSystem(1900),
    ExplosionLayerRenderSystem(2000),
    CloudLayerRenderSystem(2100),
    BombLayerRenderSystem(2200),
    BomberLayerRenderSystem(2300),
    ViewUpdateSystem(2400),
    LifetimeSystem(2500),
    TimeUpdateSystem(2550),
    DestroyOnContactSystem(2600),
    DestroySystem(2700),
    WorldLightRenderSystem(2800),
    WorldDebugRenderSystem(2900),
    WeatherSystem(2950),
    HudSystem(3000),
    AutoSpawnerSystem(3100),
    PlayerRespawnSystem(3200),
    NoLifesDefeatSystem(3300),
    TimeEndDefeatSystem(3350),
    NoEnemiesVictorySystem(3400),
    LevelEndSystem(3500),
    TimelineSystem(3600);

    private final int priority;

    SystemType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
