package remove.tanks.game.level;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import remove.tanks.game.audio.music.event.PlayMusicEvent;
import remove.tanks.game.audio.sound.event.PlaySoundEvent;
import remove.tanks.game.level.event.EventExecutor;
import remove.tanks.game.level.event.ammo.AmmoUpEvent;
import remove.tanks.game.level.event.destroy.DestroyAllEnemiesEvent;
import remove.tanks.game.level.event.destroy.DestroyEntityEvent;
import remove.tanks.game.level.event.enemy.DecreaseEnemiesCounterEvent;
import remove.tanks.game.level.event.life.AddLifeEvent;
import remove.tanks.game.level.event.life.RemoveLifeEvent;
import remove.tanks.game.level.event.points.AddPointsEvent;
import remove.tanks.game.level.event.points.IncreasePointsMultiplierEvent;
import remove.tanks.game.level.event.spawn.SpawnBomberEvent;
import remove.tanks.game.level.event.spawn.SpawnEntityEvent;
import remove.tanks.game.level.event.spawner.ActivateAutoSpawnerEvent;
import remove.tanks.game.level.event.state.ChangeLevelStateEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class LevelController {
    private final Level level;
    private final LevelUpdater levelUpdater;
    private final EventExecutor eventExecutor;

    private final List<Object> spawnEntityEvents = new ArrayList<>();
    private final List<Object> destroyEntityEvents = new ArrayList<>();
    private final List<Object> externalEvents = new ArrayList<>();
    private final List<Object> otherEvents = new ArrayList<>();

    LevelController(
            Level level,
            LevelUpdater levelUpdater,
            EventExecutor eventExecutor
    ) {
        this.level = level;
        this.levelUpdater = levelUpdater;
        this.eventExecutor = eventExecutor;
    }

    public Level getLevel() {
        return level;
    }

    public void update(float deltaTime, EventBus eventBus) {
        levelUpdater.updateLevel(deltaTime, level);
        eventExecutor.executeEvents(destroyEntityEvents, level);
        destroyEntityEvents.clear();
        eventExecutor.executeEvents(spawnEntityEvents, level);
        spawnEntityEvents.clear();
        eventExecutor.executeEvents(otherEvents, level);
        otherEvents.clear();
        externalEvents.forEach(eventBus::post);
        externalEvents.clear();
    }

    @Subscribe
    public void handleSpawnEntityEvent(SpawnEntityEvent event) {
        spawnEntityEvents.add(event);
    }

    @Subscribe
    public void handleDestroyEntityEvent(DestroyEntityEvent event) {
        destroyEntityEvents.add(event);
    }

    @Subscribe
    public void handlePlayMusicEvent(PlayMusicEvent event) {
        externalEvents.add(event);
    }

    @Subscribe
    public void handlePlaySoundEvent(PlaySoundEvent event) {
        externalEvents.add(event);
    }

    @Subscribe
    public void handleActivateAutoSpawnerEvent(ActivateAutoSpawnerEvent event) {
        otherEvents.add(event);
    }

    @Subscribe
    public void handleDecreaseEnemiesCounterEvent(DecreaseEnemiesCounterEvent event) {
        otherEvents.add(event);
    }

    @Subscribe
    public void handleAddLifeEvent(AddLifeEvent event) {
        otherEvents.add(event);
    }

    @Subscribe
    public void handleRemoveLifeEvent(RemoveLifeEvent event) {
        otherEvents.add(event);
    }

    @Subscribe
    public void handleAddPointsEvent(AddPointsEvent event) {
        otherEvents.add(event);
    }

    @Subscribe
    public void handleIncreasePointsMultiplierEvent(IncreasePointsMultiplierEvent event) {
        otherEvents.add(event);
    }

    @Subscribe
    public void handleChangeLevelStateEvent(ChangeLevelStateEvent event) {
        otherEvents.add(event);
    }

    @Subscribe
    public void handleDestroyAllEnemiesEvent(DestroyAllEnemiesEvent event) {
        otherEvents.add(event);
    }

    @Subscribe
    public void handleAmmoUpEvent(AmmoUpEvent event) {
        otherEvents.add(event);
    }

    @Subscribe
    public void handleSpawnBomberEvent(SpawnBomberEvent event) {
        otherEvents.add(event);
    }
}
