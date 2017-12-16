package remove.tanks.game.level.event.ammo;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.math.MathUtils;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.shoot.AmmoComponent;
import remove.tanks.game.level.event.RegistrableEventExecutor;

/**
 * @author Mateusz Długosz
 */
public final class AmmoUpEventExecutor
        implements RegistrableEventExecutor<AmmoUpEvent>
{
    @Override
    public void executeEvent(AmmoUpEvent event, Level level) {
        System.out.println(123);
        level.getResourceRegistry().getResource(LevelResource.Engine.toString(), Engine.class)
                .getEntitiesFor(EntityFamily.PlayerControlledFamily.getFamily())
                .forEach(e -> {
                    if (e.getComponent(AmmoComponent.class) != null) {
                        AmmoComponent ac = AmmoComponent.MAPPER.get(e);
                        e.add(
                                new AmmoComponent(
                                        MathUtils.clamp(ac.getCurrentLevel() + 1, 1, ac.getMaxLevel()),
                                        ac.getMaxLevel(),
                                        ac.getPrototypeCodes()
                                )
                        );
                    }
                });
    }

    @Override
    public Class<AmmoUpEvent> getExecutorType() {
        return AmmoUpEvent.class;
    }
}
