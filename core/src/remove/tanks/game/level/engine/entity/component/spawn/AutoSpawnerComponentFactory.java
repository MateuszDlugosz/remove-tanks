package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerComponentFactory
        implements RegistrableComponentFactory<AutoSpawnerComponent, AutoSpawnerComponentPrototype>
{
    @Override
    public AutoSpawnerComponent createComponent(AutoSpawnerComponentPrototype prototype, Level level, Entity entity) {
        return new AutoSpawnerComponent(prototype.getLetter());
    }

    @Override
    public Class<AutoSpawnerComponentPrototype> getFactoryType() {
        return AutoSpawnerComponentPrototype.class;
    }
}
