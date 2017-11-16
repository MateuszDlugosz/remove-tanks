package remove.tanks.game.level.engine.entity.component.faction;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class EnemyComponentFactory
        implements RegistrableComponentFactory<EnemyComponent, EnemyComponentPrototype>
{
    @Override
    public EnemyComponent createComponent(EnemyComponentPrototype prototype, Level level, Entity entity) {
        return new EnemyComponent();
    }

    @Override
    public Class<EnemyComponentPrototype> getFactoryType() {
        return EnemyComponentPrototype.class;
    }
}
