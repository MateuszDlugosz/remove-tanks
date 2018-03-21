package remove.tanks.game.level.engine.system.input;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import remove.tanks.game.input.InputKey;
import remove.tanks.game.input.InputMapper;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.combat.AutoShootComponent;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponent;
import remove.tanks.game.level.engine.entity.component.input.InputComponent;
import remove.tanks.game.level.engine.entity.component.state.StateComponent;
import remove.tanks.game.level.utility.direction.Direction;
import remove.tanks.game.level.utility.state.State;

/**
 * @author Mateusz Długosz
 */
public final class InputSystem extends IteratingSystem {
    private final InputMapper inputMapper;

    public InputSystem(int priority, InputMapper inputMapper) {
        super(EntityFamily.InputFamily.getFamily(), priority);
        this.inputMapper = inputMapper;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        if (inputMapper.isKeyPressed(InputKey.Left)) {
            entity.add(new DirectionComponent(Direction.Left));
            entity.add(new StateComponent(State.Moving));
        } else if (inputMapper.isKeyPressed(InputKey.Right)) {
            entity.add(new DirectionComponent(Direction.Right));
            entity.add(new StateComponent(State.Moving));
        } else if (inputMapper.isKeyPressed(InputKey.Up)) {
            entity.add(new DirectionComponent(Direction.Up));
            entity.add(new StateComponent(State.Moving));
        } else if (inputMapper.isKeyPressed(InputKey.Down)) {
            entity.add(new DirectionComponent(Direction.Down));
            entity.add(new StateComponent(State.Moving));
        } else {
            entity.add(new StateComponent(State.Standing));
        }

        InputComponent ic = InputComponent.MAPPER.get(entity);
        ic.getTimer().update(deltaTime);

        if (inputMapper.isKeyPressed(InputKey.Shoot)) {
            if (ic.getTimer().isCompleted()) {
                entity.add(AutoShootComponent.INSTANCE);
                ic.getTimer().reset();
            }
        }
    }
}
