package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepository;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class BombersSpawnerComponentFactory
        implements RegistrableComponentFactory<BombersSpawnerComponent, BombersSpawnerComponentPrototype>
{
    @Override
    public BombersSpawnerComponent createComponent(BombersSpawnerComponentPrototype prototype, Level level, Entity entity) {
        return new BombersSpawnerComponent(
                level.getResourceRegistry().getResource(LevelResource.EntityPrototypeRepository.toString(),
                        EntityPrototypeRepository.class).getPrototype(prototype.getPrototypeCode())
        );
    }

    @Override
    public Class<BombersSpawnerComponentPrototype> getFactoryType() {
        return BombersSpawnerComponentPrototype.class;
    }
}
