package remove.tanks.game.level.engine.entity.component.input;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class InputComponentFactory implements SubComponentFactory<InputComponent, InputComponentPrefab> {
    @Override
    public InputComponent createComponent(InputComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new InputComponent(
                    prefab.getShootDelay(),
                    createTimer(prefab.getShootDelay())
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    private Timer createTimer(float shootDelay) {
        return new Timer(shootDelay);
    }

    @Override
    public Class<InputComponentPrefab> getFactoryType() {
        return InputComponentPrefab.class;
    }
}
