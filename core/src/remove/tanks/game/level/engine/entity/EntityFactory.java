package remove.tanks.game.level.engine.entity;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class EntityFactory {
    private final ComponentFactory componentFactory;

    public EntityFactory(ComponentFactory componentFactory) {
        this.componentFactory = componentFactory;
    }

    public Entity createEntity(EntityPrototype prototype, Level level) {
        try {
            Entity entity = new Entity();
            prototype.getComponentPrototypes().values()
                    .forEach(c -> entity.add(componentFactory.createComponent(c, level, entity)));
            return entity;
        } catch (Exception e) {
            throw new EntityCreateException(prototype.getFilename(), e);
        }
    }
}
