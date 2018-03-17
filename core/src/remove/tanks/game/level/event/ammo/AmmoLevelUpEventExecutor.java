package remove.tanks.game.level.event.ammo;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.combat.AmmoComponent;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class AmmoLevelUpEventExecutor implements SubEventExecutor<AmmoLevelUpEvent> {
    @Override
    public void executeEvent(AmmoLevelUpEvent event, ResourceRegistry registry) {
        try {
            registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getEntitiesFor(EntityFamily.InputFamily.getFamily()).forEach(e -> {
                Optional.ofNullable(AmmoComponent.MAPPER.get(e)).ifPresent(c -> {
                    if (c.getCurrentLevel() < c.getMaxLevel()) {
                        e.add(new AmmoComponent(
                                c.getCurrentLevel() + 1,
                                c.getMaxLevel(),
                                c.getPrefabCodes()
                        ));
                    }
                });
            });
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<AmmoLevelUpEvent> getExecutorType() {
        return AmmoLevelUpEvent.class;
    }
}
