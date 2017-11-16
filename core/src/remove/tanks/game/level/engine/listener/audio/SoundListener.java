package remove.tanks.game.level.engine.listener.audio;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.audio.sound.event.PlaySoundEvent;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.audio.SoundOnDestroyComponent;
import remove.tanks.game.level.engine.entity.component.audio.SoundOnSpawnComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.listener.ExtendedEntityListener;

/**
 * @author Mateusz Długosz
 */
public final class SoundListener extends ExtendedEntityListener {
    private final EventBus eventBus;
    private final Game2DCamera gameCamera;

    public SoundListener(EventBus eventBus, Game2DCamera gameCamera, Engine engine, int priority) {
        super(priority, EntityFamily.SoundableFamily.getFamily(), engine);
        this.eventBus = eventBus;
        this.gameCamera = gameCamera;
    }

    @Override
    public void entityAdded(Entity entity) {
        if (entity.getComponent(SoundOnSpawnComponent.class) != null) {
            PhysicsComponent pc = PhysicsComponent.MAPPER.get(entity);
            if (gameCamera.getCameraBoundaries().isInBoundaries(pc.getPosition())) {
                SoundOnSpawnComponent.MAPPER.get(entity).getSounds().forEach(s -> {
                    eventBus.post(new PlaySoundEvent(s));
                });
            }
        }
    }

    @Override
    public void entityRemoved(Entity entity) {
        if (entity.getComponent(SoundOnDestroyComponent.class) != null) {
            PhysicsComponent pc = PhysicsComponent.MAPPER.get(entity);
            if (gameCamera.getCameraBoundaries().isInBoundaries(pc.getPosition())) {
                SoundOnDestroyComponent.MAPPER.get(entity).getSounds().forEach(s -> {
                    eventBus.post(new PlaySoundEvent(s));
                });
            }
        }
    }
}
