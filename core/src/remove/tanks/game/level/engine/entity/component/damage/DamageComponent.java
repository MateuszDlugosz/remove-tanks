package remove.tanks.game.level.engine.entity.component.damage;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class DamageComponent implements Component {
    public static final ComponentMapper<DamageComponent> MAPPER
            = ComponentMapper.getFor(DamageComponent.class);

    private final int damage;

    public DamageComponent(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
