package remove.tanks.game.level.engine.entity.component.faction;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class EnemyComponentFactory
        implements RegistrableComponentFactory<EnemyComponent, EnemyComponentPrototype>
{
    @Override
    public EnemyComponent createComponent(EnemyComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new EnemyComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<EnemyComponentPrototype> getFactoryType() {
        return EnemyComponentPrototype.class;
    }
}
