package remove.tanks.game.level.engine.system;

/**
 * @author Mateusz Długosz
 */
public enum SystemType {
    MusicOnStartSystem(1),
    WorldUpdateSystem(200),
    InputSystem(400),
    CameraTrackSystem(600),
    CameraEffectSystem(800),
    CameraUpdateSystem(1000),
    RandomDirectionSystem(1200),
    RandomCreateSystem(1400),
    RandomShootSystem(1600),
    AutoMoveSystem(1800),
    AutoShootSystem(2000),
    HealthSystem(2200),
    CombatSystem(2400),
    HitSystem(2500),
    ChangeBehaviorSystem(2600),
    GroundMapLayerRenderSystem(2800),
    GroundLayerRenderSystem(3000),
    BulletLayerRenderSystem(3200),
    VehicleLayerRenderSystem(3400),
    ObstacleLayerRenderSystem(3600),
    ExplosionLayerRenderSystem(3800),
    BonusLayerRenderSystem(4000),
    CloudLayerRenderSystem(4200),
    BombLayerRenderSystem(4400),
    AirplaneLayerRenderSystem(4600),
    ViewUpdateSystem(4800),
    LifetimeSystem(5000),
    DestroyOnContactSystem(5200),
    DestroyOnContactLostSystem(5400),
    WorldLightRenderSystem(5600),
    WorldDebugRenderSystem(5800),
    WeatherSystem(6000),
    HudSystem(6200),
    RespawnSystem(6400),
    TimeUpdateSystem(6600),
    TimelineSystem(6800),
    DestroySystem(8000),
    NoEnemiesVictorySystem(9000),
    LevelEndSystem(9200),
    NoLifesDefeatSystem(9400),
    TimeEndDefeatSystem(9600),
    PlayerDestroyedResetSystem(9700),
    AutoSpawnerSystem(9800);

    private final int priority;

    SystemType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
