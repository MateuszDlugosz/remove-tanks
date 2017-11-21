package remove.tanks.game.level.engine.entity.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableComponentFactory<T extends Component, U extends ComponentPrototype> {
    T createComponent(U prototype, Level level, Entity entity);
    Class<U> getFactoryType();
}
