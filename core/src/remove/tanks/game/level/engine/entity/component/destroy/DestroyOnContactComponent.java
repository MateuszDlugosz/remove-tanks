package remove.tanks.game.level.engine.entity.component.destroy;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class DestroyOnContactComponent implements Component {
    public static final ComponentMapper<DestroyOnContactComponent> MAPPER
            = ComponentMapper.getFor(DestroyOnContactComponent.class);

    private final Entity contactedWith;

    public DestroyOnContactComponent(Entity contactedWith) {
        this.contactedWith = contactedWith;
    }

    public Optional<Entity> getContactedWith() {
        return Optional.ofNullable(contactedWith);
    }
}
