package remove.tanks.game.level.engine.system.control;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.control.PlayerControlComponent;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponent;
import remove.tanks.game.level.engine.entity.component.shoot.AutoShootComponent;
import remove.tanks.game.level.engine.entity.component.state.StateComponent;
import remove.tanks.game.level.engine.utility.direction.Direction;
import remove.tanks.game.level.engine.utility.state.State;
import remove.tanks.game.level.input.InputMapper;

/**
 * @author Mateusz Długosz
 */
public final class PlayerControlSystem extends IteratingSystem {
    private final InputMapper inputMapper;

    public PlayerControlSystem(int priority, InputMapper inputMapper) {
        super(EntityFamily.PlayerControlledFamily.getFamily(), priority);
        this.inputMapper = inputMapper;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        if (inputMapper.isKeyPressed(InputMapper.Key.MoveLeft)) {
            entity.add(new DirectionComponent(Direction.Left));
            entity.add(new StateComponent(State.Moving));
        } else if (inputMapper.isKeyPressed(InputMapper.Key.MoveRight)) {
            entity.add(new DirectionComponent(Direction.Right));
            entity.add(new StateComponent(State.Moving));
        } else if (inputMapper.isKeyPressed(InputMapper.Key.MoveUp)) {
            entity.add(new DirectionComponent(Direction.Up));
            entity.add(new StateComponent(State.Moving));
        } else if (inputMapper.isKeyPressed(InputMapper.Key.MoveDown)) {
            entity.add(new DirectionComponent(Direction.Down));
            entity.add(new StateComponent(State.Moving));
        } else {
            entity.add(new StateComponent(State.Standing));
        }

        PlayerControlComponent pcc = PlayerControlComponent.MAPPER.get(entity);
        pcc.getTimer().update(deltaTime);

        if (inputMapper.isKeyPressed(InputMapper.Key.Shoot)) {
            if (pcc.getTimer().isCompleted()) {
                entity.add(new AutoShootComponent());
                pcc.getTimer().reset();
            }
        }
    }
}
