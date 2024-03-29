package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class BonusRenderLayerComponent implements Component {
    public static final ComponentMapper<BonusRenderLayerComponent> MAPPER
            = ComponentMapper.getFor(BonusRenderLayerComponent.class);

    public static final BonusRenderLayerComponent INSTANCE = new BonusRenderLayerComponent();

    private BonusRenderLayerComponent() {}
}
