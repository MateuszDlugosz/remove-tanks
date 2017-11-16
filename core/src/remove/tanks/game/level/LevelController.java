package remove.tanks.game.level;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import remove.tanks.game.audio.sound.event.PlaySoundEvent;
import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityDestroyer;
import remove.tanks.game.level.engine.entity.EntityFactory;
import remove.tanks.game.level.engine.entity.EntitySpawner;
import remove.tanks.game.level.engine.event.*;
import remove.tanks.game.level.input.InputMapper;
import remove.tanks.game.utility.properties.Properties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class LevelController {
    private final Level level;

    private final Engine engine;
    private final InputMapper inputMapper;
    private final EventBus eventBus;
    private final Properties properties;

    private final EntitySpawner entitySpawner;
    private final EntityDestroyer entityDestroyer;
    private final EntityFactory entityFactory;

    private final List<DestroyEntityEvent> destroyEntityEvents = new ArrayList<>();
    private final List<SpawnEntityEvent> spawnEntityEvents = new ArrayList<>();
    private final List<PlaySoundEvent> playSoundEvents = new ArrayList<>();

    private boolean victory;
    private boolean defeat;

    public LevelController(
            Level level,
            EntitySpawner entitySpawner,
            EntityDestroyer entityDestroyer,
            EntityFactory entityFactory
    ) {
        this.level = level;
        this.entitySpawner = entitySpawner;
        this.entityDestroyer = entityDestroyer;
        this.entityFactory = entityFactory;
        this.engine = level.getResourceRegistry()
                .getResource(LevelResource.Engine.toString(), Engine.class);
        this.inputMapper = level.getResourceRegistry()
                .getResource(LevelResource.InputMapper.toString(), InputMapper.class);
        this.eventBus = level.getResourceRegistry()
                .getResource(LevelResource.EventBus.toString(), EventBus.class);
        this.properties = level.getResourceRegistry()
                .getResource(LevelResource.Properties.toString(), Properties.class);
        this.victory = false;
        this.defeat = false;
        this.eventBus.register(this);
    }

    public Level getLevel() {
        return level;
    }

    public InputMapper getInputMapper() {
        return inputMapper;
    }

    public void update(float delta, EventBus eventBus) {
        updateEngine(delta);
        resetInput();
        disposeEntities();
        placeEntities();
        delegatePlaySoundEvents(eventBus);
    }

    private void resetInput() {
        inputMapper.reset();
    }

    private void updateEngine(float delta) {
        engine.update(delta);
    }

    private void disposeEntities() {
        destroyEntityEvents.forEach(e -> entityDestroyer.disposeEntity(e.getEntity(), level));
        destroyEntityEvents.clear();
    }

    public void placeEntities() {
        spawnEntityEvents.forEach(e -> {
            Entity entity = entityFactory.createEntity(e.getEntityPrototype(), level);
            entitySpawner.placeEntity(entity, e.getPosition());
            engine.addEntity(entity);
        });
        spawnEntityEvents.clear();
    }

    private void delegatePlaySoundEvents(EventBus eventBus) {
        playSoundEvents.forEach(eventBus::post);
        playSoundEvents.clear();
    }

    public boolean isVictory() {
        return victory;
    }

    public boolean isDefeat() {
        return defeat;
    }

    @Subscribe
    public void handleDestroyEntityEvent(DestroyEntityEvent event) {
        destroyEntityEvents.add(event);
    }

    @Subscribe
    public void handleSpawnEntityEvent(SpawnEntityEvent event) {
        spawnEntityEvents.add(event);
    }

    @Subscribe
    public void handleModifyPropertyEvent(ModifyPropertyEvent event) {
        properties.putString(event.getLevelProperty().getName(), event.getNewValue());
    }

    @Subscribe
    public void handlePlaySoundEvent(PlaySoundEvent event) {
        playSoundEvents.add(event);
    }

    @Subscribe
    public void handleGameVictoryEvent(VictoryEvent event) {
        this.victory = true;
    }

    @Subscribe
    public void handleGameDefeatEvent(DefeatEvent event) {
        this.defeat = true;
    }
}
