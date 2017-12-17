package remove.tanks.game.level.engine.system.camera;

import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.graphic.camera.effect.CameraEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class CameraEffectSystem extends EntitySystem {
    private final List<CameraEffect> effects;
    private final List<CameraEffect> effectsToRemove;
    private final Game2DCamera camera;

    public CameraEffectSystem(int priority, Game2DCamera camera) {
        super(priority);
        this.camera = camera;
        this.effects = new ArrayList<>();
        this.effectsToRemove = new ArrayList<>();
    }

    @Override
    public void update(float deltaTime) {
        effects.forEach(e -> {
            e.update(deltaTime, camera);
            if (e.isCompleted()) {
                effectsToRemove.add(e);
            }
        });
        effects.removeAll(effectsToRemove);
        effectsToRemove.clear();
    }

    public void addEffect(CameraEffect effect) {
        effects.add(effect);
    }
}
